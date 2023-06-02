package com.zxw.user.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.zxw.user.dto.UserDto;
import com.zxw.user.dto.UserExcelDto;
import com.zxw.user.entity.User;
import com.zxw.user.excelListener.UserExcelDataListener;
import com.zxw.user.mapper.UserMapper;
import com.zxw.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxw.utils.ExcelUtil;
import com.zxw.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zxw
 * @since 2023-04-14
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean save(User entity) {
        boolean result = false;
        if(ObjectUtils.isNotEmpty(entity)){
            entity.setCreateTime(new Date());
            userMapper.insert(entity);
            result = true;
        }
        return result;
    }

    @Override
    public boolean update(User entity) {
        boolean result = false;
        if(ObjectUtils.isNotEmpty(entity)){
            userMapper.updateById(entity);
            result = true;
        }
        return result;
    }

    @Override
    public boolean deleteBatch(List<User> lists) {
        List<Integer> ids = lists.stream().map(m->{
            return m.getId();
        }).collect(Collectors.toList());
        int rows = userMapper.deleteBatchIds(ids);
        return rows > 0 ? Boolean.TRUE:Boolean.FALSE ;
    }

    @Override
    public Page<UserDto> queryPage(UserDto dto) {
        Page<UserDto> dtoPage = PageUtils.startPage(dto);
        Page<User> page = PageUtils.startPage(dto);
        page = userMapper.selectPage(page, new QueryWrapper<User>()
                .like(StringUtils.isNotBlank(dto.getUsername()), "username", dto.getUsername())
        );
        BeanUtils.copyProperties(page, dtoPage, "records");
        PageUtils.entityPageRecords2DtoPageRecords(page, dtoPage, UserDto::transfromBeanToDto);
        return dtoPage;
    }


    @Override
    public void exportExecl(HttpServletRequest request,HttpServletResponse response, User entity) {
        try {
                List<User> list = userMapper.selectList(new LambdaQueryWrapper<User>()
                        .like(StringUtils.isNotEmpty(entity.getUsername()), User::getUsername, entity.getUsername())
                );
                List<UserExcelDto> excelList = list.stream().map(m -> {
                    UserExcelDto excelDto = new UserExcelDto();
                    BeanUtils.copyProperties(m, excelDto);
                    return excelDto;
                }).collect(Collectors.toList());

                String fileName = "用户报表" + System.currentTimeMillis() + ".xlsx";
                ExcelUtil.setDownloadResponse(response, "用户报表" + System.currentTimeMillis(), "xlsx");
                // 默认写到指定路径下 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        //        EasyExcel.write(fileName, UserExcelDto.class).sheet("用户").doWrite(excelList);
                // 用户自己保存
                EasyExcel.write(response.getOutputStream(), UserExcelDto.class).sheet("用户报表").doWrite(excelList);

        } catch (Exception e) {
            log.error("导出报表异常，请检查报表格式和数据！", e);
        }
    }

    @Override
    public void importExcel(MultipartFile file, HttpServletResponse response) {
        List<UserExcelDto> excelList = Lists.newArrayList();
        try {
            EasyExcel.read(file.getInputStream(), UserExcelDto.class, new UserExcelDataListener(excelList,userMapper)).sheet().doRead();
        } catch (Exception e) {
            log.error("导入报表异常，请检查报表格式和数据！", e);
        }



    }

    @Override
    public List<User> queryList() {
        return userMapper.selectList(new QueryWrapper<User>());
    }


}

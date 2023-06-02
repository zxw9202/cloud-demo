package com.zxw.user.excelListener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.CellExtra;
import com.alibaba.excel.read.listener.ReadListener;
import com.google.common.collect.Lists;
import com.zxw.user.dto.UserExcelDto;
import com.zxw.user.entity.User;
import com.zxw.user.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Map;

/**
 * 读excel数据-监听类
 * @author zxw
 */
@Slf4j
public class UserExcelDataListener extends AnalysisEventListener<UserExcelDto> {

    private static final int BATCH_COUNT = 100;

    private List<User> cachedDataList = Lists.newArrayListWithExpectedSize(BATCH_COUNT);

    private final List<UserExcelDto> excelList;
    private final UserMapper userMapper;


    public UserExcelDataListener(List<UserExcelDto> excelList, UserMapper userMapper) {
        this.excelList = excelList;
        this.userMapper = userMapper;
    }

    /**
     * 读每行数据
     * @param data    每行数据，指定header会对应到field，否则返回LinkedHashMap
     * @param context
     */
    @Override
    public void invoke(UserExcelDto data, AnalysisContext context) {

        boolean flag = true;
        StringBuffer sb = new StringBuffer();
        //批量存储
//        User user = new User();
//        BeanUtils.copyProperties(data,user);
//        cachedDataList.add(user);
//        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
//        if (cachedDataList.size() >= BATCH_COUNT) {
//            saveData();
//            // 存储完成清理 list
//            cachedDataList = Lists.newArrayListWithExpectedSize(BATCH_COUNT);
//        }

        excelList.add(data);
            try {
                User entity = new User();
                BeanUtils.copyProperties(data, entity);
                String mainItemCode = entity.getUsername();
                if (StringUtils.isEmpty(mainItemCode)) {
                    sb.append("用户名不能为空！");
                    flag = false;
                }
                if(flag){
                    int saveResult = userMapper.insert(entity);
                    if(saveResult>0){
                        sb.append("success");
                    }
                }
                data.setReturnMessage(sb.toString());
            } catch (Exception e) {
                log.error("importExcelExection", e);
                data.setReturnMessage("error");
            }
    }

    /**
     * 读完所有行后执行
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
    }

    // 存储到数据库，批量存储
    private void saveData() {
        userMapper.saveBatch(cachedDataList);
    }


}

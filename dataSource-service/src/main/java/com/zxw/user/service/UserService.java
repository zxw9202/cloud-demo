package com.zxw.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxw.user.dto.UserDto;
import com.zxw.user.entity.User;
import com.zxw.user.entity.Video;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 18354
 * @since 2023-04-14
 */
public interface UserService extends IService<User> {


    List<User> queryUserList();

    List<Video> queryVideoList();

    List<User> queryBaseUserList();
}

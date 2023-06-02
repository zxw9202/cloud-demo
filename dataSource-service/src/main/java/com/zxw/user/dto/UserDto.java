package com.zxw.user.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zxw.entity.PageEntity;
import com.zxw.user.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.util.Date;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
@ApiModel(value="User对象", description="")
public class UserDto extends PageEntity {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String phone;

    private String pwd;

    private Integer sex;

    private String img;

    private Date createTime;

    @ApiModelProperty(value = "1是普通用户，2是管理员")
    private Integer role;

    private String username;

    private String wechat;


    public static UserDto  transfromBeanToDto(User user) {
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(user,dto);
        return dto;
    }
}

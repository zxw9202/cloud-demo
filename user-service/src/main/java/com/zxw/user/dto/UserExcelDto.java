package com.zxw.user.dto;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="UserExcel对象", description="")
public class UserExcelDto implements Serializable {

    @JsonIgnore
    @ExcelProperty(value = "返回信息", index = 0)
    @ApiModelProperty(value = "返回信息")
    private String returnMessage;

    @ExcelProperty(value = "手机号", index = 1)
    @ApiModelProperty(value = "手机号")
    private String phone;

    @ExcelIgnore
    private String pwd;

    @ExcelProperty(value = "性别", index = 2)
    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ExcelIgnore
    private String img;

    @ExcelIgnore
    private Date createTime;

    @ExcelProperty(value = "角色", index = 3)
    @ApiModelProperty(value = "1是普通用户，2是管理员")
    private Integer role;

    @ExcelProperty(value = "用户名", index = 4)
    @ApiModelProperty(value = "1是普通用户，2是管理员")
    private String username;

    @ExcelProperty(value = "微信", index = 5)
    @ApiModelProperty(value = "微信")
    private String wechat;
}

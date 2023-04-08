package com.zxw.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author issuser
 * @since 2023-04-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("video")
@ApiModel(value="Video对象", description="")
public class Video implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "视频标题")
    private String title;

    @ApiModelProperty(value = "概述")
    private String summary;

    @ApiModelProperty(value = "封面图")
    private String coverImg;

    @ApiModelProperty(value = "价格,分")
    private Integer price;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "默认8.7，最高10分")
    private Double point;

    @ApiModelProperty(value = "服务信息")
    private String serviceInfo;
}

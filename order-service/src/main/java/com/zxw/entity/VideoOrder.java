package com.zxw.entity;

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
@TableName("video_order")
@ApiModel(value="VideoOrder对象", description="")
public class VideoOrder implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "订单唯一标识")
    private String outTradeNo;

    @ApiModelProperty(value = "0表示未支付，1表示已支付")
    private Integer state;

    @ApiModelProperty(value = "订单生成时间")
    private Date createTime;

    @ApiModelProperty(value = "支付金额，单位分")
    private Integer totalFee;

    @ApiModelProperty(value = "视频主键")
    private Integer videoId;

    @ApiModelProperty(value = "视频标题")
    private String videoTitle;

    @ApiModelProperty(value = "视频图片")
    private String videoImg;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "服务信息")
    private String serviceInfo;

}

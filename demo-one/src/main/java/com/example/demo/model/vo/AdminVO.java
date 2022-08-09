package com.example.demo.model.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @description: 管理员信息表(Admin)实体类 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2022-05-14 12:23:18 <br>
 */

@ApiModel("管理员信息表model")
@Data
public class AdminVO {

    @ApiModelProperty(value = "管理员id")
    private Integer id;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "名称")
    private String username;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "类型")
    private Integer type;

    @ApiModelProperty(value = "类型", hidden = true)
    private String token;


    @ApiModelProperty(value = "创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;


}


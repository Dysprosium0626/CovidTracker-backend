package com.dysprosium.portal.model.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Dysprosium
 * @title: User
 * @projectName covidtracker
 * @description: TODO
 * @date 2022-05-2313:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "user")
@ApiModel(value = "User", description = "User Table")
public class User implements Serializable {

    @ApiModelProperty(value = "主键id")
    @TableId(value = "user_id", type = IdType.ASSIGN_ID)
    private String userId;

    @ApiModelProperty(value = "username")
    @NotEmpty(message = "username is not null")
    private String userName;

    @ApiModelProperty(value = "username")
    @NotEmpty(message = "username is not null")
    private String userPassword;

    @ApiModelProperty(value = "sex")
    private String userSex;

    @ApiModelProperty(value = "telephone number")
    private String userTel;

    @ApiModelProperty(value = "email")
    @NotEmpty(message = "username is not null")
    private String userEmail;


    @ApiModelProperty(value = "create time")
    @NotEmpty(message = "create time is not null")
    private Date createdTime;

    @ApiModelProperty(value = "update time")
    @NotEmpty(message = "update time is not null")
    private Date updatedTime;

    @ApiModelProperty(value = "logic delete")
    @TableLogic
    private Integer isDeleted;

    public User(String userId, String userName, String userPassword, String userSex, String userTel, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userSex = userSex;
        this.userTel = userTel;
        this.userEmail = userEmail;
    }
}

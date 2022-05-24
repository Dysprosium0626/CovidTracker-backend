package com.dysprosium.portal.model.VO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author Dysprosium
 * @title: UserAuthVO
 * @projectName covidtracker
 * @description: TODO
 * @date 2022-05-2314:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthVo implements Serializable {
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

    @ApiModelProperty(value = "email")
    @NotEmpty(message = "username is not null")
    private String verifyCode;

}

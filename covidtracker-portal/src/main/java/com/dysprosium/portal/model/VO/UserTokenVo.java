package com.dysprosium.portal.model.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Dysprosium
 * @title: UserTokenVo
 * @projectName covidtracker
 * @description: TODO
 * @date 2022-05-2314:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTokenVo implements Serializable {
    @ApiModelProperty("访问令牌")
    private String accessToken;

    @ApiModelProperty("用户对象信息")
    private UserInfoVo user;
}

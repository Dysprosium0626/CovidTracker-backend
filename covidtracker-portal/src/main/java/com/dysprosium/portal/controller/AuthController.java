package com.dysprosium.portal.controller;

import com.dysprosium.portal.model.VO.UserAuthVo;
import com.dysprosium.portal.model.VO.UserInfoVo;
import com.dysprosium.portal.model.VO.UserTokenVo;
import com.dysprosium.portal.service.Impl.UserServiceImpl;
import com.dysprosium.portal.util.MailServiceUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Dysprosium
 * @title: AuthController
 * @projectName covidtracker
 * @description: TODO
 * @date 2022-05-2315:57
 */

@Api(tags = "Registry-Login Module")
@Controller
@RestController
@CrossOrigin
public class AuthController {

    @Resource
    private MailServiceUtil mailServiceUtil;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Resource
    UserServiceImpl userService;


    @PostMapping("/sendCode")
    @ApiOperation(value = "发送邮件验证码", notes = "传入需要注册的邮箱")
    public boolean SendEmail(@RequestBody Map<String, Object> emailMap) {
        boolean sendEmail = userService.sendEmail(emailMap.get("to").toString());
        return sendEmail;
    }


    @PostMapping ("/registry")
    @ApiOperation(value = "registry", notes = "传入需要注册的学生Json和验证码")
    public UserInfoVo registry(@RequestBody UserAuthVo user) {
        userService.registry(user);
        UserInfoVo userInfoVo = new UserInfoVo(user.getUserId(), user.getUserName(), user.getUserSex(), user.getUserTel(), user.getUserEmail());
        return userInfoVo;
    }

    @PostMapping("/login")
    @ApiOperation(value = "login", notes = "传入帐号和密码")
    public UserTokenVo login(@RequestBody Map<String, Object> passwordMap) {
        UserTokenVo login = userService.login(passwordMap.get("userName").toString(), passwordMap.get("userPassword").toString());
        return login;
    }


}

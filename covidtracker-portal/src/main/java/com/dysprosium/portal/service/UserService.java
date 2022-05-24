package com.dysprosium.portal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dysprosium.portal.model.DO.User;
import com.dysprosium.portal.model.VO.UserAuthVo;
import com.dysprosium.portal.model.VO.UserInfoVo;
import com.dysprosium.portal.model.VO.UserTokenVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dysprosium
 * @title: UserService
 * @projectName covidtracker
 * @description: TODO
 * @date 2022-05-2314:00
 */
@Service
public interface UserService extends IService<User> {

    List<UserInfoVo> getAllUsers();
    UserInfoVo getUserById(String userId);
    UserInfoVo getUserByName(String userName);
    UserInfoVo getUserByEmail(String userEmail);

    int addUser(User user);



    // 登陆注册相关
    UserTokenVo login(String userName, String password);
    boolean checkEmailExist(String email);
    int registry(UserAuthVo user);
    boolean sendEmail(String to);





}

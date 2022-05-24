package com.dysprosium.portal.service.Impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dysprosium.portal.mapper.UserMapper;
import com.dysprosium.portal.model.DO.User;
import com.dysprosium.portal.model.VO.UserAuthVo;
import com.dysprosium.portal.model.VO.UserInfoVo;
import com.dysprosium.portal.model.VO.UserTokenVo;
import com.dysprosium.portal.service.UserService;
import com.dysprosium.portal.util.JwtUtil;
import com.dysprosium.portal.util.MailServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dysprosium
 * @title: UserServiceImpl
 * @projectName covidtracker
 * @description: TODO
 * @date 2022-05-2314:30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private MailServiceUtil mailServiceUtil;

    @Autowired
    private RedisServiceImpl redisService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public List<UserInfoVo> getAllUsers() {
        List<User> list = this.list();
        List<UserInfoVo> userInfoVos = new ArrayList<>();
        for (User user : list) {
            UserInfoVo userInfoVo = new UserInfoVo(user.getUserId(), user.getUserName(), user.getUserSex(), user.getUserTel(), user.getUserEmail());
            userInfoVos.add(userInfoVo);
        }
        return userInfoVos;
    }

    @Override
    public UserInfoVo getUserById(String userId) {
        User user = userMapper.selectById(userId);
        UserInfoVo userInfoVo = new UserInfoVo(user.getUserId(), user.getUserName(), user.getUserSex(), user.getUserTel(), user.getUserEmail());
        return userInfoVo;
    }

    @Override
    public UserInfoVo getUserByName(String userName) {
        User user = this.getOne(new QueryWrapper<User>().eq("user_name", userName));
        UserInfoVo userInfoVo = new UserInfoVo(user.getUserId(), user.getUserName(), user.getUserSex(), user.getUserTel(), user.getUserEmail());
        return userInfoVo;
    }

    @Override
    public UserInfoVo getUserByEmail(String userEmail) {
        User user = this.getOne(new QueryWrapper<User>().eq("user_email", userEmail));
        UserInfoVo userInfoVo = new UserInfoVo(user.getUserId(), user.getUserName(), user.getUserSex(), user.getUserTel(), user.getUserEmail());
        return userInfoVo;
    }

    @Override
    public int addUser(User user) {
        user.setUserPassword(BCrypt.hashpw(user.getUserPassword()));
        int insert = userMapper.insert(user);
        return insert;
    }

    @Override
    public UserTokenVo login(String userName, String password) {
        User user = this.getOne(new QueryWrapper<User>().eq("user_name", userName));
        if(ObjectUtil.isNull(user)) {
            return null;
        }
        boolean checkPassword = BCrypt.checkpw(password, user.getUserPassword());
        if(!checkPassword) {
            return null;
        }
        String token = jwtUtil.createToken(user.getUserEmail(), user.getUserName());
        UserTokenVo userTokenVo = new UserTokenVo();
        userTokenVo.setUser(new UserInfoVo(user.getUserId(), user.getUserName(), user.getUserSex(), user.getUserTel(), user.getUserEmail()));
        userTokenVo.setAccessToken(token);
        return userTokenVo;
    }

    @Override
    public boolean checkEmailExist(String email) {
        User user =  this.getOne(new QueryWrapper<User>().eq("user_email", email));
        if (ObjectUtil.isNull(user)) {
            return false;
        }
        return true;
    }

    @Override
    public int registry(UserAuthVo user) {
        System.out.println("注册用户"+user.toString());
        boolean emailExist = this.checkEmailExist(user.getUserEmail());
        if(emailExist)  return 0;
        System.out.println("检查邮箱不存在");
        String redisCode = (String) redisService.get(user.getUserEmail());
        if(ObjectUtil.isNull(redisCode)) {
            return 0;
        }
        System.out.println("检查验证码存在");
        int result;
        if(redisCode.equals(user.getVerifyCode())) {
            User addUser = new User(user.getUserId(), user.getUserName(), user.getUserPassword(), user.getUserSex(), user.getUserTel(), user.getUserEmail());
            System.out.println("加入用户"+addUser.toString());
            result = this.addUser(addUser);
        } else {
            return 0;
        }
        return result;
    }

    @Override
    public boolean sendEmail(String to) {
        try {
            String code = String.valueOf((int)((Math.random() * 9 + 1) * 100000));
            mailServiceUtil.sendMail("support@techtree.tech", to, "Verify Code", code);
            redisService.set(to, code, 300);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;

    }
}

package com.dysprosium.portal.controller;

import com.dysprosium.portal.model.VO.UserInfoVo;
import com.dysprosium.portal.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Dysprosium
 * @title: UserController
 * @projectName covidtracker
 * @description: TODO
 * @date 2022-05-2315:52
 */


@Api(tags = "User Module")
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    @ApiOperation(value = "Get all users", notes = "不需要传入任何参数")
    public List<UserInfoVo> getAllUsers() {
        List<UserInfoVo> allUsers = userService.getAllUsers();
        return allUsers;
    }

    @GetMapping("/id/{userId}")
    @ApiOperation(value = "Get user by id", notes = "user id")
    public UserInfoVo getUserById(@PathVariable  String userId) {
        UserInfoVo userById = userService.getUserById(userId);
        return userById;
    }


    @GetMapping("/name/{userName}")
    @ApiOperation(value = "Get user by name", notes = "user name")
    public UserInfoVo getUserByName(@PathVariable  String userName) {
        UserInfoVo userByName = userService.getUserByName(userName);
        return userByName;
    }


    @GetMapping("/email/{userEmail}")
    @ApiOperation(value = "Get user by email", notes = "user email")
    public UserInfoVo getUserByEmail(@PathVariable  String userEmail) {
        UserInfoVo userByEmail = userService.getUserByEmail(userEmail);
        return userByEmail;
    }





}

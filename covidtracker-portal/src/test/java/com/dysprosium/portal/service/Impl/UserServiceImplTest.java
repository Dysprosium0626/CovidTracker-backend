package com.dysprosium.portal.service.Impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dysprosium
 * @title: UserServiceImplTest
 * @projectName covidtracker
 * @description: TODO
 * @date 2022-05-2314:44
 */
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    void sendEmail() {
        boolean b = userService.sendEmail("1119493091@qq.com");
        System.out.println(b);

    }
}
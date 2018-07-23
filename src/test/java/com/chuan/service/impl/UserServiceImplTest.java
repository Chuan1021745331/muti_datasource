package com.chuan.service.impl;

import com.chuan.domain.UserDO;
import com.chuan.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:application.xml"})
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void saveTest(){
        UserDO userDO = new UserDO();
        userDO.setUsername("1111");
        userDO.setName("chuanhhhhh");
        userDO.setAge(18);
        userDO.setBalance(new BigDecimal(18.88d));
        boolean saveResult = userService.save(userDO);
        UserDO user = userService.findById(1);
        Assert.assertFalse(saveResult);
    }

    @Test
    public void classTest(){
        String simpleName = userService.getClass().getName();
        System.out.println(simpleName);
    }
}
package com.chuan.service.impl;

import com.chuan.annotation.DataSource;
import com.chuan.dao.UserDao;
import com.chuan.domain.UserDO;
import com.chuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @类名:
 * @包名: com.chuan.service.impl
 * @描述: (用一句话描述该文件做什么)
 * @日期: 2018/7/20 14:56
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @DataSource("write")
    @Override
    public boolean save(UserDO userDO) {

        return userDao.insert(userDO);
    }

    @DataSource("read")
    @Override
    public UserDO findById(int id) {
        return userDao.findById(id);
    }
}

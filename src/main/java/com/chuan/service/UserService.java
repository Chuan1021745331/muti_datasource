package com.chuan.service;

import com.chuan.domain.UserDO;

public interface UserService {
   boolean save(UserDO userDO);

   UserDO findById(int id);
}

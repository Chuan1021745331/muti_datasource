package com.chuan.dao;

import com.chuan.domain.UserDO;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    boolean insert(UserDO userDO);

    UserDO findById(@Param("id") int id);
}

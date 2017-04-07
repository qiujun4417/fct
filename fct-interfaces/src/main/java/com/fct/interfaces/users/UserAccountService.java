package com.fct.interfaces.users;

import com.fct.data.mysql.entity.UserEntity;

import java.util.List;

/**
 * Created by ningyang on 2017/4/6.
 * 用户服务
 */
public interface UserAccountService {

    boolean deleteUserAccount(UserEntity user);

    UserEntity findUserById(String id);

    List<UserEntity> findUserByName(String name, int start, int size);

    List<UserEntity> findUserByName(String name);

    UserEntity createUser(UserEntity userDto);
}

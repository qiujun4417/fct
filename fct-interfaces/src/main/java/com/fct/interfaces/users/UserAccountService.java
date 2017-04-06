package com.fct.interfaces.users;

import com.fct.interfaces.dto.user.UserDto;

import java.util.List;

/**
 * Created by ningyang on 2017/4/6.
 * 用户服务
 */
public interface UserAccountService {

    boolean deleteUserAccount(UserDto user);

    UserDto findUserById(String id);

    List<UserDto> findUserByName(String name, int start, int size);

    List<UserDto> findUserByName(String name);

    UserDto createUser(UserDto userDto);
}

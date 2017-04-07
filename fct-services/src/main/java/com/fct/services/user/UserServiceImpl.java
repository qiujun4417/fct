package com.fct.services.user;


import com.fct.data.mysql.entity.UserEntity;
import com.fct.data.mysql.repository.UserRepository;
import com.fct.interfaces.users.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ningyang on 2017/4/6.
 * 用户服务的实现类
 */
@Service(value = "userAccountService")
public class UserServiceImpl implements UserAccountService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean deleteUserAccount(UserEntity user) {
        userRepository.delete(user.getId());
        return true;
    }

    @Override
    public UserEntity findUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserEntity> findUserByName(String name, int start, int size) {
        return userRepository.findUserByPage(name, start, size);
    }

    @Override
    public List<UserEntity> findUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }
}

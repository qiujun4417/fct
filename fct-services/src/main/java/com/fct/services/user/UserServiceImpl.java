package com.fct.services.user;


import com.fct.data.mysql.entity.UserEntity;
import com.fct.data.mysql.repository.UserRepository;
import com.fct.interfaces.dto.user.UserDto;
import com.fct.interfaces.users.UserAccountService;
import com.fct.services.utils.DaoDtoConvertor;
import com.google.common.collect.Lists;
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
    public boolean deleteUserAccount(UserDto user) {
        userRepository.delete(user.getId());
        return true;
    }

    @Override
    public UserDto findUserById(String id) {
        return (UserDto) DaoDtoConvertor.dtoConvert(userRepository.findById(id));
    }

    @Override
    public List<UserDto> findUserByName(String name, int start, int size) {
        List<UserEntity> userEntities = userRepository.findUserByPage(name, start, size);
        List<UserDto> userDtos = Lists.newArrayList();
        for(UserEntity entity: userEntities){
            UserDto dto = (UserDto)DaoDtoConvertor.dtoConvert(entity);
            userDtos.add(dto);
        }
        return userDtos;
    }

    @Override
    public List<UserDto> findUserByName(String name) {
        List<UserEntity> userEntities = userRepository.findByName(name);
        List<UserDto> userDtos = Lists.newArrayList();
        for(UserEntity entity: userEntities){
            UserDto dto = (UserDto)DaoDtoConvertor.dtoConvert(entity);
            userDtos.add(dto);
        }
        return userDtos;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDto.getId());
        userEntity.setName(userDto.getName());
        return (UserDto)DaoDtoConvertor.dtoConvert(userRepository.save(userEntity));
    }
}

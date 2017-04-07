package com.fct.api.http.controller.user;

import com.fct.api.http.dto.json.JsonResponseEntity;
import com.fct.api.http.support.version.VersionRange;
import com.fct.data.mysql.entity.UserEntity;
import com.fct.interfaces.dto.user.UserDto;
import com.fct.interfaces.users.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ningyang on 2017/4/6.
 */
@RestController
@RequestMapping(value = "/api/account")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @VersionRange
    JsonResponseEntity<UserEntity> getUserById(@PathVariable String id){
        JsonResponseEntity<UserEntity> responseEntity = new JsonResponseEntity<>();
        responseEntity.setData(userAccountService.findUserById(id));
        return responseEntity;
    }
}

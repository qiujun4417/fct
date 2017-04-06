package com.fct.data.mysql.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ningyang on 2017/4/6.
 */
@Entity
@Table(name = "user")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserEntity {

    @Id
    @GeneratedValue(generator = "userIdGenerator")
    @GenericGenerator(name="userIdGenerator",strategy = "uuid")
    private String id;

    private String name;

}

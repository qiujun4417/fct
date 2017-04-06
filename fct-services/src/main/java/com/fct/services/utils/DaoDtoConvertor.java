package com.fct.services.utils;

import com.fct.common.utils.UUIDUtil;
import lombok.Data;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by ningyang on 2017/4/6.
 * DAO 转 DTO
 * 1 DAO和DTO的类属性名称必须一致
 * 2 DAO和DTO的分离主要是为了领域模型能够解耦, 各层之间包依赖解耦特别是data层和interfaces层
 */
public class DaoDtoConvertor {

    private final static String DTO_PACKAGE_PATH = "com.fct.interfaces.dto";

    /**
     * 通过反射来把DAO 转成DTO
     * @param source
     * @return
     */
    public static Object dtoConvert(Object source){
        String sourceClassName = source.getClass().getSimpleName();
        int index = sourceClassName.indexOf("Entity");
        String packageName = sourceClassName.substring(0,1).toLowerCase().concat(sourceClassName.substring(1, index));
        String targetClassName = DTO_PACKAGE_PATH.concat(".").concat(packageName).concat(".").concat(sourceClassName.replace("Entity", "Dto"));
        Object targetDto = null;
        try {
            targetDto = Class.forName(targetClassName).newInstance();
            Field[] sourceFields = source.getClass().getDeclaredFields();
            Method[] methods = targetDto.getClass().getDeclaredMethods();
            for(Field field: sourceFields){
                field.setAccessible(true);
                Object value = field.get(source);
                String sourceFieldName = field.getName();
                for(Method method: methods){
                    String targetMethodName = method.getName();
                    if(targetMethodName.startsWith("set")){
                        String var = targetMethodName.replace("set","");
                        String var1 = var.substring(0,1).toLowerCase().concat(var.substring(1));
                        if(sourceFieldName.equals(var1)){
                            method.invoke(targetDto, value);
                            break;
                        }
                    }
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return targetDto;
    }

    @Data
    static class UserEntity{
        private String id;
        private String name;
    }

    @Data
    static class UserDto{
        private String id;
        private String name;
    }

    /**
     * test only
     * @param args
     */
    public static void main(String[] args){
        UserEntity user = new UserEntity();
        user.setId(UUIDUtil.generateUUID());
        user.setName("nick");
        UserDto userDto = (UserDto)dtoConvert(user);
        System.out.println(userDto.getId() + " & " + userDto.getName());
    }
}

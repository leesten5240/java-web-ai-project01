package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select id, username, password, name, age from user")
    List<User> findAll();

    @Delete("delete from user where id = #{id}")
    Integer deleteById(Integer id);

    @Insert("insert into user(username,password,name,age) values(#{username},#{password},#{name},#{age}) ")
    void insert(User user);

    /**
     * 根据id更新用户信息
     */
    @Update("update user set username = #{username},password = #{password},name = #{name},age = #{age} where id = #{id}")
    void update(User user);

    /**
     * 根据用户名和密码查询用户信息
     */
    @Select("select * from user where username = #{username} and password = #{password}")
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);//@Param注解用于给参数取别名，从而实现和SQL中参数的匹配

}

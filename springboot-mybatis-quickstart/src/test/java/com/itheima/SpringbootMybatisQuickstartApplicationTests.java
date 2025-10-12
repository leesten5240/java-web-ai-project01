package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest//会在单元测试时加载springboot的环境
class SpringbootMybatisQuickstartApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Test
    public void testFindAll(){
        List<User> userList = userMapper.findAll();
        userList.forEach(System.out::println);//System.out::println=(user)->System.out.println(user);
    }

}

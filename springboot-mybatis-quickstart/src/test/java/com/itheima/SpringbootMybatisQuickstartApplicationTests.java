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

    /*
    * 测试查询所有
    * */
    @Test
    public void testFindAll(){
        List<User> userList = userMapper.findAll();
        userList.forEach(System.out::println);//System.out::println=(user)->System.out.println(user);
    }


    /*
    * 测试删除
    * */
    @Test
    public void testDeleteById(){
        Integer i = userMapper.deleteById(5);
        System.out.println("执行完毕后影响的记录数："+  i);
    }
    /*
     * 测试新增
     * */
    @Test
    public void testInsert(){
        User user = new User(null,"gaoyuanyuan","123456","高圆圆",18);
        userMapper.insert(user);
    }
    @Test
    public void testUpdate(){
        User user = new User(6,"gaoyuanyuan","123456","高圆圆",25);
        userMapper.update(user);
    }
    @Test
    public void testFindByUsernameAndPassword(){
        User user = userMapper.findByUsernameAndPassword("gaoyuanyuan", "123456");
        System.out.println(user);
    }
}

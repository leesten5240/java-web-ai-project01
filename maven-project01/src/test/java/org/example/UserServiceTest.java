package org.example;

import org.example.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("用户服务测试类")
public class UserServiceTest {

    @BeforeAll//每次测试类执行前执行一次
    public static void init(){
        System.out.println("初始化");
    }

    @AfterAll//每次测试类执行后执行一次
    public static void destroy(){
        System.out.println("销毁");
    }

    @BeforeEach//每次测试方法执行前执行一次
    public void initEach(){
        System.out.println("初始化每个测试方法");
    }

    @AfterEach//每次测试方法执行后执行一次
    public void destroyEach(){
        System.out.println("销毁每个测试方法");
    }


    @Test
    public void testGetAge(){
        UserService userService = new UserService();
        Integer age = userService.getAge("110101199001011234");
        System.out.println(age);
    }

    @Test
    public void testGetGender(){
        UserService userService = new UserService();
        String gender = userService.getGender("110101199001011234");
        System.out.println(gender);
    }

    @Test
    public void testGetGenderWithAssert(){
        UserService userService = new UserService();
        String gender = userService.getGender("110101199001011234");
        //断言
        Assertions.assertEquals("男", gender,"性别获取错误");
    }

    @Test
    public void testGetGenderWithAssert2(){
        UserService userService = new UserService();
        String gender = userService.getGender("110101199001011234");
        //断言
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            userService.getGender(null);
        });
    }

    /**
     * 参数化测试
     */
    @DisplayName("性别获取测试")
    @ParameterizedTest
    @ValueSource(strings = {"110101199001011234","110101199001011235","110101199001011236"})
    public void testGetGender2(String idCard){
        UserService userService = new UserService();
        String gender = userService.getGender(idCard);
        //断言
        Assertions.assertEquals("男", gender,"性别获取错误");
    }
}


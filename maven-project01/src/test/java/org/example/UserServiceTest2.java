package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//企业测试规范
public class UserServiceTest2 {
    private UserService userService;

    @BeforeEach
    public void init(){
        userService = new UserService();
    }

    /**
     * 测试获取性别 -null
     */
    @Test
    @DisplayName("性别获取测试-null值")
    public void testGetGenderWithNull(){
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            userService.getGender(null);
        });
    }

    /**
     * 测试获取性别 -空字符串
     */
    @Test
    @DisplayName("性别获取测试-空字符串")
    public void testGetGenderWithEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            userService.getGender("");
        });
    }

    /**
     * 测试获取性别 -长度小于18位
     */
    @Test
    @DisplayName("性别获取测试-长度小于18位")
    public void testGetGenderWithLengthLessThan18(){
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            userService.getGender("110");
        });
    }

    /**
     * 测试获取性别 -长度大于18位
     */
    @Test
    @DisplayName("性别获取测试-长度大于18位")
    public void testGetGenderWithLengthGreaterThan18(){
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            userService.getGender("1101011990012313131210112345");
        });
    }

    /**
     * 测试获取性别 -正常男
     */
    @Test
    @DisplayName("性别获取测试-正常男")
    public void testGetGenderWithNormalMale(){
        String gender = userService.getGender("110101199001011234");
        Assertions.assertEquals("男", gender);
    }

    /**
     * 测试获取性别 -正常女
     */
    @Test
    @DisplayName("性别获取测试-正常女")
    public void testGetGenderWithNormalFemale(){
        String gender = userService.getGender("110101199001011245");
        Assertions.assertEquals("女", gender);
    }

    //--------------------------测试年龄--------------------------
    @Test
    @DisplayName("年龄获取测试-正常")
    public void testGetAgeWithNormal(){
        Integer age = userService.getAge("110101199001011234");
        Assertions.assertEquals(35, age);
    }

    @Test
    @DisplayName("年龄获取测试-null")
    public void testGetAgeWithNull(){
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            userService.getAge(null);
        });
    }

    @Test
    @DisplayName("年龄获取测试-空字符串")
    public void testGetAgeWithEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            userService.getAge("");
        });
    }

    @Test
    @DisplayName("年龄获取测试-长度小于18位")
    public void testGetAgeWithLengthLessThan18(){
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            userService.getAge("110");
        });
    }

    @Test
    @DisplayName("年龄获取测试-长度大于18位")
    public void testGetAgeWithLengthGreaterThan18(){
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            userService.getAge("1101011990012313131210112345");
        });
    }
}

package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data //能够自动为实体类创建getter和setter方法
@NoArgsConstructor
@AllArgsConstructor//分别为实体类创建无参和全参构造函数
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer age;
    private LocalDateTime updateTime;
}

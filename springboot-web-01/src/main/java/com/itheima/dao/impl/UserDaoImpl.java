package com.itheima.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.itheima.dao.UserDao;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public List<String> findAll() {
        //1. 加载并读取user.txt文件，获取用户数据
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");//加载resource目录下的文件
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8 , new ArrayList<>());//使用hutool工具类读取文件
        return lines;
    }
}

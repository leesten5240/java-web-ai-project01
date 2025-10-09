package com.itheima;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
    @Test
    public void testUpdate() throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        String url="jdbc:mysql://localhost:3306/web01";
        String username="root";
        String password=System.getenv("MYSQL_PWD");
        System.out.println(password);
        Connection connection = DriverManager.getConnection(url,username,password);

        //3.获取SQL语句执行对象
        Statement statement = connection.createStatement();
        //4.执行SQL语句
        int i = statement.executeUpdate("update user set age = 25 where id = 1");//DML
        System.out.println("SQL语句执行完毕后影响的记录数为：" + i);
        //5.释放资源
        statement.close();
        connection.close();
    }
}

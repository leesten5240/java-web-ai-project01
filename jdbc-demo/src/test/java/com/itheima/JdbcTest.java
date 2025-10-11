package com.itheima;

import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;

import java.sql.*;

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

    @Test
    public void testQuery(){
        String url="jdbc:mysql://localhost:3306/web01";
        String username="root";
        String password=System.getenv("MYSQL_PWD");

        Connection connection = null;
        PreparedStatement statement =  null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
            String sql = "select id, username, password, name, age from user where username = ? and password = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,"daqiao");
            statement.setString(2,"123456");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getInt("age")
                );
                System.out.println(user);//Lombok 注解自动生成toString()方法
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(resultSet != null) resultSet.close();
                if(statement != null) statement.close();
                if(connection != null) connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

package com.day7jdbc2;

import com.day6jdbc1.Dog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class JdbcTest3 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("藏獒1","公"));
        dogs.add(new Dog("藏獒2","公"));
        dogs.add(new Dog("藏獒3","公"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//java的反射机制加载驱动，创建Driver对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/2105a", "root", "root");

            String sql = "insert into dog values(null,?,?)";
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < dogs.size(); i++) {//重复利用预编译，循环一次，添加一条，提高效率
                Dog d = dogs.get(i);
                ps.setString(1,d.getName());
                ps.setString(2,d.getSex());
                ps.execute();//提交数据
            }



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
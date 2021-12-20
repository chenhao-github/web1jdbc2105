package com.day7jdbc2;

import com.day6jdbc1.Dog;

import java.sql.*;
import java.util.ArrayList;

public class JdbcTest2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//java的反射机制加载驱动，创建Driver对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/2105a","root","root");
            System.out.println("连接成功");
            String name = "泰'迪";
            String sex = "公";

            String sql = "insert into dog values(null,?,?)";
            String sql2 = "update dog set name=? where id=?";
            String sql3 = "delete from dog where id=?";

            ps = conn.prepareStatement(sql);//预编译sql语句

            ps.setString(1,name);//给第一个? 赋值，给那个坑填数据
            ps.setString(2,sex);

            ps.execute();//提交sql，执行
            System.out.println("插入成功");

            //查询
            ArrayList<Dog> dogs = new ArrayList<>();
            String sql4 = "select * from dog where name like ?";
            ps = conn.prepareStatement(sql4);//预编译查询sql
            ps.setString(1,"%哮%");
            ResultSet rs = ps.executeQuery();//执行sql，得到结果集
            while(rs.next()){
                int id = rs.getInt(rs.findColumn("id"));
                String _name = rs.getString(rs.findColumn("name"));
                String _sex = rs.getString(rs.findColumn("sex"));

                dogs.add(new Dog(id,_name,_sex));
            }
            System.out.println(dogs);


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(ps != null)
                    ps.close();
                if(conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

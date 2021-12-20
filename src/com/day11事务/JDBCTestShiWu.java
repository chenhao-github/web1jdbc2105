package com.day11事务;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTestShiWu {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/2105a", "root", "root");
            System.out.println("连接成功");

            conn.setAutoCommit(false);//设置自动提交为假，关闭自动提交
            String sql0 = "insert into dog values(null,'火狐','男')";
            PreparedStatement ps0 = conn.prepareStatement(sql0);
            ps0.execute();

            String sql1 = "inser into dog values('哈哈','mm')";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.execute();

            conn.commit();//手动提交
        } catch (Exception e) {
            e.printStackTrace();
            try {
                //一旦出现异常，回滚sql
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

    }
}

package com.day8jdbcutils;

import com.day6jdbc1.Dog;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtils {
//    private static String url = "jdbc:mysql://localhost:3306/2105a";
//    private static String user = "root";
//    private static String password = "root";
    private static Connection conn ;
    static Properties pt;
    //通过静态代码块，第一时间获得数据库连接
    static {
        try {
            //解析加载db.properties配置文件
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
            pt = new Properties();
            pt.load(is);
            String driver = pt.getProperty("driver");//得到驱动
            Class.forName(driver);//加载驱动
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
    //返回一个数据库连接，谁用谁调
    public static Connection getConn(){
        String url = pt.getProperty("url");//得到url
        String user = pt.getProperty("user");//得到user账号
        String password = pt.getProperty("password");//得到password密码
        try {
            conn = DriverManager.getConnection(url,user,password);//获得连接
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return conn;
    }
    //添加方法  添加一条狗
    public static void insert(Dog dog){
        Connection conn = getConn();//获得连接
        PreparedStatement ps = null;
        String sql = "insert into dog values(null,?,?)";
        try {
            ps  = conn.prepareStatement(sql);
            ps.setString(1,dog.getName());
            ps.setString(2,dog.getSex());
            ps.execute();//提交sql
            System.out.println("添加成功");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if(ps != null)
                    ps.close();
                if(conn != null)
                    conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    //修改一条狗
    public static void update(Dog dog){
        Connection conn = getConn();
        PreparedStatement ps = null;
        String sql = "update dog set name=?,sex=? where id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,dog.getName());
            ps.setString(2,dog.getSex());
            ps.setInt(3,dog.getId());

            ps.execute();
            System.out.println("修改成功");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if(ps != null) ps.close();
                if(conn != null) conn.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //删除一条狗
    public static void delete(int id){
        Connection conn = getConn();
        PreparedStatement ps = null;
        String sql = "delete from dog where id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);

            ps.execute();
            System.out.println("删除成功");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if(ps != null) ps.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //查询狗
    public static List<Dog> query(String name){
        Connection conn = getConn();
        PreparedStatement ps = null;
        List<Dog> dogs = new ArrayList<>();

        try {
            if("".equals(name) || null==name){//查询条件为空，全查
                String sql = "select * from dog";
                ps = conn.prepareStatement(sql);
            }else {//查询条件不为空，模糊查询
                String sql = "select * from dog where name like ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,"%"+name+"%");
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt(rs.findColumn("id"));
                String _name = rs.getString(rs.findColumn("name"));
                String _sex = rs.getString(rs.findColumn("sex"));

                dogs.add(new Dog(id,_name,_sex));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if(ps != null) ps.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dogs;
    }
}

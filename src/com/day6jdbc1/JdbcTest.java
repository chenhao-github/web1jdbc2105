package com.day6jdbc1;

import java.sql.*;
import java.util.ArrayList;

/**
 * jdbc 6步
 * 1.加载驱动
 * 2.获得数据库连接,通过 url,name,password
 * 3.编写sql语句
 * 4.获得statement
 * 5.执行sql语句
 * 6.处理结果集和ResultSet
 */
public class JdbcTest {
    public static void main(String[] args) {

        Connection conn = null;
        Statement stat = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//  1加载驱动
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/2105a", "root", "root");//2 获得连接
            System.out.println("连接成功");

//            String sql = "insert into dog(id,name,sex) values(1,'哮天犬','公')";//3 sql  id不会自增，自己给
//            String sql = "insert into dog(id,name,sex) values(null,'哮天犬2','公')";//3 sql  id自增
//            String sql = "insert into dog values(null,'哮天犬3','公')";//3 sql  id自增
//            String sql = "insert into dog(name) values('哮天犬4')";
//            String sql = "insert into dog values(null,'哮天犬5','公'),(null,'旺财','母')";


//            String sql = "update dog set sex='母' where id=1";//修改语句
//            String sql = "delete from dog where id=1";//删除
            stat = conn.createStatement();//4 通过conn连接得到Statement（Statement是用来执行sql的）

//            stat.execute(sql);//5 执行sql

            System.out.println("成功");

            ArrayList<Dog> dogs = new ArrayList<>();//创建存放所有狗的容器
            //查询
            String sql = "select * from dog";
            ResultSet rs = stat.executeQuery(sql);//查询得到结果集
            while (rs.next()){//next 返回有没有下一个， true有  false没有
//                int id = rs.getInt(1);//1号下标  id
//                String name = rs.getString(2);//2  name
//                String sex = rs.getString(3);//3 sex
                int id = rs.getInt(rs.findColumn("id"));//1号下标  id
                String name = rs.getString(rs.findColumn("name"));//2  name
                String sex = rs.getString(rs.findColumn("sex"));//3 sex
                //封装成dog对象，存放到lsit集合中
                Dog d = new Dog(id,name,sex);
                dogs.add(d);//收集狗
            }
            System.out.println(dogs);
            //打印list集合查询数据库数据


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(stat != null) //关闭
                    stat.close();
                if(conn != null) //关闭
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

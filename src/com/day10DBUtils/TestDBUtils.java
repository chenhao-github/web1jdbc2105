package com.day10DBUtils;

import com.day6jdbc1.Dog;
import com.day9jdbcutils2.JDBCUtils2;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class TestDBUtils {
    public static void main(String[] args) {
        //创建 QueryRunner
        ComboPooledDataSource dataSource = JDBCUtils2.getDataSource();
        QueryRunner qr = new QueryRunner(dataSource);
        //添加     update方法实现增删改
        try {
//            String sql = "insert into dog values(null,?,?)";
//            qr.update(sql,"旺财2","公");
//            System.out.println("添加成功");

//            String sql = "update dog set sex=? where id=?";
//            qr.update(sql,"母",1);
//            System.out.println("修改成功");

//            String sql = "delete from dog where id=?";
//            qr.update(sql,1);
//            System.out.println("删除成功");

            //查询

            //1. BeanListHandler  得到数据的集合，多条
            String sql = "select * from dog ";
            List<Dog> dogs = qr.query(sql, new BeanListHandler<Dog>(Dog.class));
            System.out.println(dogs);

            System.out.println(111);
            System.out.println(999);
            System.out.println(555);
            System.out.println("aaa");
            // 2.MapListHandler
//            List<Map<String, Object>> maps = qr.query(sql, new MapListHandler());
//            System.out.println(maps.get(0).get("name"));

//            String sql = "select * from dog where id=?";
            //3 MapHandler   得到一条数据的封装成Map
//            Map<String, Object> map = qr.query(sql, new MapHandler(),3);
//            System.out.println(map.get("name"));

            //4.BeanHandler 得到一条数据的对象
//            Dog dog = qr.query(sql, new BeanHandler<Dog>(Dog.class), 3);
//            System.out.println(dog.getName());

            //5.ColumnListHandler  得到多条数据中每条的一个字段的值 比如 name名字字段的值
//            List<Object> names = qr.query(sql, new ColumnListHandler("name"));
//            System.out.println(names.get(0));

            //6.ScalarHandler  结合聚合函数使用
            String sql2 = "select count(*) from dog";
            Object query = qr.query(sql, new ScalarHandler());
            int sum = (int) query;
            System.out.println(sum);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}

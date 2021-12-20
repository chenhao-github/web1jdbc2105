package com.day8jdbcutils;

import com.day6jdbc1.Dog;
import jdk.nashorn.internal.scripts.JD;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class TestUtils {
    public static void main(String[] args) {
//        Dog dog = new Dog("阿拉斯加1", "公");
//        JDBCUtils.insert(dog);
        Scanner scanner = new Scanner(System.in);
//        while (true){
//            System.out.print("请输入狗的名字:");
//            String name = scanner.next();
//            if("886".equals(name)) break;
//
//            System.out.print("请输入狗的性别:");
//            String sex = scanner.next();
//            if("886".equals(name)) break;
//
//            Dog dog = new Dog(name, sex);//封装成狗对象
//            JDBCUtils.insert(dog);//添加
//        }

//        Dog dog = new Dog(1, "哮天犬-新", "公-新");//把id为1的那条狗修改修改掉
//        JDBCUtils.update(dog);
//
//        JDBCUtils.delete(1);

        List<Dog> dogs = JDBCUtils.query("拉");
        System.out.println(dogs);
    }
}

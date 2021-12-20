package com.day12反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Test12 {
    public static void main(String[] args) throws Exception {
//        Class cls = Dog.class;//得到最大最高层的类别，是所有具体类别的抽象统称，全类
//        Class cls2 = String.class;
//
//        Dog d1 = new Dog("旺财1");
//            d1.getName();
//
//        Dog d2 = new Dog("旺财2");
//            d2.getName();
//        Class cls = Dog.class;//得到狗类这个具体的数据类型（数据类型Class是java所有的具体数据类型的总类）
        Class cls = Class.forName("com.day6jdbc1.Dog");

        //得到Dog类的无参构造
        Constructor<?> constructor1 = cls.getConstructor();
//        Object o = constructor1.newInstance();//通过无参构造创建dog的对象
//        Dog d = (Dog) o;
//        d.setName("火狐");
//        System.out.println(d);

        //得到Dog类的有参的构造  1个参数
//        Constructor constructor2 = cls.getConstructor(String.class);//得到1个参数的有参构造，String.class是参数的类别
//        Object o2 = constructor2.newInstance(new Object[]{"旺财2"});
//        Dog d2 = (Dog) o2;
//        System.out.println(d2);


//        //得到Dog类的有参的构造  2个参数
//        Constructor constructor3 = cls.getConstructor(new Class[]{String.class,String.class});//得到2个参数的有参构造，String.class是参数的类别
//        Object o3 = constructor3.newInstance(new Object[]{"旺财3","公"});
//        Dog d3 = (Dog) o3;
//        System.out.println(d3);

        //通过反射得到属性对象  name  sex
//        Object o = constructor1.newInstance();//通过无参构造创建dog的对象
//        Field name = cls.getDeclaredField("name");//私有的name属性   通过反射解析的Dog类得到的Class中保持了Dog的类信息,,然后得到name这个具体的属性对象
//        Field sex = cls.getField("sex");//公有的sex属性
//
//        name.setAccessible(true);//私有属性要设置可以访问，才能使用赋值
//        name.set(o,"哮天犬");//通过name方法对象给o狗对象的name属性赋值，反过来操作"
//        sex.set(o,"公");//通过sex方法对象给o狗对象的sex属性赋值，反过来操作"
//        System.out.println(o);

        //通过反射得到方法
        Object o = constructor1.newInstance();//通过无参构造创建dog的对象
        Method setName = cls.getMethod("setName",String.class);//得到公有的 setName方法
        setName.invoke(o,"旺财3");//通过setName方法对象反过来 使用o对象，给o的name属性赋值
        System.out.println(o);
        Method getName = cls.getMethod("getName");
        Object name = getName.invoke(o);
        System.out.println(name);

    }
}

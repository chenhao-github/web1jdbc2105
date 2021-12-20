package com.day13enum;

//周枚举类
public enum Weeks {
    //添加枚举对象 7枚
    Monday("周一"),Tuesday("周二"), Wensday("周三"), Thursday("周四"),
    Friday("周五"), Satarday("周六"), Sunday("周日");

    private String name;

    //构造器私有化，隐藏起来，此类的外部不能随意创建对象，所以有效控制对象的数量
    private Weeks(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Weeks{" +
                "name='" + name + '\'' +
                '}';
    }
}

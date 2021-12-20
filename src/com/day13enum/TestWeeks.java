package com.day13enum;

public class TestWeeks {
    public static void main(String[] args) {
        System.out.println(Weeks.Monday);//打印对象，默认调用toString  Monday
        System.out.println(Weeks.Monday.name());//打印枚举对象的名字 Monday
        System.out.println(Weeks.Monday.getName());//获得名字属性，并打印

        System.out.println(Weeks.Monday.compareTo(Weeks.Tuesday));

        //获得枚举类中的所有枚举对象，更灵活
        Weeks[] values = Weeks.values();
        for (int i = 0; i < values.length; i++) {
            Weeks w = values[i];
            System.out.println(w.getName());
        }
    }
}

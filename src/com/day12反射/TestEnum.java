package com.day12反射;

public class TestEnum {
    public static void main(String[] args) {
//        Weeks w = Weeks.Monday;
        Weeks w = Weeks.valueOf("Monday");
        System.out.println(w.getName());

        Weeks[] values = Weeks.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i].getName());
        }

        System.out.println(Weeks.Monday.name());
        System.out.println(Weeks.Monday.ordinal());
        System.out.println(Weeks.Monday.compareTo(Weeks.Tuesday));
    }
}

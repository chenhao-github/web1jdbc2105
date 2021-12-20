package com.day9jdbcutils2;

import com.day6jdbc1.Dog;
import com.day8jdbcutils.JDBCUtils;

import java.util.List;
import java.util.Scanner;

public class TestUtils2 {
    public static void main(String[] args) {

        List<Dog> dogs = JDBCUtils2.query("拉");
        System.out.println(dogs);
    }
}

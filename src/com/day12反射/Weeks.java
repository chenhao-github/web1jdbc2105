package com.day12反射;

public enum Weeks {
    Monday("1"), Tuesday("2");
    private String name;

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

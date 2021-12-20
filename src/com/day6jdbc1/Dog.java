package com.day6jdbc1;

import java.util.Objects;

public class Dog {
    private int id;
    private String name;
    public String sex;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public Dog(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public Dog(int id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return id == dog.id && Objects.equals(name, dog.name) && Objects.equals(sex, dog.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}

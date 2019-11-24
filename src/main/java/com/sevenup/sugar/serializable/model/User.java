package com.sevenup.sugar.serializable.model;

import java.io.Serializable;
import java.util.Date;

public class User extends Human implements Serializable {
    public String name;
    public int age;
    public Date birthday;
    public Address address;

    public User() {
        System.out.println("User Constructor");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", address=" + address +
                '}';
    }
}

package com.sevenup.sugar.serializable.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by nonumber1989 on 2019/11/23.
 */
public class User implements Serializable {
    private String name;
    private int age;
    private Date birthday;
    private Address address;

    public User() {
        System.out.println("User Constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

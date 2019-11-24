package com.sevenup.sugar.serializable.model;

import java.io.Serializable;

public class Address implements Serializable {
    public String city;
    transient public Long code;

    public Address() {
        System.out.println("Address Constructor");
    }

    public Address(String city, Long code) {
        this.city = city;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", code=" + code +
                '}';
    }
}

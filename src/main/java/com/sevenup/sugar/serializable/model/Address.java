package com.sevenup.sugar.serializable.model;

import java.io.Serializable;

/**
 * Created by nonumber1989 on 2019/11/23.
 */
public class Address implements Serializable {
    private String city;
    private String country;
    private Long code;

    public Address() {
        System.out.println("Address Constructor");
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", code=" + code +
                '}';
    }
}

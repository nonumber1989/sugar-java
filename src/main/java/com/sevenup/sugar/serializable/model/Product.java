package com.sevenup.sugar.serializable.model;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created by nonumber1989 on 2019/11/23.
 */
public class Product implements Serializable {
    private String name;
    private Double price;
    private int count;

    public Product() {
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        System.out.println("writeObject");
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        System.out.println("readObject");
    }

    private void readObjectNoData() throws ObjectStreamException {
        System.out.println("readObjectNoData");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

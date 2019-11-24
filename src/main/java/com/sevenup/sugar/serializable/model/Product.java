package com.sevenup.sugar.serializable.model;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class Product implements Serializable {
    public final String id = "productID";
    public String name;
    public Double price;
    public int count;

    public Product() {
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        System.out.println("writeObject");
        out.writeObject(new StringBuffer(this.name).reverse());
        out.writeDouble(this.price + 100);
        out.writeInt(count - 10);
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.name = ((StringBuffer) in.readObject()).reverse().toString();
        this.price = in.readDouble() - 100;
        this.count = in.readInt() + 10;
        System.out.println("readObject");
    }

    private void readObjectNoData() throws ObjectStreamException {
        System.out.println("readObjectNoData");
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}

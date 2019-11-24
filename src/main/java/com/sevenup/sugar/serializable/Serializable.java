package com.sevenup.sugar.serializable;

import com.sevenup.sugar.serializable.model.Product;

import java.io.*;

/**
 * Created by nonumber1989 on 2019/11/23.
 */
public class Serializable {

    public static final String PRODUCT_FILE_PATH = "product.txt";

    public static void main(String[] args) {
//        writeProductToFile();
//        readProductToFile();
    }

    public static void writeProductToFile() {
        File file = new File(PRODUCT_FILE_PATH);
        try (FileOutputStream fileOutputStream = new FileOutputStream(PRODUCT_FILE_PATH);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            Product productOne = new Product();
            productOne.count = 10;
            productOne.name = "computer";
            productOne.price = 2000.10;
            objectOutputStream.writeObject(productOne);

            System.out.println("write product one length is " + file.length());

            productOne.count = 20;
            productOne.price = 3000.10;
            objectOutputStream.writeObject(productOne);

            System.out.println("write product one again length is " + file.length());

            Product productTwo = new Product();
            productTwo.count = 100;
            productTwo.name = "computer";
            productTwo.price = 100.10;
            objectOutputStream.writeObject(productTwo);

            System.out.println("write product two length is " + file.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readProductToFile() {
        try (FileInputStream fileInputStream = new FileInputStream(PRODUCT_FILE_PATH);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Product productOne = (Product) objectInputStream.readObject();
            System.out.println(productOne.toString());
            Product productCopy = (Product) objectInputStream.readObject();
            System.out.println(productCopy.toString());

            Product productTwo = (Product) objectInputStream.readObject();
            System.out.println(productTwo.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

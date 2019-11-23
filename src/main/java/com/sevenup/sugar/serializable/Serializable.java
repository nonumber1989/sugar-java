package com.sevenup.sugar.serializable;

import com.sevenup.sugar.serializable.model.Address;
import com.sevenup.sugar.serializable.model.Product;
import com.sevenup.sugar.serializable.model.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * Created by nonumber1989 on 2019/11/23.
 */
public class Serializable {
    public static final String USER_FILE_PATH = "user.txt";
    public static final String PRODUCT_FILE_PATH = "product.txt";

    public static void main(String[] args) {
        writeProductToFile();
        readProductToFile();
//        writeUserToFile();
//        readUserFromFile();
    }

    public static void writeProductToFile() {
        try (FileOutputStream fileOutputStream = new FileOutputStream(PRODUCT_FILE_PATH);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            Product product = new Product();
            product.setCount(10);
            product.setName("computer");
            product.setPrice(2000.10);

            objectOutputStream.writeObject(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readProductToFile() {
        try (FileInputStream fileInputStream = new FileInputStream(PRODUCT_FILE_PATH);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Product product = (Product) objectInputStream.readObject();
            System.out.println(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeUserToFile() {
        try (FileOutputStream fileOutputStream = new FileOutputStream(USER_FILE_PATH);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            //初始化对象
            User user = new User();
            user.setName("steven");
            user.setAge(1);
            user.setBirthday(new Date());
            Address address = new Address();
            address.setCity("Shanghai");
            address.setCode(100L);
            address.setCountry("China");
            user.setAddress(address);

            objectOutputStream.writeObject(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readUserFromFile() {
        try (FileInputStream fileInputStream = new FileInputStream(USER_FILE_PATH);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            User user = (User) objectInputStream.readObject();
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

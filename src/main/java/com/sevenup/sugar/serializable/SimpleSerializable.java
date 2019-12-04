package com.sevenup.sugar.serializable;

import com.sevenup.sugar.serializable.model.Address;
import com.sevenup.sugar.serializable.model.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class SimpleSerializable {
    public static final String USER_FILE_PATH = "user.txt";

    public static void main(String[] args) {
        writeUserToFile();
        readUserFromFile();
    }

    public static void writeUserToFile() {
        try (FileOutputStream fileOutputStream = new FileOutputStream(USER_FILE_PATH);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            //初始化对象
            User user = new User();
            user.name = "steven";
            user.age = 1;
            user.birthday = new Date();
            Address address = new Address("Shanghai", 100L);
            user.address = address;
            //human state
            user.state = "ALIVE";
            objectOutputStream.writeObject(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readUserFromFile() {
        try (FileInputStream fileInputStream = new FileInputStream(USER_FILE_PATH);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            User user = (User) objectInputStream.readObject();
            System.out.println("user information:" + user);
            System.out.println("human state:" + user.state);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


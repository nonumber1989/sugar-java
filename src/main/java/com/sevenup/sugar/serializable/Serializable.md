# 聊序列化的时候我们再聊什么
### 资料连接
https://www.javaworld.com/article/2072752/the-java-serialization-algorithm-revealed.html
https://juejin.im/post/5ce3cdc8e51d45777b1a3cdf
https://www.cnblogs.com/wxgblogs/p/5849951.html
https://www.javaworld.com/article/2076120/flatten-your-objects.html?page=2
https://docs.oracle.com/en/java/javase/12/docs/specs/serialization/index.html



### 什么是序列化
> java序列化 就是把java对象以二进制流的形式存储到文件或者通过网络传输到其他进程中，并方便其他java进程重建java对象的规范

### 为什么要序列化
> 使得java对象脱离当前JVM生命周期，实现远程方法调用（RMI remote method invoke），
> 或者保存java对象状态，方便在合适时间点进行重建

### 如何做序列化
>如果需要将某个对象保存到磁盘上或者通过网络传输，那么这个类应该实现Serializable接口或者Externalizable接口之一。

#### Serializable
> Serializable 只是一个标记接口，实现了该接口的类，或者继承了该接口实现类的类可进行序列化操作

 1. 实现Serializable接口
 2. 使用ObjectOutputStream 进行序列化
 3. 使用ObjectInputStream 进行反序列化
 
 
    package com.sevenup.sugar.serializable.model;
    
    public class Human {
        public String state;
    }
 ---
    package com.sevenup.sugar.serializable.model;
    
    import java.io.Serializable;
    
    public class Address implements Serializable {
     public String city;
     public Long code;
    
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
---
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
---
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
                System.out.println(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
---





### 序列化注意点
 + 反序列化并不会调用构造方法。反序列的对象是由JVM自己生成的对象，不通过构造方法生成。
 + 如果一个可序列化的类的成员不是基本类型，也不是String类型，那这个引用类型也必须是可序列化的；否则，会导致此类不能序列化。
   比如,去掉Address类的Serializable接口
       
       Caused by: java.io.NotSerializableException: com.sevenup.sugar.serializable.model.Address
        at java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1184)
        at java.io.ObjectOutputStream.defaultWriteFields(ObjectOutputStream.java:1548)
        at java.io.ObjectOutputStream.writeSerialData(ObjectOutputStream.java:1509)
        at java.io.ObjectOutputStream.writeOrdinaryObject(ObjectOutputStream.java:1432)
        at java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1178)
        at java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:348)
        at com.sevenup.sugar.serializable.SimpleSerializable.writeUserToFile(SimpleSerializable.java:32)
        at com.sevenup.sugar.serializable.SimpleSerializable.main(SimpleSerializable.java:16)

### 序列化底层原理

### 总结
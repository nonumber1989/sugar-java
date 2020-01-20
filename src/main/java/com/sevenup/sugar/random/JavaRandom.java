package com.sevenup.sugar.random;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 都是伪随机数
 * 目前大部分使用的是 线性求余
 * 之前还使用过  乘同余法
 * 高端的 梅森旋转算法
 */
public class JavaRandom {

    ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
    private int getRandomNumber(){
        int number = threadLocalRandom.nextInt();
        return number;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Random random = new java.util.Random(1);
        for (int i =0;i<4;i++){
            System.out.println(random.nextInt());
        }

        //use threadlocalRandom
        JavaRandom javaRandom = new JavaRandom();
        int theNumber = javaRandom.getRandomNumber();
        System.out.println(theNumber);

        //use secure random
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        System.out.println(secureRandom.getAlgorithm()+" and random number is "+secureRandom.nextInt());

        //Math random

        System.out.println("Math random and number is "+Math.random());
    }


}

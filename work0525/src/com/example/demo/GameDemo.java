package com.example.demo;

import java.util.Random;

public class GameDemo {
    public static void main(String[] args) {
        Random random = new Random(); //创建随机数产生器
        //int num = random.nextInt(5); //随机数：0 ~ 括号中的值-1
        int num = random.nextInt(5)+1; //随机出来的值还可以进行计算得出一个新的范围
        System.out.println(num);
    }
}

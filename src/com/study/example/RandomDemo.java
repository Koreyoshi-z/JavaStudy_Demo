package com.study.example;

import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        Random random = new Random();
        int a = random.nextInt(); //伪随机地生成并返回一个int值 取值范围：负2的16次幂到正2的16次幂
        int b = random.nextInt(5); //伪随机地生成并返回一个int值 限定取值范围[0,5)
        System.out.println(a);
        System.out.println(b);
    }
}

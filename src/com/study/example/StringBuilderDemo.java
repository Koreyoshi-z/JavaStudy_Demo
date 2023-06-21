package com.study.example;

import java.util.Arrays;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("hello");
        builder.append(123);
        builder.append(true);

        System.out.println(builder.length());
        System.out.println(builder.capacity());

        builder.append(342525);
        System.out.println(builder.capacity());//自动扩容 原数组长度*2+2

        System.out.println(builder.toString());
        builder.replace(5,7,"xx");
        System.out.println(builder.toString());
        System.out.println("----------------分割线----------------");

        MyStringBuilder msb = new MyStringBuilder();
        msb.append("hello").append(",java").append("1234567");
        System.out.println(msb.length());
        System.out.println(msb.capacity());
        System.out.println(msb.toString());
    }
}

//模仿源码进行编码
class MyStringBuilder {
    private char[] value;//字符数组
    private int count = 0;//字符数组中存放的字符个数

    public MyStringBuilder() {
        value = new char[16];
    }

    public MyStringBuilder(int capacity) {
        value = new char[capacity];
    }

    public MyStringBuilder(String str) {
        value = new char[str.length() + 16];
    }

    //得到字符数组中字符个数
    public int length() {
        return count;
    }

    //返回容器容量大小的方法
    public int capacity() {
        return value.length;
    }

    //实现字符串的追加
    public MyStringBuilder append(String str) {
        int len = str.length();
        //先要确保字符数组能放进去所添加的字符串
        ensureCapacity(count + len);
        //把要添加的字符串追加到指定的字符数组的对应位置后面
        str.getChars(0, len, value, count);
        count+=len;
        return this;
    }

    public void ensureCapacity(int capacity) {
        //数据超出容量大小，就扩容
        if (capacity - value.length > 0) {
            int newCapacity = value.length * 2 + 2;
            value = Arrays.copyOf(value, newCapacity);
        }
    }
    //把字符数组转换成字符串显示
    public String toString(){
        return new String(value, 0, count);
    }

}
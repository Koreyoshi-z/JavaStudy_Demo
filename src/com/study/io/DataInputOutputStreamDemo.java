package com.study.io;

import java.io.*;

public class DataInputOutputStreamDemo {
    public static void main(String[] args) throws Exception {

        // 随便给一些数据
        String name = "古月方源";
        int age = 500;
        boolean flag = true;
        char sex = '男';
        double money = 2300.50;


        //使用DataOutputStream写入数据
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("C:/Users/Hanabi/Desktop/test/1.txt"));
        dos.writeUTF(name);
        dos.writeInt(age);
        dos.writeBoolean(flag);
        dos.writeChar(sex);
        dos.writeDouble(money);


        //使用DataOutputStream写入数据
        DataInputStream dis = new DataInputStream(new FileInputStream("C:/Users/Hanabi/Desktop/test/1.txt"));
        //读的顺序不能错，必须和写的顺序一致
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        System.out.println(dis.readBoolean());
        System.out.println(dis.readChar());
        System.out.println(dis.readDouble());
    }
}

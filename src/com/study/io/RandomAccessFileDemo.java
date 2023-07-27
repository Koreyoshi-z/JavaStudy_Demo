package com.study.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class RandomAccessFileDemo {
    public static void main(String[] args) throws Exception {
        //创建一个People类型的数组
        People[] people = {new People("张三",33),
                new People("李四",44),
                new People("王五",55),
                new People("赵六",66)};

        RandomAccessFile randomAccessFile = new RandomAccessFile(
                "C:\\Users\\Hanabi\\Desktop\\ccc.txt", "rw");//rw 可读可写

        //写入数据到RandomAccessFile这个对象中
        for (int i = 0; i < people.length; i++) {
            randomAccessFile.writeChars(people[i].getName());
            randomAccessFile.writeInt(people[i].getAge());
        }

        //读取指定位置上的people对象
        Scanner scanner = new Scanner(System.in);
        System.out.printf("请输入你想要读取的第几个people对象的数据？");
        int num = scanner.nextInt();
        //使用seek来操作存储位置
        randomAccessFile.seek((num-1)*People.size());
        People p = new People();
        p.setName(readName(randomAccessFile));
        p.setAge(randomAccessFile.readInt());
        System.out.printf("姓名:" + p.getName());
        System.out.printf("年龄:" + p.getAge());
        randomAccessFile.close();
    }

    public static String readName(RandomAccessFile randomAccessFile) throws IOException {
        char[] name = new char[15];
        for (int i = 0; i < name.length; i++) {
            name[i] = randomAccessFile.readChar();
        }
        return new String(name).replace('\u0000',' ');
    }
}

class People{
    private String name;//要求String name占15个字符30字节
    private int age;//占4个字节

    public People() {
    }

    public People(String name, int age) {
        StringBuilder builder = null;
        if (name!=null){
            builder = new StringBuilder(name);
        }else {
            builder = new StringBuilder(15);
        }
        builder.setLength(15);//固定长度为15个字符，占用了30个字节大小  '\u0000'自动占位空格
        this.name = builder.toString();
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        StringBuilder builder = null;
        if (name!=null){
            builder = new StringBuilder(name);
        }else {
            builder = new StringBuilder(15);
        }
        builder.setLength(15);//固定长度为15个字符，占用了30个字节大小  '\u0000'自动占位空格
        this.name = builder.toString();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int size(){
        return 34;//person对象的偏移量 30+4=34
    }

}
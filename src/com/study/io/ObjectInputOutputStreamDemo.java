package com.study.io;

import java.io.*;

//对象流
public class ObjectInputOutputStreamDemo {
    public static void main(String[] args) throws Exception {
        //写入对象
        Person person = new Person("张三",22);
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Hanabi\\Desktop\\ccc.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(person);//写出对象方法
        oos.close();
        //读取对象
        FileInputStream fis = new FileInputStream("C:\\Users\\Hanabi\\Desktop\\ccc.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Person p = (Person) ois.readObject();
        System.out.println(p);
    }
}

//Serializable接口实现序列化和反序列化
class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
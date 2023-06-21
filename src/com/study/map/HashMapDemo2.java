package com.study.map;

import java.util.HashMap;
import java.util.Objects;

public class HashMapDemo2 {
    public static void main(String[] args) {
        HashMap<People,String> hashMap = new HashMap<People,String>();
        hashMap.put(new People("张三",12),"我是第一人");
        hashMap.put(new People("李四",23),"我是第二人");
        hashMap.put(new People("王五",33),"我是第三人");
        hashMap.put(new People("张三",12),"我是第一人");
        //观察重写equals和hashCode方法前后对比
        System.out.println(hashMap);//重写前：两个张三都输出（因为People对象是new出来的）  重写后：进行去重操作，输出结果只有一个张三。
        System.out.println(hashMap.size());//重写前：4  重写后：3
    }
}

class People{
    private String name;
    private int age;

    public People() {
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "com.study.map.People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return age == people.age && Objects.equals(name, people.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
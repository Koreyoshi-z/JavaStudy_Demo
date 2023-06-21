package com.study.set;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Person3> treeSet = new TreeSet<Person3>();
        treeSet.add(new Person3("lihua",20));
        treeSet.add(new Person3("rose",30));
        treeSet.add(new Person3("mary",40));
        treeSet.add(new Person3("lisa",10));
        treeSet.add(new Person3("zhangsan",50));
        //使用迭代器遍历TreeSet
        Iterator<Person3> it = treeSet.iterator();
        while (it.hasNext()) {
            Person3 next =  it.next();
            System.out.println(next);
        }
    }
}

class Person3 implements Comparable<Person3>{
    private String name;
    private int age;

    public Person3(String name, int age) {
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
    public int compareTo(Person3 o) {
        return this.getAge() - o.getAge();
    }

    @Override
    public String toString() {
        return "com.study.set.Person3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
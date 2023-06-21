package com.study.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class HashSetDemo {
    public static void main(String[] args) {
       /* HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("aaa");
        hashSet.add("bbb");
        hashSet.add("ccc");
        hashSet.add("ccc");//重复元素无法在往 HashSet 里面再添加
        System.out.println(hashSet);*/

        HashSet<Student3> data = new HashSet<Student3>();
        data.add(new Student3("zhangsan",20));
        data.add(new Student3("lisi",30));
        data.add(new Student3("wangwu",40));
        data.add(new Student3("zhangsan",20));//需要重写equals和hashCode方法，否则遍历的结果会有两条相同的数据
        //使用迭代器遍历HashSet
        Iterator<Student3> it = data.iterator();
        while (it.hasNext()) {
            Student3 next =  it.next();
            System.out.println(next);
        }

    }
}

class Student3{
    private String name;
    private int age;

    public Student3(String name, int age) {
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
        return "com.study.set.Student3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student3 student3 = (Student3) o;
        return age == student3.age && Objects.equals(name, student3.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
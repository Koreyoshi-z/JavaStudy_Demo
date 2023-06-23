package com.study.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionApiDemo {
    public static void main(String[] args) throws Exception {
        //获取Employee这个类所关联的Class对象
        Class<?> employeeClass = Class.forName("com.study.reflection.Employee");
        //通过反射生成一个Employee对象  newInstance（默认调用无参的构造方法）
        Employee employee1 = (Employee) employeeClass.newInstance();
        System.out.println(employee1);
        System.out.println("====================================");

        //调用指定的构造方法来构造对象（无参构造方法）
        Constructor<?> constructor1 = employeeClass.getConstructor(new Class[]{});
        Employee employee2 = (Employee) constructor1.newInstance(new Object[]{});
        System.out.println(employee2);
        System.out.println("====================================");

        //调角指定的构造方法来构造对象（带参数构造方法）
        Constructor<?> constructor2 = employeeClass.getConstructor(new Class[]{String.class,int.class});
        Employee employee3 = (Employee) constructor2.newInstance(new Object[]{"zhanhsan",23});
        System.out.println(employee3);
        System.out.println("====================================");

        //获取Class对象的所有方法，包括私有的。
        Method[] methods = employeeClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName()+"---"+method.getModifiers());
        }
        System.out.println("====================================");

        //获取Class对象的指定的方法，包括私有的。
        Method method1 = employeeClass.getDeclaredMethod("toString", new Class[]{});
        System.out.println(method1.getName());
        System.out.println("====================================");
        //方法调用
        String desc1 = (String) method1.invoke(employee3, new Object[]{});
        System.out.println(desc1);
        System.out.println("====================================");

        //默认情况下私有方法不能 invoke(调用)  程序会抛出 IllegalAccessException 异常
        Method method2 = employeeClass.getDeclaredMethod("work", new Class[]{});//私有方法
        System.out.println(method2.getName());
        //使用setAccessible方法并传入参数"true"，才能 invoke 私有方法。
        method2.setAccessible(true);
        method2.invoke(employee3, new Object[]{});
        System.out.println("====================================");

        //获取Class对象指定的属性，包括私有的
        Field field = employeeClass.getDeclaredField("name");
        //默认情况下私有属性是不能调用的
        field.setAccessible(true);
        field.set(employee1,"小蓝");
        System.out.println(field.getName());
        System.out.println(employee1);

    }
}

class Employee{
    private String name;
    private int age;

    //一定要写上一个无参的构造方法，不然反射经常出问题
    public Employee() {
    }

    public Employee(String name, int age) {
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
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private void test_1(){
        System.out.println("我是test_1");
    }

    void test_2(){
        System.out.println("我是test_2");
    }

    protected void test_3(){
        System.out.println("我是test_3");
    }

    public void test_4(){
        System.out.println("我是test_4");
    }

    private void work(){
        System.out.println("我是私有方法");
    }

}
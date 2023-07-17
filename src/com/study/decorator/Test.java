package com.study.decorator;

public class Test {
    public static void main(String[] args) {
        ConcreateComponent component = new ConcreateComponent();//类似于FileInputStream
        component.methodA();
        System.out.println("=============================");
        ConcreateDecoratorA decoratorA = new ConcreateDecoratorA(component);//类似于BufferInputStream
        decoratorA.methodA();
        System.out.println("=============================");
        ConcreateDecoratorB decoratorB = new ConcreateDecoratorB(component);//类似于DataInputStream
        decoratorB.methodA();
    }
}

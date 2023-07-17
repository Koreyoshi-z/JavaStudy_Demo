package com.study.decorator;

//具体的装饰者类A
public class ConcreateDecoratorA extends Decorator{
    public ConcreateDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void methodA() {
        super.methodA();//调用被包装类的方法
        methodB();
    }

    //扩展的功能
    private void methodB(){
        System.out.println("我是方法B");
    }
}

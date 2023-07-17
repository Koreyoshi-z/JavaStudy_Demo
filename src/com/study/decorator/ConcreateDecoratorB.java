package com.study.decorator;

//具体的装饰者类B
public class ConcreateDecoratorB extends Decorator{

    public ConcreateDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void methodA() {
        super.methodA();//调用被包装类的方法
        methodC();
    }

    //扩展的功能
    private void methodC(){
        System.out.println("我是方法C");
    }
}

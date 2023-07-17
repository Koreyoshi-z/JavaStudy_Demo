package com.study.decorator;

//角色装饰类
public class Decorator implements Component{
    private Component component = null;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void methodA() {
        component.methodA();
    }
}

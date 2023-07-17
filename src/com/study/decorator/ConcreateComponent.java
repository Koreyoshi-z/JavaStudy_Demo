package com.study.decorator;

//具体的组件类
public class ConcreateComponent implements Component{
    @Override
    public void methodA() {
        System.out.println("我是方法A");
    }
}

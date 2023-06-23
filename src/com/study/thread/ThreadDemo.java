package com.study.thread;

//创建线程的方式
public class ThreadDemo {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread("A");
        h1.start();//一定要调用start才是启动线程，如果你调用的是run方法叫执行run方法而已，并没有启动线程
        HelloThread h2 = new HelloThread();
        h2.setName("线程2");
        h2.start();
    }
}

//通过继承Thread类创建线程
class HelloThread extends Thread{
    public HelloThread() {
    }

    public HelloThread(String s) {
        super(s);
    }

    //重写run方法
    @Override
    public void run() {
        System.out.println(this.getName()+": 你好，我是一个线程！");
    }
}



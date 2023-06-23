package com.study.thread;

public class RunnableDemo {
    public static void main(String[] args) {
        //使用runnable接口的话一定要创建Thread类实例然后把Runnable资源通过构造方法传入进去
        HelloRunnable runnable = new HelloRunnable();
        Thread t1 = new Thread(runnable,"线程一");
        t1.start();
        Thread t2 = new Thread(runnable,"线程二");
        t2.start();
    }
}

//通过实现Runnable接口创建线程
//如果继承Thread类由于单继承所以会有很大的局限性
//用runnable可以实现资源的共享
class HelloRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
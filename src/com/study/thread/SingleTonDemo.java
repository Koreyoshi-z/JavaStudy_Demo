package com.study.thread;
/*
* 单例模式深入探讨
* 一个返回对象的方法 getInstance
* 单例模式分为懒汉式和饿汉式  无论调用多少次返回的那个对象应该是同一个对象
*
* 懒汉式在多线程环情下，存在线程安全的问题。——> 使用双重检查加锁机制解决线程的安全问题
*
* 单例模式还有更好的解决方案，即使用静态类方式
* */
public class SingleTonDemo {
    public static void main(String[] args) {
        SingleTonThread st = new SingleTonThread();
        Thread t1 = new Thread(st);
        t1.start();
        Thread t2 = new Thread(st);
        t2.start();

    }
}

class SingleTonThread implements Runnable{
    @Override
    public void run() {
        System.out.println(SingleTon.getInstance());
    }
}

class SingleTon{
    private static SingleTon singleTon = null;

    public static SingleTon getInstance(){
        synchronized (SingleTon.class){
            if (singleTon == null){
                //第一个线程有可能在这里
                //第二个线程也有可能运行到这里
                singleTon = new SingleTon();
            }
            return singleTon;
        }

    }

}
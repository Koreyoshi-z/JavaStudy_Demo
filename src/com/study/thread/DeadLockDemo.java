package com.study.thread;

public class DeadLockDemo {
    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        DeadThread1 t1 = new DeadThread1(deadLock);
        t1.start();
        DeadThread2 t2 = new DeadThread2(deadLock);
        t2.start();
    }
}

class DeadThread1 extends Thread{
    private DeadLock deadLock;

    public DeadThread1(DeadLock deadLock) {
        super();
        this.deadLock = deadLock;
    }

    @Override
    public void run() {
        deadLock.method1();
    }
}

class DeadThread2 extends Thread{
    private DeadLock deadLock;

    public DeadThread2(DeadLock deadLock) {
        super();
        this.deadLock = deadLock;
    }

    @Override
    public void run() {
        deadLock.method2();
    }
}

class DeadLock{
    private Object obj1 = new Object();
    private Object obj2 = new Object();

    public void method1() {
        synchronized (obj1){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            synchronized (obj2){
                System.out.println("method1");
            }
        }
    }

    public void method2() {
        synchronized (obj2){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            synchronized (obj1){
                System.out.println("method2");
            }
        }
    }
}
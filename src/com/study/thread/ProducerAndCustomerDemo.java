package com.study.thread;

import java.util.LinkedList;

/* 经典的生产者和消费者案例
 *
 * 往篮子里生产苹果，然后消费者去消费苹果
 * 单例模式分为懒汉式和饿汉式  无论调用多少次返回的那个对象应该是同一个对象
 * 篮子最多放5个苹果，所以生产者生产5个苹果后去通知消费者消费苹果
 * 当消费者消费完了苹果，生产者才继续生产
 * 循环四次 所以最后应该有20个苹果生产和消费了
 *
 * */
public class ProducerAndCustomerDemo {
    public static void main(String[] args) {
        Basket basket = new Basket();
        Producer producer = new Producer(basket);
        Customer customer = new Customer(basket);
        producer.start();
        customer.start();
    }
}

//生产者
class Producer extends Thread{
    private Basket basket = null;

    public Producer(Basket basket) {
        this.basket = basket;
    }

    @Override
    public void run() {
        basket.pushApple();
    }
}


//消费者
class Customer extends Thread{
    private Basket basket = null;

    public Customer(Basket basket) {
        this.basket = basket;
    }

    @Override
    public void run() {
        basket.popApple();
    }
}


//篮子类
class Basket{
    private LinkedList<Apple> basket = new LinkedList<Apple>();

    //放4轮苹果
    public synchronized void pushApple(){
        for (int i = 0; i < 20; i++) {//4轮一共生产20个苹果
            Apple apple = new Apple(i);
            push(apple);
        }
    }

    //取4轮苹果
    public synchronized void popApple(){
        for (int i = 0; i < 20; i++) {//4轮一共消费20个苹果
            pop();
        }
    }


    //向篮子放苹果
    private void push(Apple apple){
        //当篮子当中存放了5个苹果就等待并通知消费者来消费
        if (basket.size()==5){
            try {
                wait();//等待并释放当前对象的锁
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(500);//模拟生产苹果
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        basket.addFirst(apple);
        System.out.println("存放："+apple.toString());
        notify();//通知消费者来消费
    }

    //向篮子取苹果
    private void pop(){
        //当篮子当中苹果数量为0的时候就等待并通知生产者生产
        if (basket.size()==0){
            try {
                wait();//等待并释放当前对象的锁
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(500);//模拟消费苹果
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Apple apple = basket.removeFirst();
        System.out.println("消费："+apple.toString());
        notify();//通知生产者来生产
    }
}



//苹果类
class Apple{
    private int id = 5;

    public Apple(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "苹果"+(id+1);
    }
}
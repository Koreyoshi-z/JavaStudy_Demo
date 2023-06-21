package com.study.list;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListSimulationStackAndQueue {
    public static void main(String[] args) {
        //测试模拟的栈  先进后出
        System.out.println("使用LinkedList来模拟栈：");
        MyStack<String> stack = new MyStack<String>();
        stack.push("a");
        stack.push("ab");
        stack.push("abc");
        stack.push("abcd");
        stack.pop();
        stack.pop();
        Iterator<String> it = stack.iterator();
        while (it.hasNext()){
            String name = it.next();
            System.out.println(name);
        }
        //测试模拟的队列  先进先出
        System.out.println("用LinkedList来模拟队列：");
        MyQueue<String> queue = new MyQueue<String>();
        queue.push("a");
        queue.push("ab");
        queue.push("abc");
        queue.push("abcd");
        queue.pop();
        queue.pop();
        Iterator<String> iterator = queue.iterator();
        while (iterator.hasNext()){
            String name = iterator.next();
            System.out.println(name);
        }
    }
}

//用LinkedList来模拟栈
class MyStack<T>{
    private LinkedList<T> data = null;

    public MyStack() {
        data = new LinkedList<T>();
    }

    //压栈的方法
    public void push(T obj){
        data.addFirst(obj);
    }

    //出栈的方法
    public T pop(){
        return data.removeFirst();
    }

    //迭代器遍历
    public Iterator<T> iterator(){
        return data.iterator();
    }

}

//用LinkedList来模拟队列
class MyQueue<T>{
    private LinkedList<T> data = null;

    public MyQueue() {
        data = new LinkedList<T>();
    }

    //进队的方法
    public void push(T obj){
        data.addFirst(obj);
    }

    //出队的方法
    public T pop(){
        return data.removeLast();
    }

    //迭代器遍历
    public Iterator<T> iterator(){
        return data.iterator();
    }

}
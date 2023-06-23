package com.study.thread;

//模拟一个游乐场售票，这个游乐场有两个售票窗口A和B，总共有5张票，现在分别让两个窗口卖这个票
public class SharedDataThreadDemo {
    public static void main(String[] args) {
        TicketThread ticketThread = new TicketThread();
        Thread t1 = new Thread(ticketThread,"窗口1");
        t1.start();
        Thread t2 = new Thread(ticketThread,"窗口2");
        t2.start();
    }
}


class TicketThread implements Runnable{
    private int ticket = 5;
    //卖票
    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName()+": "+(ticket--));
            if (ticket < 1){
                break;
            }
        }
    }
}
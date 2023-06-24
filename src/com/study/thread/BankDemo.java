package com.study.thread;

//1、某银行卡账号上有500元现金。一个人拿着存折去取钱，同时另一个人拿着卡去ATM上取钱，各自取钱400元。
//2、要求取钱过程中不能出现资源竞争：比如400元被取出两次、银行卡的账目不能小于0等。
public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();
        BankThread b1 = new BankThread(bank);
        b1.start();
        BankThread b2 = new BankThread(bank);
        b2.start();
    }
}

class BankThread extends Thread{
    private Bank bank = null;

    public BankThread(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        System.out.println("取钱："+bank.getMoney(400));
    }
}

class Bank{
    private int money = 500;

    //定义取钱的方法
    public int getMoney(int number) {
        synchronized (this){
            if (number < 0){
                return -1;
            } else if (money < 0) {
                return -2;
            } else if (money - number < 0) {
                return -3;
            }else {
                try {
                    Thread.sleep(1000);//模拟取钱的时间
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                money-=number;
                System.out.println("你的余额是："+money);
            }
            return number;
        }
    }
}
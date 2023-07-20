package com.wwz.study.entity;

//用户实体类
public class User {
    //User类的属性
    int id;
    String name;//账户
    String password;//密码
    int balance;//余额
    int level;

    public User(int id, String name, String password, int balance, int level) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "[" +
                "用户编号: " + id +
                "\t账户: " + name +
                "\t密码: " + password +
                "\t余额: " + balance +
                "\t等级: " + level +
                "]";
    }

}

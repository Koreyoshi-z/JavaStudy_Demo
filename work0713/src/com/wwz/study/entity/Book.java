package com.wwz.study.entity;

//图书表的实体类
public class Book {
    private int bid;//书籍编号
    private String name;//书名
    private String author;//作者名
    private String des;//对于书籍的简单描述
    private double price;//价格
    private String status;//图书的状态(空闲和借用) 默认是空闲状态

    public Book(int bid, String name, String author, String des, double price, String status) {
        this.bid = bid;
        this.name = name;
        this.author = author;
        this.des = des;
        this.price = price;
        this.status = status;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "[" +
                "图书编号: " + bid +
                "\t图书名: " + name +
                "\t作者: " + author +
                "\t简介: " + des +
                "\t价格: " + price +
                "\t状态: " + status +
                "]";
    }

}

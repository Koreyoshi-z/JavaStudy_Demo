package com.wwz.study.entity;

//借阅记录的实体类
public class BorrowRecords {
    private int id;//借阅记录编号
    private int bid;//书籍编号 外键
    private int uid;//用户编号 外键
    private String borrow_time;//借书时间
    private String return_time;//还书时间

    public BorrowRecords(int id, int bid, int uid, String borrow_time, String return_time) {
        this.id = id;
        this.bid = bid;
        this.uid = uid;
        this.borrow_time = borrow_time;
        this.return_time = return_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getBorrow_time() {
        return borrow_time;
    }

    public void setBorrow_time(String borrow_time) {
        this.borrow_time = borrow_time;
    }

    public String getReturn_time() {
        return return_time;
    }

    public void setReturn_time(String return_time) {
        this.return_time = return_time;
    }

    @Override
    public String toString() {
        return "BorrowRecords{" +
                "id=" + id +
                ", bid=" + bid +
                ", uid=" + uid +
                ", borrow_time='" + borrow_time + '\'' +
                ", return_time='" + return_time + '\'' +
                '}';
    }

}

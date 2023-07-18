package com.wwz.study.entity;

//余额记录的实体类
public class BalanceRecords {
    private int id;
    private int user_id;
    private String record_time;
    private String record_type;
    private int money;

    public BalanceRecords(int id, int user_id, String record_time, String record_type, int money) {
        this.id = id;
        this.user_id = user_id;
        this.record_time = record_time;
        this.record_type = record_type;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getRecord_time() {
        return record_time;
    }

    public void setRecord_time(String record_time) {
        this.record_time = record_time;
    }

    public String getRecord_type() {
        return record_type;
    }

    public void setRecord_type(String record_type) {
        this.record_type = record_type;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "BalanceRecords{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", record_time='" + record_time + '\'' +
                ", record_type='" + record_type + '\'' +
                ", money=" + money +
                '}';
    }

}

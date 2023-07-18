package com.wwz.study.entity;

/*
这是一个负责联查的实体类
数据库中本身是没有联查的表的 多表在联查的时候临时生成的一个表
这个实体类其实就是负责对应这个临时生成的表
*/
public class UserAndBalanceRecordsInfo {
    private User user;
    private BalanceRecords balanceRecords;

    //生成的UserAndBalanceRecordsInfo会将user和balanceRecords绑定在一起
    public UserAndBalanceRecordsInfo(User user, BalanceRecords balanceRecords) {
        this.user = user;
        this.balanceRecords = balanceRecords;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BalanceRecords getBalanceRecords() {
        return balanceRecords;
    }

    public void setBalanceRecords(BalanceRecords balanceRecords) {
        this.balanceRecords = balanceRecords;
    }

    @Override
    public String toString() {
        return  "[" +
                "记录编号: " + balanceRecords.getId() +
                "\t用户编号: " + balanceRecords.getUser_id() +
                "\t账户名: " + user.getName() +
                "\t账户等级: " +user.getLevel() +
                "\t订单类型: " + balanceRecords.getRecord_type() +
                "\t订单金额: " +balanceRecords.getMoney() +
                "\t订单时间: " + balanceRecords.getRecord_time() +
                "]";
    }

}

package com.wwz.study.dao;

import com.wwz.study.entity.User;

//用户数据访问层接口
public interface UserDao {
    public User selectByName(String name);
    public void add(User user);
    public User selectById(int id);
    public void updatePasswordById(int id, String newPassword);
    public void updateBalanceById(int id, int rechargeAmount);
    public void updateLevelById(int id, int newLevel);

}

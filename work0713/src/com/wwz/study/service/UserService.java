package com.wwz.study.service;

import com.wwz.study.entity.User;

import java.util.ArrayList;

//用户业务层接口
//使用接口可以提高代码的可维护性
public interface UserService {
    public boolean register(User user);
    public int login(User user);
    public User selectByName(String name);
    public User selectById(int id);
    public int updatePasswordById(int id, String oldPassword, String newPassword);
    public int updateBalance(int id, int rechargeAmount);
    public ArrayList<User> selectAllUserInfo();

}

package com.wwz.study.service.impl;

import com.wwz.study.dao.BalanceRecordsDao;
import com.wwz.study.dao.UserDao;
import com.wwz.study.dao.impl.BalanceRecordsDaoImpl;
import com.wwz.study.dao.impl.UserDaoImpl;
import com.wwz.study.entity.BalanceRecords;
import com.wwz.study.entity.User;
import com.wwz.study.service.UserService;
import com.wwz.study.util.MyUtil;
import com.wwz.study.view.UserMenu;

import java.util.ArrayList;

//用户业务层接口的实现类
public class UserServiceImpl implements UserService {
    //业务逻辑层调用数据访问层的接口引用(获取User表的操作权限)
    UserDao userDao = new UserDaoImpl();
    //业务逻辑可以调用其他dao层的动作
    BalanceRecordsDao balanceRecordsDao = new BalanceRecordsDaoImpl();

    //注册功能的业务逻辑
    @Override
    public boolean register(User user) {
        User u = userDao.selectByName(user.getName());
        //查询这个用户的账户名是否已经存在
        if (u == null){
            userDao.add(user);
            return true;//不存在的话返回true,表示可以注册
        }
        return false;//如果存在的话返回false,表示不能注册
    }


    //登录功能的业务逻辑
    @Override
    public int login(User user) {
        User u = userDao.selectByName(user.getName());
        //首先检测这个账号是否存在
        //这里有一个问题，就是账号不区分大小写。例如: 数据库中的name中只有aaa,但是我在输入AAA做为账号名(name)时，依然可以登录成功！
        if (u == null){
            return -1;//账号不存在
        }
        //再检测密码是否正确
        if (!u.getPassword().equals(user.getPassword())){
            return -2;//密码错误
        }
        return 1;//登录成功
    }


    //根据账户名(name)获取该用户的所有信息
    @Override
    public User selectByName(String name) {
        return userDao.selectByName(name);
    }


    //根据id获取该用户的所有信息
    @Override
    public User selectById(int id) {
        return userDao.selectById(id);
    }


    //根据用户的id修改密码
    @Override
    public int updatePasswordById(int id, String oldPassword, String newPassword) {
        User user = userDao.selectById(id);
        UserMenu userMenu = new UserMenu();
        if (user == null){
            return -1;//该账号不存在
        }
        //判断输入的旧密码是否正确
        if (!oldPassword.equals(user.getPassword())){
            return -2;//输入的旧密码不对
        }
        if (!userMenu.isValidPassword(user.getPassword())){
            return -3;//新密码不符合要求
        }
        //调用dao层的修改密码方法
        userDao.updatePasswordById(id, newPassword);
        return 1;//修改密码成功
    }


    //根据用户的id进行充值
    @Override
    public int updateBalance(int id, int rechargeAmount) {
        User user = userDao.selectById(id);
        if (user == null){
            return -1;//该账号不存在
        }
        //调用dao层的充值方法
        userDao.updateBalanceById(id, rechargeAmount);
        BalanceRecords br = new BalanceRecords(0, id, MyUtil.getTime(), "充值", rechargeAmount);
        //调用dao层的添加方法
        balanceRecordsDao.add(br);
        //账户的level是根据该账户的历史充值金额累加来计算的
        int totalAmount = balanceRecordsDao.getTotalAmountByUserId(id, "充值");
        //计算出充值完成后现在的应有level
        int level = MyUtil.getLevel(totalAmount);
        if (level != user.getLevel()){
            userDao.updateLevelById(id, level);
            return 2;//充值成功，并且level提升。
        }
        return 1;//充值成功，但level值不改变。
    }


    //查看所有用户信息
    @Override
    public ArrayList<User> selectAllUserInfo() {
        return userDao.selectAllUserInfo();
    }


}

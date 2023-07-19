package com.wwz.study.dao.impl;

import com.wwz.study.dao.UserDao;
import com.wwz.study.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//用户数据访问层接口的实现类
public class UserDaoImpl extends BaseDao implements UserDao {
    //根据用户的name进行查询，并获取该用户的所有信息
    @Override
    public User selectByName(String name) {
        User user = null;
        sql = "SELECT id,name,password,balance,level FROM user WHERE name = ?";//编写sql语句
        getCon();//调用父类BaseDao的方法，获取数据库连接。
        try {
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String password = resultSet.getString("password");
                int balance = resultSet.getInt("balance");
                int level = resultSet.getInt("level");
                //因为我们是根据name查询的，所以这里获取到的name就是我查询的name
                user = new User(id,name,password,balance,level);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return user;
    }


    //添加一个用户
    @Override
    public void add(User user) {
        sql = "INSERT INTO user(name,password,balance,level) VALUES(?,?,?,?)";
        getCon();
        try {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getBalance());
            preparedStatement.setInt(4, user.getLevel());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
    }

    //根据用户的id进行查询，并获取该用户的所有信息。
    @Override
    public User selectById(int id) {
        sql = "SELECT id,name,password,balance,level FROM user WHERE id = ?";
        getCon();
        User user = null;
        try {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                int balance = resultSet.getInt("balance");
                int level = resultSet.getInt("level");
                user = new User(id, name, password, balance, level);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return user;
    }


    //根据用户的id修改密码
    @Override
    public void updatePasswordById(int id, String newPassword) {
        sql = "UPDATE user SET password = ? WHERE id = ?";
        getCon();
        try {
            preparedStatement.setString(1, newPassword);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
    }


    //根据用户的id修改余额
    //充值和消费的业务逻辑(传入的 rechargeAmount 值是正数就代表充值,负数则是消费)
    @Override
    public void updateBalanceById(int id, int rechargeAmount) {
        sql = "UPDATE user SET balance = balance + ? WHERE id = ?";
        getCon();
        try {
            preparedStatement.setInt(1, rechargeAmount);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
    }

    //更新用户的level
    @Override
    public void updateLevelById(int id, int newLevel) {
        sql = "UPDATE user SET level = ? WHERE id = ?";
        getCon();
        try {
            preparedStatement.setInt(1, newLevel);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
    }

    //查看所有用户信息
    @Override
    public ArrayList<User> selectAllUserInfo() {
        ArrayList<User> al = new ArrayList<>();
        sql = "SELECT id,name,password,balance,level FROM user";
        getCon();
        try {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt( "id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                int balance = resultSet.getInt("balance");
                int level = resultSet.getInt("level");
                User user = new User(id, name, password, balance, level);
                al.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return al;
    }


}

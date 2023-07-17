package com.wwz.study.dao.impl;

import com.wwz.study.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//数据库Dao层的一些常用操作，减少重复代码的使用。
//BaseDao类被UserDaoImpl实现类继承，UserDaoImpl拥有BaseDao类的特性。
public class BaseDao {
    //protected 修饰的类和属性  对于本类、本包及其子类可见。
    protected Connection connection;//连接
    protected PreparedStatement preparedStatement;//预处理
    protected String sql;//sql语句
    protected ResultSet resultSet;//结果集

    //获取Jdbc连接
    public void getCon(){
        connection = JdbcUtil.getCon();
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //关闭资源
    public void closeAll(){
        //判断是否为null 如果为null就说明资源没有使用，不必再关闭资源。
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

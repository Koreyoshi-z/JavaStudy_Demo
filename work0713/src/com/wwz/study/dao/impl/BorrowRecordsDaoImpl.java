package com.wwz.study.dao.impl;

import com.wwz.study.dao.BorrowRecordsDao;
import com.wwz.study.entity.BorrowRecords;

import java.sql.SQLException;

//图书借阅数据库访问接口的实现类
public class BorrowRecordsDaoImpl extends BaseDao implements BorrowRecordsDao {
    //添加一条借阅信息
    @Override
    public void add(BorrowRecords borrowRecords) {
        sql = "INSERT INTO borrow_record(bid,uid,userName,bookName,price,borrow_time,return_time) " +
                "VALUES(?,?,?,?,?,?,?)";
        getCon();
        try {
            preparedStatement.setInt(1, borrowRecords.getBid());
            preparedStatement.setInt(2, borrowRecords.getUid());
            preparedStatement.setString(3, borrowRecords.getUserName());
            preparedStatement.setString(4, borrowRecords.getBookName());
            preparedStatement.setDouble(5, borrowRecords.getPrice());
            preparedStatement.setString(6, borrowRecords.getBorrow_time());
            preparedStatement.setString(7, borrowRecords.getReturn_time());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
    }

    //

















}

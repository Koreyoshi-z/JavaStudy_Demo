package com.wwz.study.dao.impl;

import com.wwz.study.dao.BorrowRecordsDao;
import com.wwz.study.entity.*;
import java.sql.SQLException;
import java.util.ArrayList;

//图书借阅数据库访问接口的实现类
public class BorrowRecordsDaoImpl extends BaseDao implements BorrowRecordsDao {
    //添加一条借阅信息
    @Override
    public void add(BorrowRecords borrowRecords) {
        sql = "INSERT INTO borrow_record(bid,uid,borrow_time,return_time) " +
                "VALUES(?,?,?,?)";
        getCon();
        try {
            preparedStatement.setInt(1, borrowRecords.getBid());
            preparedStatement.setInt(2, borrowRecords.getUid());
            preparedStatement.setString(3, borrowRecords.getBorrow_time());
            preparedStatement.setString(4, borrowRecords.getReturn_time());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
    }


    //删除一条借阅信息(这里并没有用到)
    @Override
    public void remove(int bid, int uid) {
        sql = "DELETE FROM borrow_record WHERE bid = ? AND uid = ?";
        getCon();
        try {
            preparedStatement.setInt(1,bid);
            preparedStatement.setInt(2, uid);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
    }


    //根据uid查询借阅记录
    @Override
    public ArrayList<UserAndBookBorrowRecordsInfo> selectBorrowRecordsById(int uid) {
        ArrayList<UserAndBookBorrowRecordsInfo> al = new ArrayList<>();
        sql = "SELECT borrow_record.id,book.bid,uid,book.name AS book_name,user.name AS user_name,borrow_time,return_time " +
                "FROM user INNER JOIN borrow_record ON user.id = uid INNER JOIN book ON borrow_record.bid = book.bid " +
                "WHERE uid = ? ";
        getCon();
        try {
            preparedStatement.setInt(1, uid);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                //通过联查获取到相应的字段
                int borrowRecordId = resultSet.getInt("borrow_record.id");
                int bid = resultSet.getInt("bid");
                String bookName = resultSet.getString("book_name");
                String userName = resultSet.getString("user_name");
                String borrowTime = resultSet.getString("borrow_time");
                String returnTime = resultSet.getString("return_time");
                User user = new User(uid, userName, null, 0, 0);
                Book book = new Book(bid, bookName, null, null, 0, null);
                BorrowRecords borrowRecords = new BorrowRecords(borrowRecordId, bid, uid, borrowTime, returnTime);
                UserAndBookBorrowRecordsInfo userAndBookBorrowRecordsInfo = new UserAndBookBorrowRecordsInfo(user, book, borrowRecords);
                al.add(userAndBookBorrowRecordsInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return al;
    }


    //查看所有的图书借阅信息
    @Override
    public ArrayList<UserAndBookBorrowRecordsInfo> selectBookBorrowInfo() {
        ArrayList<UserAndBookBorrowRecordsInfo> al = new ArrayList<>();
        sql = "SELECT borrow_record.id,book.bid,uid,book.name AS book_name,user.name AS user_name,borrow_time,return_time " +
                "FROM user INNER JOIN borrow_record ON user.id = uid INNER JOIN book ON borrow_record.bid = book.bid";
        getCon();
        try {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                //通过联查获取到相应的字段
                int borrowRecordId = resultSet.getInt("borrow_record.id");
                int bid = resultSet.getInt("bid");
                int uid = resultSet.getInt("uid");
                String bookName = resultSet.getString("book_name");
                String userName = resultSet.getString("user_name");
                String borrowTime = resultSet.getString("borrow_time");
                String returnTime = resultSet.getString("return_time");
                User user = new User(uid, userName, null, 0, 0);
                Book book = new Book(bid, bookName, null, null, 0, null);
                BorrowRecords borrowRecords = new BorrowRecords(borrowRecordId, bid, uid, borrowTime, returnTime);
                UserAndBookBorrowRecordsInfo userAndBookBorrowRecordsInfo = new UserAndBookBorrowRecordsInfo(user, book, borrowRecords);
                al.add(userAndBookBorrowRecordsInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return al;
    }


}

package com.wwz.study.dao;

import com.wwz.study.entity.BorrowRecords;
import com.wwz.study.entity.UserAndBookBorrowRecordsInfo;
import java.util.ArrayList;

//图书借阅记录数据库访问接口
public interface BorrowRecordsDao {
    public void add(BorrowRecords borrowRecords);
    public void remove(int bid, int uid);
    public ArrayList<UserAndBookBorrowRecordsInfo> selectBorrowRecordsById(int uid);
    public ArrayList<UserAndBookBorrowRecordsInfo> selectBookBorrowInfo();
}

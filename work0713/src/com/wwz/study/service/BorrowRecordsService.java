package com.wwz.study.service;

import com.wwz.study.entity.BorrowRecords;
import com.wwz.study.entity.UserAndBookBorrowRecordsInfo;
import java.util.ArrayList;

//图书借阅记录业务层接口的
public interface BorrowRecordsService {
    public void add(BorrowRecords borrowRecords);
    public ArrayList<UserAndBookBorrowRecordsInfo> selectMyBorrowRecords(int uid);
    public ArrayList<UserAndBookBorrowRecordsInfo> selectBookBorrowInfo();

}

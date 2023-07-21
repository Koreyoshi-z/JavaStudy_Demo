package com.wwz.study.service.impl;

import com.wwz.study.dao.BorrowRecordsDao;
import com.wwz.study.dao.impl.BorrowRecordsDaoImpl;
import com.wwz.study.entity.BorrowRecords;
import com.wwz.study.entity.UserAndBookBorrowRecordsInfo;
import com.wwz.study.service.BorrowRecordsService;

import java.util.ArrayList;

//图书借阅记录业务层接口的实现类
public class BorrowRecordsServiceImpl implements BorrowRecordsService {
    private BorrowRecordsDao borrowRecordsDao = new BorrowRecordsDaoImpl();

    //添加借阅记录
    @Override
    public void add(BorrowRecords borrowRecords){
        borrowRecordsDao.add(borrowRecords);//调用add方法
    }

    //根据uid查询借阅记录
    @Override
    public ArrayList<UserAndBookBorrowRecordsInfo> selectMyBorrowRecords(int uid) {
        return borrowRecordsDao.selectBorrowRecordsById(uid);
    }

    //查看所有的图书借阅信息
    @Override
    public ArrayList<UserAndBookBorrowRecordsInfo> selectBookBorrowInfo() {
        return borrowRecordsDao.selectBookBorrowInfo();
    }

}

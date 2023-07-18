package com.wwz.study.service.impl;

import com.wwz.study.dao.BalanceRecordsDao;
import com.wwz.study.dao.impl.BalanceRecordsDaoImpl;
import com.wwz.study.entity.UserAndBalanceRecordsInfo;
import com.wwz.study.service.BalanceRecordsService;
import java.util.ArrayList;

//余额记录表业务逻辑实现类
public class BalanceRecordsServiceImpl implements BalanceRecordsService {
    private BalanceRecordsDao balanceRecordsDao = new BalanceRecordsDaoImpl();

    //查询某个用户的充值记录
    @Override
    public ArrayList<UserAndBalanceRecordsInfo> selectBalanceRecordsByUserIdAndBalanceType(int userId) {
        return balanceRecordsDao.selectInfoByUserIdAndBalanceType(userId, "充值");
    }

}

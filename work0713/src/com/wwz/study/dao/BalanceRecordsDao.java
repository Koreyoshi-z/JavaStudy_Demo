package com.wwz.study.dao;

import com.wwz.study.entity.BalanceRecords;
import com.wwz.study.entity.UserAndBalanceRecordsInfo;

import java.util.ArrayList;

public interface BalanceRecordsDao {
    public void add(BalanceRecords balanceRecords);
    public int getTotalAmountByUserId(int user_id,String record_type);
    public ArrayList<UserAndBalanceRecordsInfo> selectInfoByUserIdAndBalanceType(int user_id,String record_type);
}

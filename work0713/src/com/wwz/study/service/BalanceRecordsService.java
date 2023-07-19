package com.wwz.study.service;

import com.wwz.study.entity.BalanceRecords;
import com.wwz.study.entity.UserAndBalanceRecordsInfo;

import java.util.ArrayList;

//余额记录表业务接口
public interface BalanceRecordsService {
    public ArrayList<UserAndBalanceRecordsInfo> selectBalanceRecordsByUserIdAndBalanceType(int userId);
    public ArrayList<UserAndBalanceRecordsInfo> selectAllBalanceRecordsInfo();
    public ArrayList<String> selectRechargeLeaderboard();
}

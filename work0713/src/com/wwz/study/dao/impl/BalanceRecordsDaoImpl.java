package com.wwz.study.dao.impl;

import com.wwz.study.dao.BalanceRecordsDao;
import com.wwz.study.entity.BalanceRecords;
import com.wwz.study.entity.User;
import com.wwz.study.entity.UserAndBalanceRecordsInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//余额记录表数据访问接口实现类
public class BalanceRecordsDaoImpl extends BaseDao implements BalanceRecordsDao {
    //添加一条充值记录
    @Override
    public void add(BalanceRecords balanceRecords) {
        //如果数据库语句有换行，一行的末尾注意要空格。
        sql = "INSERT INTO balance_record(user_id,record_time,record_type,money)" +
                "VALUES(?,?,?,?)";
        getCon();
        try {
            preparedStatement.setInt(1,balanceRecords.getUser_id());
            preparedStatement.setString(2, balanceRecords.getRecord_time());
            preparedStatement.setString(3, balanceRecords.getRecord_type());
            preparedStatement.setInt(4,balanceRecords.getMoney());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
    }

    //查询用户充值或消费的总金额
    @Override
    public int getTotalAmountByUserId(int user_id, String record_type) {
        sql = "SELECT SUM(money) FROM balance_record WHERE user_id = ? AND record_type = ?";
        getCon();
        int sunAmount = 0;
        try {
            preparedStatement.setInt(1,user_id);
            preparedStatement.setString(2,record_type);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                sunAmount = resultSet.getInt("SUM(money)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return sunAmount;
    }


    //根据user_id获取该用户的所有订单记录(是完整信息带上账户名的)
    //需要有一个实体类可以装载两张表的字段形成一个新的数据
    @Override
    public ArrayList<UserAndBalanceRecordsInfo> selectInfoByUserIdAndBalanceType(int user_id, String record_type) {
        ArrayList<UserAndBalanceRecordsInfo> al = new ArrayList<>();
        sql = "SELECT balance_record.id,name,level,record_time,money " +
                "FROM user INNER JOIN balance_record ON user.id = user_id " +
                "WHERE user_id = ? AND record_type = ?";
        getCon();
        try {
            preparedStatement.setInt(1, user_id);
            preparedStatement.setString(2, record_type);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                //通过联查获取到相应的字段
                int balanceRecordId = resultSet.getInt("balance_record.id");
                String userName = resultSet.getString("name");
                int level = resultSet.getInt("level");
                String recordTime = resultSet.getString("record_time");
                int money = resultSet.getInt("money");
                User user = new User(user_id, userName, null, 0, level);
                BalanceRecords balanceRecords = new BalanceRecords(balanceRecordId, user_id, recordTime, record_type, money);
                //将联查到的一条数据的对象绑定在一个userAndBalanceRecordsInfo中
                UserAndBalanceRecordsInfo userAndBalanceRecordsInfo = new UserAndBalanceRecordsInfo(user, balanceRecords);
                al.add(userAndBalanceRecordsInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return al;
    }


    //根据类型查询所有用户的订单记录
    @Override
    public ArrayList<UserAndBalanceRecordsInfo> selectAllBalanceRecordsInfo(String record_type) {
        ArrayList<UserAndBalanceRecordsInfo> al = new ArrayList<>();
        sql = "SELECT balance_record.id,user.id,name,level,record_time,record_type,money " +
                "FROM user INNER JOIN balance_record ON user.id = user_id";
        getCon();
        try {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int balanceRecordId = resultSet.getInt("balance_record.id");
                int userId = resultSet.getInt("user.id");
                String userName = resultSet.getString("name");
                int level = resultSet.getInt("level");
                String recordTime = resultSet.getString("record_time");
                String recordType = resultSet.getString("record_type");
                int money = resultSet.getInt("money");
                User user = new User(userId, userName, null, 0, level);
                BalanceRecords balanceRecords = new BalanceRecords(balanceRecordId, userId, recordTime, recordType, money);
                UserAndBalanceRecordsInfo userAndBalanceRecordsInfo = new UserAndBalanceRecordsInfo(user,balanceRecords);
                al.add(userAndBalanceRecordsInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return al;
    }


    //根据金额和订单类型进行排序
    @Override
    public ArrayList<String> selectOrderSortInfo(String type, int limit) {
        ArrayList<String> al = new ArrayList<>();
        sql = "SELECT user.id,name,SUM(money),level FROM user INNER JOIN balance_record ON user.id = user_id " +
                "WHERE record_type = ? GROUP BY user_id ORDER BY SUM(money) DESC LIMIT ?";
        getCon();
        try {
            preparedStatement.setString(1, type);
            preparedStatement.setInt(2, limit);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int userId = resultSet.getInt("user.id");
                String name = resultSet.getString("name");
                int sumMoney = resultSet.getInt("SUM(money)");
                int level = resultSet.getInt("level");
                String str = "[" + "用户编号: " + userId + "\t账户: " + name + "\t充值金额: " +sumMoney + "\t等级: " + level +"]";
                al.add(str);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return al;
    }







}

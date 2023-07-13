package com.study.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

//负责数据库的CURD
public class Manager {


    //添加学生信息
    public void add(Stu stu){
        //1.获取数据库链接的对象Connection
        Connection connection = JdbcUtil.getCon();
        //2.编写数据库语句(可能暂时是不完整的)  ?:占位符
        String sql = "INSERT INTO stu(name,age,gender) VALUES(?,?,?)";
        //3.数据库预处理对象:其实就是对语句进行填充和指令的发送
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            //4.开始填充占位符:占位符的问号有编号从1开始,占位符的数据类型决定了调用的方法
            ps.setString(1, stu.getName());
            ps.setInt(2, stu.getAge());
            ps.setString(3, stu.getGender());
            //5.现在语句完整了 可以进行语句的发送(MYSQL)
            int res = ps.executeUpdate();//更新数据库数据
            System.out.println("受影响的行数:" + res);//res:数据库数据受影响的行数
            //6.关闭数据库链接
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //根据id删除一个学生
    public boolean removeById(int id){
        Connection connection = JdbcUtil.getCon();
        String sql = "DELETE FROM stu WHERE id = ?";
        int res = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            res = ps.executeUpdate();//增 删 改 三种方法都是调用update方法
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res == 0 ? false : true;//受影响的行数为0说明删除失败(这个不算是业务逻辑)
    }


    //根据id修改某个学生的name(因为一般我们会对每个属性的修改都写一个单独的方法)
    public boolean updateById(int id, String newName){
        int res = 0;
        Connection connection = JdbcUtil.getCon();
        String sql = "UPDATE stu SET name = ? WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,newName);
            ps.setInt(2,id);
            res = ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res == 0 ? false : true;
    }


    //查询所有数据
    public ArrayList<Stu> selectAll(){
        ArrayList<Stu> al = new ArrayList<>();
        Connection connection = JdbcUtil.getCon();
        //get获取字段值的时候,(字段名)一定是和你SELECT中描述的字段名保持一致的(函数名)
        String sql = "SELECT id,name,age,gender FROM stu";//实际开发不允许使用*  不便于维护
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            //创建一个结果集负责接收数据库中的数据
            ResultSet rs = ps.executeQuery();//查询的方法
            //遍历这个结果集,获取每个字段的值
            while (rs.next()){
                //在每一次循环中 获取每一列的字段值
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                Stu stu = new Stu(id, name, age, gender);
                al.add(stu);//添加进集合
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return al;
    }


    //查询男女各有多少人 出现2个结果值 男-4  女-5
    public HashMap<String,Integer> selectNumberGroupByGender(){
        HashMap<String,Integer> map = new HashMap<>();
        Connection connection = JdbcUtil.getCon();
        String sql = "SELECT gender,COUNT(*) FROM stu GROUP BY gender";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String gender = rs.getString("gender");//这里有几个性别就会返回几条数据
                int number = rs.getInt("COUNT(*)");
                map.put(gender,number);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }







}

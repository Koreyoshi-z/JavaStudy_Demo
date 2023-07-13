package com.study.jdbc;

import java.sql.Connection;
import java.util.*;

/*
* JDBC：其实就是数据库和JAVA链接的一种模式，让我们的JAVA可以通过代码操作数据库
*
* */
public class JdbcDemo {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);

        //添加学生
        System.out.println("请输入您要添加的 name");
        String name = scanner.next();
        System.out.println("请输入您要添加的 age");
        int age = scanner.nextInt();
        System.out.println("请输入您要添加的 gender");
        String gender = scanner.next();
        Stu stu = new Stu(0, name, age, gender);//id是自增的 任意给有个int类型的数据都行
        manager.add(stu);

        //删除学生
        System.out.println("请输入您要删除的学生的 id");
        int id = scanner.nextInt();
        boolean flag = manager.removeById(id);
        if (flag){
            System.out.println("删除成功！");
        }else {
            System.out.println("删除失败！");
        }


        //修改学生信息（名字）
        System.out.println("请输入您要修改的学生的 id");
        id = scanner.nextInt();
        System.out.println("请输入您要修改的学生的新名字");
        String newName = scanner.next();
        flag = manager.updateById(id, newName);
        if (flag){
            System.out.println("修改成功！");
        }else {
            System.out.println("修改失败！");//如果是业务逻辑修改失败可能有多种情况
        }


        //查询整张学生表
        System.out.println("查询 stu表 的结果");
        ArrayList<Stu> al = manager.selectAll();
        for (Stu s : al) {
            System.out.println(s);
        }


        //按指定条件查询
        System.out.println("查询男女各有多少人");
        HashMap<String, Integer> map = manager.selectNumberGroupByGender();
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }


    }
}
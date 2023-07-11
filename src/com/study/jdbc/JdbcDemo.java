package com.study.jdbc;

import java.sql.Connection;

/*
* JDBC：其实就是数据库和JAVA链接的一种模式，让我们的JAVA可以通过代码操作数据库
*
* */
public class JdbcDemo {
    public static void main(String[] args) {
        Connection connection = JdbcUtil.getCon();
        System.out.println(connection);
    }
}

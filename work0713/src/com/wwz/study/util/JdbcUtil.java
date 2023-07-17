package com.wwz.study.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
* 连接数据库需要准备4个参数
*
* DRIVER：数据库的驱动地址（不同数据库的驱动地址不同）
* URL：数据库链接地址（就是告知你要打开的仓库的地址database）
* USER：数据库账户名
* PASSWORD：数据库密码
*
* */
public class JdbcUtil {
    /*
    * URL,USER,PASSWORD 这三个属性值其实可以直接赋予，但是如果直接赋值的话会有一个问题:
    *
    * 如果我哪一天某个属性值发生改变了，那么就必须修改代码
    * 我们可以使用一个文件将这些值保存在文件中，然后通过代码每次读取文件中的值
    * 如果值有所变化，只需要修改文件中的值即可，不需要修改代码本身
    * 这个文件可以建立成配置文件.properties
    * */
    private static String DRIVER;
    private static String URL;
    private static String USER;
    private static String PASSWORD;


    //读取配置文件中的字段(静态代码块,类加载的时候直接执行)
    static {
        //1.获取文件的输入流
        try {
            FileInputStream fileInputStream = new FileInputStream("work0713/src/jdbc.properties");
            //2.创建配置文件工具类
            Properties properties = new Properties();
            //3.加载输入流到工具对象中
            properties.load(fileInputStream);
            //4.使用键值对的方式获取文本中的数据 key = xxxxxx
            DRIVER = properties.getProperty("driver");
            URL = properties.getProperty("url");
            USER = properties.getProperty("user");
            PASSWORD = properties.getProperty("password");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Connection:专门负责JDBC连接的对象
    public static Connection getCon(){
        Connection connection = null;
        //1.通过反射加载驱动地址: 在虚拟机运行的过程中将数据库的驱动地址加载到内存中
        try {
            Class.forName(DRIVER);
            //2.通过驱动管理者的对象去获取连接
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

}

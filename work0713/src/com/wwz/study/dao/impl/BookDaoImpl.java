package com.wwz.study.dao.impl;

import com.wwz.study.dao.BookDao;
import com.wwz.study.entity.Book;

import java.sql.SQLException;
import java.util.ArrayList;

//图书数据访问层接口的实现类
public class BookDaoImpl extends BaseDao implements BookDao {

    //查询所有图书信息
    @Override
    public ArrayList<Book> selectAllBook() {
        ArrayList<Book> al = new ArrayList<>();
        sql = "SELECT bid,name,author,des,price,status FROM book";
        getCon();
        try {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int bid = resultSet.getInt("bid");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                String des = resultSet.getString("des");
                double price = resultSet.getDouble("price");
                String status = resultSet.getString("status");
                Book book = new Book(bid, name, author, des, price, status);
                al.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeAll();
        }
        return al;
    }


    //借阅图书
    @Override
    public void borrowBook(int bid, String newStatus) {
        sql = "UPDATE book SET status = ? WHERE bid = ?";
        getCon();
        try {
            preparedStatement.setString(1, newStatus);
            preparedStatement.setInt(2, bid);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeAll();
        }
    }

    //根据name获取该书籍的所有信息
    @Override
    public Book selectByName(String name) {
        sql = "SELECT bid,name,author,des,price,status FROM book WHERE name = ?";
        getCon();
        Book book = null;
        try {
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int bid = resultSet.getInt("bid");
                String author = resultSet.getString("author");
                String des = resultSet.getString("des");
                double price = resultSet.getDouble("price");
                String status = resultSet.getString("status");
                book = new Book(bid, name, author, des, price, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return book;
    }


    //根据bid获取该书籍的所有信息
    @Override
    public Book selectByBid(int bid) {
        sql = "SELECT bid,name,author,des,price,status FROM book WHERE bid = ?";
        getCon();
        Book book = null;
        try {
            preparedStatement.setInt(1,bid);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                String des = resultSet.getString("des");
                double price = resultSet.getDouble("price");
                String status = resultSet.getString("status");
                book = new Book(bid, name, author, des, price, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return book;
    }
























}

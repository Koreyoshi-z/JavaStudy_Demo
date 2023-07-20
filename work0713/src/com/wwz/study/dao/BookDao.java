package com.wwz.study.dao;

import com.wwz.study.entity.Book;
import java.util.ArrayList;

//图书数据访问层接口
public interface BookDao {
    public ArrayList<Book> selectAllBook();
    public void borrowBook(int bid, String newStatus);
    public Book selectByBid(int bid);
    public Book selectByName(String name);

}

package com.wwz.study.service;

import com.wwz.study.entity.Book;

import java.util.ArrayList;

//图书的业务层接口
public interface BookService {
    public ArrayList<Book> selectAllBook();
    public int borrowBook(int bid);
    public Book selectByName(String name);

}

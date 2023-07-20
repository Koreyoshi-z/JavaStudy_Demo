package com.wwz.study.service.impl;

import com.wwz.study.dao.BookDao;
import com.wwz.study.dao.UserDao;
import com.wwz.study.dao.impl.BookDaoImpl;
import com.wwz.study.dao.impl.UserDaoImpl;
import com.wwz.study.entity.Book;
import com.wwz.study.service.BookService;
import java.util.ArrayList;

//图书的业务层接口实现类
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    private UserDao userDao = new UserDaoImpl();

    //查询所有图书信息
    @Override
    public ArrayList<Book> selectAllBook() {
        return bookDao.selectAllBook();
    }

    //借阅图书
    @Override
    public int borrowBook(int bid) {//uid是当前登录账户的user_id
        Book book = bookDao.selectByBid(bid);
        //判断图书的状态
        if (!book.getStatus().equals("空闲")){
            return -1;//不可借阅
        }
        bookDao.borrowBook(bid,"借用");//修改图书的状态
        return 1;
    }

    //根据书籍名获取整本书的信息
    @Override
    public Book selectByName(String name) {
        return bookDao.selectByName(name);
    }

    //


}

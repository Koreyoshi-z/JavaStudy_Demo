package com.wwz.study.service.impl;

import com.wwz.study.dao.BookDao;
import com.wwz.study.dao.BorrowRecordsDao;
import com.wwz.study.dao.impl.BookDaoImpl;
import com.wwz.study.dao.impl.BorrowRecordsDaoImpl;
import com.wwz.study.entity.Book;
import com.wwz.study.entity.BorrowRecords;
import com.wwz.study.service.BookService;
import com.wwz.study.util.MyUtil;
import java.util.ArrayList;

//图书的业务层接口实现类
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    private BorrowRecordsDao borrowRecordsDao = new BorrowRecordsDaoImpl();

    //查询所有图书信息
    @Override
    public ArrayList<Book> selectAllBook() {
        return bookDao.selectAllBook();
    }


    //借阅图书
    @Override
    public int borrowBook(int bid, int uid) {
        Book book = bookDao.selectByBid(bid);
        //图书列表是否为空
        if (book == null){
            return -1;//没有图书
        }
        //判断图书的状态
        if (!book.getStatus().equals("空闲")){
            return -2;//不可借阅
        }
        bookDao.borrowBook(bid,"借用");//修改图书的状态
        BorrowRecords borrowRecords = new BorrowRecords(0, bid, uid, MyUtil.getTime(), null);
        borrowRecordsDao.add(borrowRecords);//添加借阅记录
        return 1;//借阅成功
    }


    //归还图书
    @Override
    public int returnBook(int bid, int uid) {
        Book book = bookDao.selectByBid(bid);
        //图书列表是否为空
        if (book == null){
            return -1;//没有图书
        }
        //判断图书的状态
        if (!book.getStatus().equals("借用")){
            return -2;//不必归还
        }
        bookDao.borrowBook(bid,"空闲");
        //borrowRecordsDao.remove(bid, uid);  无需使用调用remove()方法,否则借书记录在归还图书后直接消失
        BorrowRecords borrowRecords = new BorrowRecords(0, bid, uid, null,MyUtil.getTime());
        borrowRecordsDao.add(borrowRecords);//添加归还记录失败？？？ ->改变add()顺序，放到最后
        return 1;//归还成功
    }


    //根据书籍名获取整本书的信息
    @Override
    public Book selectByName(String name) {
        return bookDao.selectByName(name);
    }


    //添加图书
    @Override
    public int addBook(Book book) {
        if (book == null){
            return -1;//图书为空
        }
        //看是否已有图书，已经存在的图书不能在添加
        if (bookDao.selectByName(book.getName()) != null){
            return -2;//图书名已经存在，不能在添加相同名字的书籍。
        }
        bookDao.addBook(book);
        return 1;
    }


    //根据图书名称删除图书
    @Override
    public int removeBook(String name) {
        //判断是否存在该图书
        if (bookDao.selectByName(name) == null){
            return -1;//不存在该图书，删除失败！
        }
        bookDao.removeBook(name);
        return 1;
    }


}

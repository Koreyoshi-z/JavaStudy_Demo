package com.wwz.study.entity;

/*
这是一个负责联查的实体类
数据库中本身是没有联查的表的 多表在联查的时候临时生成的一个表
这个实体类其实就是负责对应这个临时生成的表
*/
public class UserAndBookBorrowRecordsInfo {
    private User user;
    private Book book;
    private BorrowRecords borrowRecords;

    //生成的UserAndBookBorrowRecordsInfo会将user.book和borrowRecords绑定在一起
    public UserAndBookBorrowRecordsInfo(User user, Book book, BorrowRecords borrowRecords) {
        this.user = user;
        this.book = book;
        this.borrowRecords = borrowRecords;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BorrowRecords getBorrowRecords() {
        return borrowRecords;
    }

    public void setBorrowRecords(BorrowRecords borrowRecords) {
        this.borrowRecords = borrowRecords;
    }

    @Override
    public String toString() {
        return "[" +
                "记录编号: " + borrowRecords.getId() +
                "\t书籍编号: " + borrowRecords.getBid() +
                "\t账户编号: " + borrowRecords.getUid() +
                "\t借阅书籍: " + book.getName() +
                "\t账户名: " + user.getName() +
                "\t借书时间: " + borrowRecords.getBorrow_time() +
                "\t还书时间: " + borrowRecords.getReturn_time() +
                "]";
    }

}

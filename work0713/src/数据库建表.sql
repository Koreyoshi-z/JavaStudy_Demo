-- 用户表
CREATE TABLE user(
    id INT AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    balance INT DEFAULT 0,
    level INT DEFAULT 0,
    PRIMARY KEY (id)
);

-- 余额记录表
CREATE TABLE balance_record(
    id INT AUTO_INCREMENT,
    user_id INT,-- 外键，用户的id，需要使用关联多表联查。
    record_time VARCHAR(20),-- 记录的时间
    record_type VARCHAR(20),-- 订单的类型(充值或消费)
    money INT,-- 订单的金额
    PRIMARY KEY (id)
);

-- 图书表
CREATE TABLE book(
    bid INT AUTO_INCREMENT,-- 书籍编号
    name VARCHAR(20),-- 书名
    author VARCHAR(20), -- 作者名
    des VARCHAR(500),-- 对于书籍的简单描述
    price DOUBLE DEFAULT 0,-- 价格
    status VARCHAR(20) DEFAULT '空闲',-- 图书的状态(空闲和借用)
    PRIMARY KEY (bid)
);

-- 图书借阅记录表
CREATE TABLE borrow_record(
    id INT AUTO_INCREMENT,
    bid INT NOT NULL,-- 外键 书籍编号
    uid INT NOT NULL,-- 外键 用户编号
    userName VARCHAR(20),
    bookName VARCHAR(20),
    price DOUBLE,
    borrow_time VARCHAR(20),
    return_time VARCHAR(20),
    PRIMARY KEY (id)
);
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
-- 用户表
CREATE TABLE user(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    balance INT DEFAULT 0,
    level INT DEFAULT 0,
    PRIMARY KEY (id)
);
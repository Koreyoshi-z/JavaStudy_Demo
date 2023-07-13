CREATE TABLE user(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20),
    password VARCHAR(20),

    level INT DEFAULT 0,
    PRIMARY KEY (id)
);
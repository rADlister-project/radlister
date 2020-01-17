USE adlister_db;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) NOT NULL,
    email VARCHAR(240) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ads (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    title VARCHAR(240) NOT NULL,
    price float,
    description TEXT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

 CREATE TABLE category (
     id INT,
     description Varchar(240)
);

 Create Table ad_category (
     ad_id Int NOT NULL,
     cat_id Int NOT NULL,
     Foreign Key (ad_id) REFERENCES ads(id) ON DELETE CASCADE ,
     foreign key (cat_id) references category(id) ON DELETE CASCADE
 );
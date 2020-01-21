USE radlister_db;

DROP TABLE IF EXISTS ad_category;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;

CREATE TABLE  users (
                       id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                       username VARCHAR(240) NOT NULL,
                       email VARCHAR(240) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       PRIMARY KEY (id),
                       UNIQUE (username),
                       UNIQUE (email)


);

CREATE TABLE ads (

                     id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                     user_id INT UNSIGNED NOT NULL,
                     title VARCHAR(240) NOT NULL,
                     price INT UNSIGNED NOT NULL,
                     description TEXT NOT NULL,
                     PRIMARY KEY (id),
                     FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
CREATE TABLE category (
                          id INT UNSIGNED NOT NULL,
                          description Varchar(240),
                          PRIMARY KEY (id)
);
Create Table ad_category (
                             ad_id Int UNSIGNED NOT NULL,
                             cat_id Int UNSIGNED NOT NULL,
                             FOREIGN KEY (ad_id) REFERENCES ads(id) ON DELETE CASCADE,
                             FOREIGN KEY (cat_id) REFERENCES category(id) ON DELETE CASCADE,
                             PRIMARY KEY (ad_id, cat_id)
);

show tables;

DELETE FROM users where id  = 5;


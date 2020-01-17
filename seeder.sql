INSERT INTO category (id, description)
VALUES (1, 'For Sale'),
       (2, 'Free Stuff'),
       (3, 'Help Wanted'),
       (4, 'Gigs'),
       (5, 'Services'),
       (6, 'Housing'),
       (7, 'Community');

INSERT INTO users (username, email, password)  VALUES ('user1', 'user1@radlister.com', 'password');

INSERT INTO ads (user_id, title, price, description) VALUES (1, 'guitar', 99900, 'buy now');

INSERT INTO ad_category (ad_id, cat_id) VALUES (1,1);
INSERT INTO ad_category (ad_id, cat_id) VALUES (1,4);



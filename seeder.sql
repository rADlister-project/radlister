INSERT INTO category (id, description)
VALUES (1, 'For Sale'),
       (2, 'Free Stuff'),
       (3, 'Help Wanted'),
       (4, 'Gigs'),
       (5, 'Services'),
       (6, 'Housing'),
       (7, 'Community');

insert into users (username, email, password) values ('user1', 'user1@radlister.com','user1password');


insert into ads (user_id, title, price, description) values (1, 'guitar', 9999, 'fender guitar, OBO');
insert into ads (user_id, title, price, description) values (1, 'drumset', 35000, 'Annoy your mom!');

insert into ad_category (ad_id, cat_id) values (1,1);
insert into ad_category (ad_id, cat_id) values (1,4);


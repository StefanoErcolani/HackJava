CREATE TABLE menu(
    id bigint auto_increment primary key,
    dish_name varchar(64),
    ingredients varchar(1024) default 'https://aulab.it/aulab_restaurant.png',
    price int default 12 check( price > 0),
    restaurant_id int references restaurant(id)
);
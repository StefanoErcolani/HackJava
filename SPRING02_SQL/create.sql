-- CREATE TABLE restaurant(
--     id BIGINT auto_increment primary key,
--     name varchar(64),
--     description varchar(1023),
--     number_clients int check( number_clients > 0 )
-- );

-- CREATE TABLE menu(
--     id bigint auto_increment primary key,
--     dish_name varchar(64),
--     ingredients varchar(1024) default 'https://aulab.it/aulab_restaurant.png',
--     price int default 12 check( price > 0),
--     restaurant_id int references restaurant(id)
-- );
-- CREATE TABLE clients(
--     id bigint auto_increment primary key,
--     client_name varchar(24),
--     client_bank_account varchar(64) default 'pippo',
--     client_cuenta int check (client_cuenta > 20)

-- );

-- CREATE TABLE menu_clients(
--     menu_id bigint references menu(id),
--     clients_id bigint references clients(id)
-- );
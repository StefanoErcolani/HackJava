-- CREATE TABLE authors(
--     id bigint auto_increment primary key,
--     firstname varchar(24) not null,
--     lastname varchar(24) not null,
--     email varchar(24) not null
-- );

-- CREATE TABLE posts(

--     id bigint auto_increment primary key,
--     title varchar(48) not null,
--     body varchar(1024) not null,
--     publish_date char(8) not null,
--     author_id bigint references authors(id)

-- );

-- CREATE TABLE comments(

--     id bigint auto_increment primary key,
--     email varchar(24) not null,
--     body varchar(240) not null,
--     post_date char(8) not null,
--     post_id bigint references posts(id)

-- );
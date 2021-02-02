
create table author (
	id int8  primary key,
    author_name varchar(50),
    age int
);

create table book (
	id int8  primary key,
    book_name varchar(50),
    age int,
    author_id  int8,
       foreign key(author_id)
       references author(id)
);

create table users (
	id int8  primary key,
    user_name varchar(50),
    password varchar(20),
    role_id int8
);
create table roles (
	id int8  primary key,
    role_name varchar (20)
);

INSERT INTO public.roles
(id, "name")
VALUES(1, 'ADMIN');

INSERT INTO public.users
("name", "password", role_id)
VALUES('ADMIN', 'ADMIN', 1);

--create table author_book (
--	author int8 ,
--	book int8,
--	primary key (author,book)
--);

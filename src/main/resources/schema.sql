create table author (
	id int8  primary key,
    _name varchar(50),
    age int
);

create table book (
	id int8  primary key,
    _name varchar(50),
    age int,
    author_id  int8,
       foreign key(author_id)
       references author(id)
);

--create table author_book (
--	author int8 ,
--	book int8,
--	primary key (author,book)
--);

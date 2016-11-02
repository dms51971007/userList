DROP DATABASE IF EXISTS test;

CREATE DATABASE test DEFAULT CHARACTER SET 'utf8';

USE test;

create table User
(
	id int(8) auto_increment PRIMARY KEY,
	name varchar(25),
	age int,
	isAdmin bit,
	createdDate timestamp
);

set names 'utf8';

INSERT INTO User (id, name, age, isAdmin, createdDate) values(1, 'fedor', 12,  1, now());
INSERT INTO User (id, name, age, isAdmin, createdDate) values(2, 'fedor1', 13,  0, now());
INSERT INTO User (id, name, age, isAdmin, createdDate) values(3, 'fedor2', 14,  1, now());
INSERT INTO User (id, name, age, isAdmin, createdDate) values(4, 'fedor3', 15,  0, now());
INSERT INTO User (id, name, age, isAdmin, createdDate) values(5, 'fedor4', 16,  1, now());
INSERT INTO User (id, name, age, isAdmin, createdDate) values(6, 'fedor5', 16,  0, now());
INSERT INTO User (id, name, age, isAdmin, createdDate) values(7, 'fedor6', 18,  1, now());
INSERT INTO User (id, name, age, isAdmin, createdDate) values(8, 'fedor7', 19,  0, now());
INSERT INTO User (id, name, age, isAdmin, createdDate) values(9, 'fedor8', 19,  1, now());
INSERT INTO User (id, name, age, isAdmin, createdDate) values(10, 'fedor9', 19,  0, now());
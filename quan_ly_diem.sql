create database ScoreManagement;

use ScoreManagement;

create table students(
	stdCode int primary key auto_increment unique,
    stdName varchar(255) not null,
    stdAge int not null,
    stdClass varchar(50) not null,
    stdGPA double not null,
    stdGender varchar(10) not null);
    
insert into students values(1,'Anh',18,'Java2',4.0,'Nu');

select*from students;
use jleong1_a5;
create table EMP (
id int,
primary key (id),
name varchar(30),
dnumber int
);

create table DEPT (
dname varchar(20),
dno int,
primary key (dno)
);

alter table EMP add foreign key (dnumber) references DEPT(dno);


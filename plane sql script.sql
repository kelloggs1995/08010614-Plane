drop table if exists realplane;
create table realplane
(
planenos char(2) not null,
seatnos integer(2) not null,
status boolean,
passengertype integer(2),
passengername char(20),
passengeremail char(40),
passengeraccountnos int(10),
primary key(planenos,seatnos)
);
insert into realplane values ('A',1,true,0,null,null,null);
insert into realplane values ('A',2,true,0,null,null,null);
insert into realplane values ('A',3,true,0,null,null,null);
insert into realplane values ('A',4,true,0,null,null,null);
insert into realplane values ('A',5,true,0,null,null,null);
insert into realplane values ('A',6,true,0,null,null,null);
insert into realplane values ('A',7,true,0,null,null,null);
insert into realplane values ('A',8,true,0,null,null,null);
insert into realplane values ('B',1,true,0,null,null,null);
insert into realplane values ('B',2,true,0,null,null,null);
insert into realplane values ('B',3,true,0,null,null,null);
insert into realplane values ('B',4,true,0,null,null,null);
insert into realplane values ('B',5,true,0,null,null,null);
insert into realplane values ('B',6,true,0,null,null,null);
insert into realplane values ('B',7,true,0,null,null,null);
insert into realplane values ('B',8,true,0,null,null,null);

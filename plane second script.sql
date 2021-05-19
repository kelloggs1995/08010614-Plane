drop table if exists realplane;
create table realplane
(
planenos char(2) not null,
seatnos integer(2) not null,
status integer,
availibility boolean,
passengertype integer(2),
passengername char(20),
passengercompany char(40),
passengerisland char(40),
discount float(20),

primary key(planenos,seatnos)
);
insert into realplane values ('A',1,0,0,false,null,null,null,null);
insert into realplane values ('A',2,0,0,false,null,null,null,null);
insert into realplane values ('A',3,0,0,false,null,null,null,null);
insert into realplane values ('A',4,0,0,false,null,null,null,null);
insert into realplane values ('A',5,0,0,false,null,null,null,null);
insert into realplane values ('A',6,0,0,false,null,null,null,null);
insert into realplane values ('A',7,0,0,false,null,null,null,null);
insert into realplane values ('A',8,0,0,false,null,null,null,null);
insert into realplane values ('B',1,0,0,false,null,null,null,null);
insert into realplane values ('B',2,0,0,false,null,null,null,null);
insert into realplane values ('B',3,0,0,false,null,null,null,null);
insert into realplane values ('B',4,0,0,false,null,null,null,null);
insert into realplane values ('B',5,0,0,false,null,null,null,null);
insert into realplane values ('B',6,0,0,false,null,null,null,null);
insert into realplane values ('B',7,0,0,false,null,null,null,null);
insert into realplane values ('B',8,0,0,false,null,null,null,null);
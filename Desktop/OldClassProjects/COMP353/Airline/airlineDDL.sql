create database jleong1_AIRLINE;
use jleong1_AIRLINE;

create table AIRPORT(
airport_code varchar(3),
name varchar(20),
city varchar(15),
state varchar(2),
primary key (airport_code));

create table FLIGHT(
flight_number int,
airline varchar(20),
weekdays varchar(5),
primary key (flight_number));

create table FLIGHT_LEG(
f_number int,
leg_number int,
departure_airport_code varchar(3),
scheduled_departure_time varchar(5),
arrival_airport_code varchar(3),
scheduled_arrival_time varchar(5),
primary key(f_number,leg_number,departure_airport_code,scheduled_departure_time,arrival_airport_code,scheduled_arrival_time));

create table LEG_INSTANCE(
flightnum int,
leg_num int,
date varchar(10),
num_of_avail_seats int,
airplane_id int,
depart_aircode varchar(3),
depart_time varchar(5),
arrival_aircode varchar(3),
arrival_time varchar(5),
primary key(flightnum));

create table FARE(
flinumber int,
fare_code int,
amount int,
restrictions varchar(10),
primary key(amount));

create table AIRPLANE_TYPE(
airplane_type_name varchar(20),
max_seats int,
company varchar(8),
primary key(airplane_type_name));

create table CAN_LAND(
airtype_name varchar(20),
airp_code varchar(3),
primary key(airtype_name));

create table AIRPLANE(
airplaneID int,
total_num_of_seats int,
airplane_typen varchar(20),
primary key(airplaneID));

create table SEAT_RESERVATION(
f_num int,
l_num int,
dat varchar(10),
seat_number varchar(3),
customer_name varchar(30),
customer_phone varchar(13),
primary key(customer_name));


alter table FLIGHT_LEG add foreign key (f_number) references  FLIGHT(flight_number);
alter table FARE add foreign key (flinumber) references FLIGHT(flight_number);
alter table CAN_LAND add foreign key (airtype_name) references AIRPLANE_TYPE(airplane_type_name);
alter table AIRPLANE add foreign key (airplane_typen) references AIRPLANE_TYPE(airplane_type_name);
alter table SEAT_RESERVATION add foreign key (f_num) references FLIGHT(flight_number);

alter table LEG_INSTANCE add foreign key(flightnum) references FLIGHT(flight_number);
alter table LEG_INSTANCE add foreign key (leg_num,depart_aircode,arrival_aircode,depart_time,arrival_time) references FLIGHT_LEG(leg_number,departure_airport_code, arrival_airport_code,scheduled_departure_time, scheduled_arrival_time);
alter table SEAT_RESERVATION add foreign key(l_num) references FLIGHT_LEG(leg_number);



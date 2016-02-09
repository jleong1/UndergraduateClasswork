create database jleong1_AIRLINE;
use jleong1_AIRLINE;

create table AIRPORT(airport_code varchar(3),name varchar(20),city varchar(15),state varchar(2));

create table FLIGHT(flight_number int,airline varchar(20),weekdays varchar(5));

create table FLIGHT_LEG(f_number int,leg_number int,departure_airport_code varchar(3),scheduled_departure_time varchar(5),arrival_airport_code varchar(3),scheduled_arrival_time varchar(5));

create table LEG_INSTANCE(flightnum int,leg_num int,date varchar(10),num_of_avail_seats int,airplane_id int,depart_aircode varchar(3),depart_time varchar(5),arrival_aircode varchar(3),arrival_time varchar(5));

create table FARE(flinumber int,fare_code int,amount int,restrictions varchar(10));

create table AIRPLANE_TYPE(airplane_type_name varchar(20),max_seats int,company varchar(8));

create table CAN_LAND(airtype_name varchar(20),airp_code varchar(3));

create table AIRPLANE(airplaneID int,total_num_of_seats int,airplane_typen varchar(20));

create table SEAT_RESERVATION(f_num int,l_num int,dat varchar(10),seat_number varchar(3),customer_name varchar(30),customer_phone varchar(13));

alter table AIRPORT add primary key (airport_code);
alter table FLIGHT add primary key (flight_number);
alter table FLIGHT_LEG add primary key(f_number,leg_number, departure_airport_code,arrival_airport_code, scheduled_arrival_time, scheduled_departure_time);
alter table LEG_INSTANCE add primary key(leg_num,date);
alter table FARE add primary key(amount);
alter table AIRPLANE_TYPE add primary key(airplane_type_name);
alter table CAN_LAND add primary key(airtype_name);
alter table AIRPLANE add primary key(airplaneID);
alter table SEAT_RESERVATION add primary key(customer_name);


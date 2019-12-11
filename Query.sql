create table Employeef( 
	emp_id varchar2(20) PRIMARY KEY,
	password varchar2(20) NOT NULL, 
	role varchar2(30) NOT NULL, 
	time_stamp timestamp );
	
	drop table employeef

	create table customerf(
	customer_id number(9) PRIMARY KEY, 
	ssnid number(9) NOT NULL UNIQUE, 
	name varchar2(20) NOT NULL, 
	age number(3) NOT NULL, 
	address_line1 varchar2(100) NOT NULL, 
	address_line2 varchar2(100),
	city varchar2(20) NOT NULL, 
	state varchar2(20) NOT NULL);

insert into customerf values (cust_id.nextval,123456789,'Rakesh',23,'Gowlidoddi','Gachibowli','hyderabad','Telangana');	
	
create table accountf(
	customer_id number(9) REFERENCES customerf(customer_id) NOT NULL, 
    ssnid number(9) REFERENCES customerf(ssnid) NOT NULL, 
	account_id number(9) PRIMARY KEY,
    account_type varchar2(10) NOT NULL, 
	balance number(20) CHECK(balance>=0) NOT NULL);
	
	drop table accountf;
	
	insert into accountf values ((select customer_id from customerf where name='Rakesh'),(select ssnid from customerf where name='Rakesh'),acc_id.nextval,'Savings',5666);

create table transactionf(
	transaction_id number(30) PRIMARY KEY,
	account_id number(9) REFERENCES accountf(account_id) NOT NULL,
	Amount number(20) CHECK(amount>=0) NOT NULL,
	transaction_type varchar2(10) NOT NULL,
	message varchar2(100) NOT NULL,
	trans_date timestamp NOT NULL);
	
create table account_statusf(
	customer_id number(9) REFERENCES customerf(customer_id) NOT NULL,
	account_id number(9) REFERENCES accountf(account_id) NOT NULL,
	account_type varchar2(10) NOT NULL,
	status varchar2(100) NOT NULL,
	message varchar2(100) NOT NULL,
	last_updated timestamp NOT NULL);
	
create table customer_statusf (
	customer_id number(9) REFERENCES customerf(customer_id) NOT NULL,
	ssnid number(9) REFERENCES customerf(ssnid)  NOT NULL,
	status varchar2(100) NOT NULL,
	message varchar2(100) NOT NULL,
	last_updated timestamp NOT NULL);

	select * from accountf
drop  SEQUENCE cust_id;

CREATE SEQUENCE cust_id
START WITH 100000000
INCREMENT BY 1
CACHE 10

CREATE SEQUENCE acc_id
START WITH 110000000
INCREMENT BY 1
CACHE 10

CREATE SEQUENCE trans_id
START WITH 1100000000
INCREMENT BY 1
CACHE 10


select * from EMPLOYEEF;
drop table customerf;
delete from EMPLOYEEF where emp_id='Raif1234';
insert into EMPLOYEEF values ('Raif1234','password12','cashier',sysdate);
insert into EMPLOYEEF values ('Raif12345','password12','cae',sysdate);


insert into customerf values(cust_id.nextval,123457896,'shd',45,'gdsv','hjsdc','jdgc','jgdsvc');
insert into customer_statusf values(cust_id.currval,123457896,'dfgs','gsg',sysdate);
select * from customerf


select * from accountf
select * from customer_statusf

select * from TRANSACTIONF
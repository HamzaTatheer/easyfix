create table customers(
id int AUTO_INCREMENT,
name varchar(50),
 email varchar(50),
 password varchar(50),
 credit_no varchar(50) DEFAULT 'cash',
 wallet float,
 city varchar(50), 
 area varchar(50),
 primary key(id)
);

INSERT INTO `easyfix`.`customers`
(
`name`,
`email`,
`password`,

`wallet`,
`city`,
`area`)
VALUES
(
"noor",
"noor14211@gmail",
"abcd",

100,
"lahore",
"wapda town");

create table worker(
 wid int AUTO_INCREMENT,
 name varchar(50),
 email varchar(50),
 password varchar(50),
 average_rating float,
 hourly_rate float,
 city varchar(50),
 area varchar(50),
 speciality varchar(50),
 
 primary key(wid)

);

create table favorite(
id int ,
favourite int,

 foreign key(id) references customers(id),
 foreign key(favourite) references worker(wid)
);




create table booking(
bid int AUTO_INCREMENT,
 customer_id int,
 worker_id int, 
 booking_text varchar(100),
 booking_status varchar(50),
 start_time datetime,
 end_time datetime ,
 primary key(bid),
 foreign key(customer_id) references customers(id),
 foreign key(worker_id) references worker(wid)
);

create table booking_spareparts(bid int ,part_id int);


create table billing (
id int AUTO_INCREMENT,
bid int,
totalcost int,
primary key(id),
foreign key(bid) references booking(bid)
);


create table complain (
id int AUTO_INCREMENT,
cid int,
wid int,
complain_text varchar(200),
primary key(id),
foreign key(wid) references worker(wid),
foreign key(cid) references customers(id)
);


create table sparepart(
id int AUTO_INCREMENT,
part_name varchar(50),
cost float,
quantity int,

primary key(id)
);

create table rating(
cid int,
wid int,
rate int,
foreign key(wid) references worker(wid),
foreign key(cid) references customers(id)

);

create table chat(
 senderId int,
 receiverId int,
 senderName varchar(50),
 receiverName varchar(50),
 message varchar(200)

)

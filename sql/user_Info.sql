create table user_Info (
	id INT AUTO_INCREMENT PRIMARY KEY,
	userName VARCHAR(50),
	password VARCHAR(500),
	gender VARCHAR(50),
	city VARCHAR(9)
);

create table reservation_Info(
	resId INT AUTO_INCREMENT PRIMARY KEY,
	userId INT NOT NULL,
	userName VARCHAR(50),
	resType VARCHAR(20),
	roomType VARCHAR(50),
	stayDuration INT,
	mealStatus VARCHAR(10),
	mealType VARCHAR(15),
	resDate VARCHAR(15),
	resTime VARCHAR(15),
	meetingDuration INT,
	addService BOOLEAN,
	noGuest INT,
	resFor VARCHAR(50),
	FOREIGN KEY fk_uid(userId)
	REFERENCES user_Info(id)	
);

create table roomService_Info (
        rmserid INT AUTO_INCREMENT PRIMARY KEY,
        customerName VARCHAR(50),
        resType VARCHAR(50),
	roomNumber INT,
        mealNeeded VARCHAR(50),
        houseKeepingNeeded VARCHAR(50),
        mealType VARCHAR(50),
	time FLOAT,
        FOREIGN KEY fk_cn(customerName)
	REFERENCES reservation_Info(userName)	
);


create table propertyInventory_Info(
	itemId INT AUTO_INCREMENT PRIMARY KEY,
	Item VARCHAR(50),
	Type VARCHAR(9),
	Quantity INT,
	Price FLOAT,
        Category VARCHAR(50),
	Unitprice FLOAT
);

create table newOrderInventory_Info(
	Item VARCHAR(50) PRIMARY KEY,
	Quantity INT,
        Unitprice FLOAT,
        Amount FLOAT
);

create table expenses_Info (
	billId INT AUTO_INCREMENT PRIMARY KEY,
	Date VARCHAR(50),
	Time VARCHAR(50),
	userId INT,
	userName VARCHAR(50),
	isRoomReserved VARCHAR(25),
	isRestaurantReserved VARCHAR(25),
	isBanquetReserved VARCHAR(25),
	isHallReserved VARCHAR(25),
	roomTotal FLOAT,
	restaurantTotal FLOAT,
	banquetTotal FLOAT,
	hallTotal FLOAT,
	totalAmount FLOAT,
	discount FLOAT,
	finalAmount FLOAT
);

create table transactions_Info (
	tran_Id INT AUTO_INCREMENT PRIMARY KEY,
	Date VARCHAR(50),
	Time VARCHAR(50),
	userId INT,
	userName VARCHAR(50),
	amountPaid FLOAT,
	paymentMode VARCHAR(50),
	cardNumber LONG,
	cardExpiryDate VARCHAR(50),
	cardSecurityCode INT
);

create table staff_info (
	id INT AUTO_INCREMENT PRIMARY KEY, 
	userName VARCHAR(50),
	password VARCHAR(500),
	gender VARCHAR(8),
	city VARCHAR(50));

create table review_Info(
	id INT AUTO_INCREMENT PRIMARY KEY, 
	CommentVARCHAR(50);

insert into user_Info (id, userName, password, gender, city) values (1, 'admin', 'Ir/fUTgc8U2xRkMahklhpA==', 'Male', 'Surrey');
insert into user_Info (id, userName, password, gender, city) values (2, 'Willy', 'Ybx420ouUsfak+MtRRxWHg==', 'Male', 'Victoria');
insert into user_Info (id, userName, password, gender, city) values (3, 'Bev', 'KszTy1QLxfs0ngAVCzDu3A==', 'Male', 'Richmond');
insert into user_Info (id, userName, password, gender, city) values (4, 'Pauletta', '79OPV6GWGD+uaa9leZQBug==', 'Female', 'Burnaby');
insert into user_Info (id, userName, password, gender, city) values (5, 'Teddi', 'urx+nS0vdE4+dyjMMDuZGQ==', 'Female', 'Victoria');
insert into user_Info (id, userName, password, gender, city) values (6, 'Miller', 'eOmqANjJ3eCzz3oDXM8yPA==', 'Male', 'Victoria');
insert into user_Info (id, userName, password, gender, city) values (7, 'Orton', 'e1vhOLkszBr2d4roMuGnDQ==', 'Male', 'Burnaby');
insert into user_Info (id, userName, password, gender, city) values (8, 'Ricki', 'GJOm7E8PdyPkQpV/vireYA==', 'Female', 'Vancouver');
insert into user_Info (id, userName, password, gender, city) values (9, 'Ronnie', 'YTuldEyEyEQbasoJ6gVbuQ==', 'Female', 'Vancouver');
insert into user_Info (id, userName, password, gender, city) values (10, 'Donetta', 'cDPnVqyugWaBR0YY1IFMVQ==', 'Female', 'Surrey');
insert into user_Info (id, userName, password, gender, city) values (11, 'Graeme', 'TKlO/ydDILvDTIHZlPp7AQ==', 'Male', 'Richmond');
insert into user_Info (id, userName, password, gender, city) values (12, 'Alix', 'uaIL16HDvd/goFeUUvnlgg==', 'Male', 'Surrey');
insert into user_Info (id, userName, password, gender, city) values (13, 'Allard', '3OX+QchxWDdwsccDMbAZDg==', 'Male', 'Burnaby');
insert into user_Info (id, userName, password, gender, city) values (14, 'Sarah', 'czl1nwXRajIFW2YYC4xWxg==', 'Female', 'Victoria');
insert into user_Info (id, userName, password, gender, city) values (15, 'Robinett', 'G+a6Xz+9CeQu6Kxo3Oimng==', 'Female', 'Vancouver');
insert into user_Info (id, userName, password, gender, city) values (16, 'Puff', '+jX+bu02l3sxhTHPN3hnvg==', 'Male', 'Richmond');
insert into user_Info (id, userName, password, gender, city) values (17, 'Winfield', 'p8WZ80fDj8r4V8eVyFv7fQ==', 'Male', 'Burnaby');
insert into user_Info (id, userName, password, gender, city) values (18, 'Gil', 'a3+RglUbgaFxVbENbEqdZQ==', 'Male', 'Surrey');
insert into user_Info (id, userName, password, gender, city) values (19, 'Clywd', 'ASXqI5h+S7CfrWtL0JcRVA==', 'Male', 'Surrey');
insert into user_Info (id, userName, password, gender, city) values (20, 'Peterus', 'vRSHKvtElYHCK75l/hvnMA==', 'Male', 'Victoria');



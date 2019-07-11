create table user_Info (
	id INT AUTO_INCREMENT PRIMARY KEY,
	userName VARCHAR(50),
	password VARCHAR(9),
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
	resDate DATE,
	resTime TIME,
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
	roomNumber INT,
        serviceType VARCHAR(50),
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

insert into user_Info (id, userName, password, gender, city) values (1, 'Addie', 'Nafiza1', 'Male', 'Surrey');
insert into user_Info (id, userName, password, gender, city) values (2, 'Willy', 'Kulbir123', 'Male', 'Victoria');
insert into user_Info (id, userName, password, gender, city) values (3, 'Bev', 'Aman123', 'Male', 'Richmond');
insert into user_Info (id, userName, password, gender, city) values (4, 'Pauletta', 'Aman123', 'Female', 'Burnaby');
insert into user_Info (id, userName, password, gender, city) values (5, 'Teddi', 'Aman1', 'Female', 'Victoria');
insert into user_Info (id, userName, password, gender, city) values (6, 'Miller', 'Aman123', 'Male', 'Victoria');
insert into user_Info (id, userName, password, gender, city) values (7, 'Orton', 'Kulbir1', 'Male', 'Burnaby');
insert into user_Info (id, userName, password, gender, city) values (8, 'Ricki', 'Kulbir1', 'Female', 'Vancouver');
insert into user_Info (id, userName, password, gender, city) values (9, 'Ronnie', 'Kulbir123', 'Female', 'Vancouver');
insert into user_Info (id, userName, password, gender, city) values (10, 'Donetta', 'Aman123', 'Female', 'Surrey');
insert into user_Info (id, userName, password, gender, city) values (11, 'Graeme', 'Nafiza123', 'Male', 'Richmond');
insert into user_Info (id, userName, password, gender, city) values (12, 'Alix', 'Nafiza123', 'Male', 'Surrey');
insert into user_Info (id, userName, password, gender, city) values (13, 'Allard', 'Kulbir1', 'Male', 'Burnaby');
insert into user_Info (id, userName, password, gender, city) values (14, 'Sarah', 'Nafiza123', 'Female', 'Victoria');
insert into user_Info (id, userName, password, gender, city) values (15, 'Robinett', 'Aman123', 'Female', 'Vancouver');
insert into user_Info (id, userName, password, gender, city) values (16, 'Puff', 'Nafiza123', 'Male', 'Richmond');
insert into user_Info (id, userName, password, gender, city) values (17, 'Winfield', 'Kulbir123', 'Male', 'Burnaby');
insert into user_Info (id, userName, password, gender, city) values (18, 'Gil', 'Nafiza1', 'Male', 'Surrey');
insert into user_Info (id, userName, password, gender, city) values (19, 'Clywd', 'Kulbir123', 'Male', 'Surrey');
insert into user_Info (id, userName, password, gender, city) values (20, 'Peterus', 'Aman123', 'Male', 'Victoria');

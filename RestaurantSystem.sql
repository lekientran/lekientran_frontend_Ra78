DROP DATABASE IF EXISTS RestaurantSystem;
CREATE DATABASE RestaurantSystem;
USE RestaurantSystem;

CREATE TABLE `User` (
	Id 				INT AUTO_INCREMENT PRIMARY KEY,
    Username		VARCHAR(30) UNIQUE NOT NULL,
	FullName		NVARCHAR(30) NOT NULL, 
    Email			VARCHAR(100) UNIQUE,
    `Password`		VARCHAR(12) NOT NULL,
	Roll			ENUM ('CUSTOMER', 'ADMIN') NOT NULL,
	CreateDate		DATETIME DEFAULT(NOW())
);

CREATE TABLE FoodItems (
	Id 				INT AUTO_INCREMENT PRIMARY KEY,
    ItemName		VARCHAR(50) UNIQUE NOT NULL,
	Category		NVARCHAR(30) NOT NULL, 
    Cost			INT NOT NULL,
    Image			VARCHAR(1000),
	`Status`		ENUM ('AVAILABLE', 'SOLD_OUT'),
	CreateDate		DATETIME DEFAULT(NOW())
);

CREATE TABLE `Order` (
	Id 				INT AUTO_INCREMENT PRIMARY KEY,
    CreateDate		DATETIME DEFAULT(NOW()),
    FoodId			INT,
    CreatorId		INT,
    Quantity		INT NOT NULL,
    `Status`		ENUM('PENDING', 'DONE', 'CANCLE'),
    FOREIGN KEY (FoodId) 		REFERENCES FoodItems(Id),
    FOREIGN KEY (CreatorID) 	REFERENCES `User`(Id)
);


INSERT INTO `User` (Username, FullName, Email, `Password`, `Role`, CreateDate)
VALUES 
("tranle",		"Lê Kiên Trân", 	"tranle@gmail.com", 	"123456",	 "ADMIN",	 	  "2023-11-15"),
("nguyenthi",	"Nguyễn Thị", 		"nguyenthi@gmail.com", 	"456789",	 "CUSTOMER",	  "2023-11-15"),
("tranvan",		"Trần Văn", 		"tranvan@gmail.com", 	"789123",	 "CUSTOMER",	  "2023-11-15");

INSERT INTO FoodItems (ItemName, Category, Cost, Image, `Status`, CreateDate)
VALUES
("Bánh Mì Chả Cá",		"Bánh Mì", 	25000, "a1", 	"AVAILABLE", 	2023-11-15),
("Bánh Mì Đặc Biệt",	"Bánh Mì", 	45000, "a1", 	"AVAILABLE", 	2023-11-15),
("Bánh Mì Xíu Mại",		"Bánh Mì", 	35000, "a1", 	"AVAILABLE", 	2023-11-15),
("Cơm Chiên Hải Sản",	"Cơm", 		75000, "a2", 	"AVAILABLE", 	2023-11-15),
("Cơm Tấm Sườn",		"Cơm", 		75000, "a2", 	"AVAILABLE", 	2023-11-15),
("Cơm Niêu",			"Cơm", 		75000, "a2", 	"AVAILABLE", 	2023-11-15),
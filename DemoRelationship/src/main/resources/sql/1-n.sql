-- create database
DROP
DATABASE IF EXISTS TestingSystem;
CREATE
DATABASE TestingSystem;
USE
TestingSystem;
-- 1 User có nhiều địa chỉ


-- create table 2: User
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User`
(
    id       INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE KEY
);

-- create table 1: Address
DROP TABLE IF EXISTS `Address`;
CREATE TABLE `Address`
(
    id      INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    street  VARCHAR(50) NOT NULL,
    city    VARCHAR(50) NOT NULL,
    user_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (user_id) REFERENCES `User` (id)
);

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data User
INSERT INTO `User` (username)
    VALUE (	'tranduchieu'	),
    (	'ngovannam'		),
    (	'tranvandat'	);

-- Add data Address
INSERT INTO `Address` (street, city, user_id)
    VALUE (	'To Huu'	,		'Ha Noi'		,		1		),
    (	'Pham Hung'	,		'Ha Noi'		,		1		),
    (	'Pham Bach'	,		'Nam Dinh'		,		3		),
    (	'To Dien'	,		'Quang Ngai'	,		2		);
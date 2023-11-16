-- create database
DROP DATABASE IF EXISTS TestingSystem;
CREATE DATABASE TestingSystem;
USE TestingSystem;

-- create table 1: User
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
                        id				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                        username 		VARCHAR(50) NOT NULL UNIQUE KEY
);

-- create table 2: Address
DROP TABLE IF EXISTS `Address`;
CREATE TABLE `Address` (
                           id				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                           street 			VARCHAR(50) NOT NULL,
                           city			VARCHAR(50) NOT NULL
);

-- create table 3: UserAddress
DROP TABLE IF EXISTS `UserAddress`;
CREATE TABLE `UserAddress` (
                               user_id			INT UNSIGNED NOT NULL,
                               address_id		INT UNSIGNED NOT NULL,
                               registered_at	DATETIME DEFAULT NOW(),
    -- other field ...
                               FOREIGN KEY (user_id) REFERENCES `User`(id),
                               FOREIGN KEY (address_id) REFERENCES `Address`(id),
                               PRIMARY KEY (user_id, address_id)
);

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data User
INSERT INTO `User`		(username			)
    VALUE
    (	'tranduchieu'	),
						(	'ngovannam'		),
						(	'tranvandat'	);

-- Add data Address
INSERT INTO `Address`	(street			, 			city		)
    VALUE
    (	'To Huu'	,		'Ha Noi'		),
						(	'Pham Hung'	,		'Ha Noi'		),
						(	'Pham Bach'	,		'Nam Dinh'		),
                        (	'To Dien'	,		'Quang Ngai'	);

-- Add data UserAddress
INSERT INTO `UserAddress`	(user_id	, address_id, 		registered_at		)
    VALUE
    (	1		,	1		,	'2021-11-16 11:00:00'	),
							(	1		,	2		,	'2021-11-16 12:00:00'	),
							(	3		,	2		,	'2021-11-16 13:00:00'	),
							(	2		,	2		,	'2021-11-16 14:00:00'	);


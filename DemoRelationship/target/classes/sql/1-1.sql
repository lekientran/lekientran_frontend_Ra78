-- create database
DROP
DATABASE IF EXISTS TestingSystem;
CREATE
DATABASE TestingSystem;
USE
TestingSystem;

-- create table 1: Address
DROP TABLE IF EXISTS `Address`;
CREATE TABLE `Address`
(
    id     INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR(50) NOT NULL,
    city   VARCHAR(50) NOT NULL
);

-- create table 2: User
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User`
(
    id         INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    username   VARCHAR(50) NOT NULL UNIQUE KEY,
    address_id INT UNSIGNED NOT NULL UNIQUE KEY,
    FOREIGN KEY (address_id) REFERENCES Address (id)
);

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Address
INSERT INTO `Address` (street, city)
    VALUE ('To Huu', 'Ha Noi'),
    ('Pham Hung', 'Ha Noi'),
    ('Pham Bach', 'Nam Dinh'),
    ('To Dien', 'Quang Ngai');

-- Add data User
INSERT INTO `User` (username, address_id)
    VALUE ('tranduchieu', 1),
    ('ngovannam', 2),
    ('tranvandat', 3);



use JDBC;

drop table if exists `Account`;
create table `Account` (
                     id	        		int auto_increment primary key,
                     username			varchar(50),
                     email				varchar(50) not null,
                     password			varchar(50) not null,
                     first_name		    varchar(50),
                     last_name		    varchar(50),
                     `role`             enum('ADMIN', 'EMPLOYEE') not null
);

INSERT INTO `JDBC`.`Account` (`username`, `email`, `password`, `first_name`, `last_name`, `role`) VALUES ('Nguyễn Văn A', 'a@gmail.com', '123456', 'Nguyễn Văn', 'A', 'ADMIN');
INSERT INTO `JDBC`.`Account` (`username`, `email`, `password`, `first_name`, `last_name`, `role`) VALUES ('Nguyễn Văn B', 'b@gmail.com', '123456', 'Nguyễn Văn', 'B', 'EMPLOYEE');
INSERT INTO `JDBC`.`Account` (`username`, `email`, `password`, `first_name`, `last_name`, `role`) VALUES ('Nguyễn Văn C', 'c@gmail.com', '123456', 'Nguyễn Văn', 'C', 'EMPLOYEE');


drop table if exists `Group`;
create table `Group` (
                           id	        		int auto_increment primary key,
                           name			varchar(50)
);



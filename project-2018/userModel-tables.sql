create database usermodel;
use usermodel;

create table tbluser
(
	userId int not null primary key auto_increment,
    userName varchar(18) not null unique,
    userFname varchar(15) not null,
    userLname varchar(15) not null,
    userMailID varchar(50) unique,
    userMobileNo varchar(10) unique not null,
    userType varchar(15) not null default 'user',
    userCreationDT datetime not null default current_timestamp
);

create table tblpassword
(
	pwdId int not null primary key auto_increment,
	usrId  int not null unique,
	usrPwd varchar(20) not null,
    pwdChar varchar(300) not null
);

create table tblUserExtraInfo
(
	userExtID int not null primary key auto_increment,
    userId  int not null unique,
    userGender varchar(6),
    userAge nchar(2),
    userCity varchar(35),
    userPinCode varchar(6),
    userAddress varchar(100)
);

create table tblUserLoginInfo
(
	userLastLoginInfo int not null primary key auto_increment,
    userId  int,
    userName varchar(18),
    userMobileNo varchar(10) ,
    userMailID varchar(50),
    userLastLoginDT datetime not null default current_timestamp
)
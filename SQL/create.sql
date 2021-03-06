DROP TABLE TBL_USER;
DROP TABLE TBL_SELLER;
DROP TABLE TBL_ADMIN;
DROP TABLE TBL_ITEM;
DROP TABLE TBL_CART;
DROP TABLE TBL_ACTIVITY_BUY;
DROP TABLE TBL_ACTIVITY_ADRE;

CREATE TABLE TBL_USER 
(
	Username VARCHAR(50) PRIMARY KEY,
	Password VARCHAR(50),
	NickName VARCHAR(50),
	FirstName VARCHAR(50),
	LastName VARCHAR(50),
	Email VARCHAR(100),
	YearOfBirth VARCHAR(50),
	FullAddress VARCHAR(100),
	CardNumber VARCHAR(50),
	Ban VARCHAR(50)
);

CREATE TABLE TBL_SELLER
(
	Username VARCHAR(50) PRIMARY KEY,
	Password VARCHAR(50),
	Publisher VARCHAR(50),
	Email VARCHAR(100),
	FullAddress VARCHAR(100),
	Ban VARCHAR(50)
);

CREATE TABLE TBL_ADMIN
(
	Username VARCHAR(50) PRIMARY KEY,
	Password VARCHAR(50),
	Email VARCHAR(100)
);

CREATE TABLE TBL_ITEM
(
	Title VARCHAR(200),
	Authors VARCHAR(50),
	PublicationType VARCHAR(50),
	PublicationDate VARCHAR(50),
	Price VARCHAR(50),
	Seller VARCHAR(50),
	Publisher VARCHAR(50),
	Pause VARCHAR(50),
	PRIMARY KEY(Title, Seller)
);

CREATE TABLE TBL_CART
(
	Username VARCHAR(50),
	Title VARCHAR(200),
	Authors VARCHAR(50),
	Picture VARCHAR(50),
	AdTime TIMESTAMP,
	PRIMARY KEY(Username, Title, adTime)
);

CREATE TABLE TBL_ACTIVITY_BUY
(
	Username VARCHAR(50),
	Title VARCHAR(200),
	BuyTime TIMESTAMP,
	price VARCHAR(50),
	Seller VARCHAR(50),
	PRIMARY KEY(Username, Title, BuyTime)
);

CREATE TABLE TBL_ACTIVITY_ADRE
(
	Username VARCHAR(50),
	Title VARCHAR(200),
	AdTime TIMESTAMP,
	ReTime TIMESTAMP,
	PRIMARY KEY(Username, Title, AdTime)
);
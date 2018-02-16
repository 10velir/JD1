###  Lecture 24  ###
DROP SCHEMA shop;
CREATE DATABASE IF NOT EXISTS shop;
use shop;

CREATE TABLE PRODUCT
(
    ID INT(8) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    SUPPLIER VARCHAR(20),
    MODEL VARCHAR(15),
    PRICE DEC NOT NULL DEFAULT 0.0
);

CREATE TABLE USER
(
    USER_ID INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(20),
    LOGIN VARCHAR(20) NOT NULL,
    PASSWORD VARCHAR(25) NOT NULL,
    BIRTHDAY DATE,
    STATUS CHAR(10) DEFAULT 'ACTIVE' NOT NULL,
    ROLE CHAR(4) DEFAULT 'USER' NOT NULL
);
CREATE UNIQUE INDEX USER_LOGIN_uindex ON USER (LOGIN);

CREATE TABLE `ORDER`
(
	ID INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	USER_ID int(10) not null,
	DATE datetime not null,
	QUANTITY int(5) default '1' not null,
	STATUS char(10) default 'NEW' not null,
	constraint user_fk
		foreign key (USER_ID) references shop.USER (USER_ID)
);

CREATE INDEX user_fk ON `ORDER` (USER_ID);

CREATE TABLE shop.ITEM
(
    ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ORDER_ID INT NOT NULL,
    PRODUCT_ID INT NOT NULL,
    QUANTITY INT DEFAULT 1 NOT NULL,
    DISCOUNT INT DEFAULT 0 NOT NULL,
    CONSTRAINT Order_fk FOREIGN KEY (ORDER_ID) REFERENCES `ORDER` (ID) ON DELETE CASCADE,
    CONSTRAINT Product_fk FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT (ID)
);

INSERT INTO PRODUCT (SUPPLIER, MODEL, PRICE) VALUES
    ('Bosch', 'GBH 2-24 D', 259.0),
    ('Bosch', 'GBH 2-26 DFR', 367.0),
    ('Bosch', 'GBH 2-28 DFV', 375.80),
    ('Bosch', 'GBH 2-24 DRE', 309.0);

INSERT INTO USER (LOGIN, PASSWORD, NAME, STATUS) VALUES ('Yulij', 'Pass!', 'Yulij', 'ACTIVE');

CREATE PROCEDURE getItemPrice(IN itemId INT, OUT itemPrice DECIMAL(10))
    BEGIN
        SELECT PRICE
        INTO itemPrice
        FROM ITEM
        WHERE ITEM_ID = itemId;
    END
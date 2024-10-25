-- Domains for car rental service

CREATE DOMAIN CRS_ID BIGINT;
CREATE DOMAIN CRS_NAME VARCHAR(128);
CREATE DOMAIN CRS_PHONE VARCHAR(128);
CREATE DOMAIN CRS_ADDRESS VARCHAR(128);
CREATE DOMAIN CRS_EMAIL VARCHAR(256);
CREATE DOMAIN CRS_PASSWORD VARCHAR(1024);
CREATE DOMAIN CRS_DESCRIPTION VARCHAR(2048);
CREATE DOMAIN CRS_CURRENCY DECIMAL(19,4);

-- Table definition
/*
CREATE TABLE customer (
    customer_id CRS_ID PRIMARY KEY,
    crs_name CRS_NAME ,
	crs_lastname CRS_NAME ,
    username CRS_NAME, --Added as 
    password CRS_PASSWORD , --should be encrypted 
    email CRS_EMAIL UNIQUE,
    phonenr CRS_PHONE
);

CREATE TABLE booking_rideshare (
    bookingnr CRS_ID NOT NULL PRIMARY KEY,
    status CRS_NAME NOT NULL,
    startdato DATE,
    starttime TIMESTAMP,
	startlocation CRS_ADDRESS,
    enddate DATE,
    endtime TIMESTAMP,
	endlocation CRS_ADDRESS,
    price CRS_CURRENCY,
    customerid CRS_ID,
    FOREIGN KEY (customerid) REFERENCES customer(customer_id)
);
*/

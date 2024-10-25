CREATE DOMAIN CRS_ID BIGINT;
CREATE DOMAIN CRS_NAME VARCHAR(128);
CREATE DOMAIN CRS_PHONE VARCHAR(128);
CREATE DOMAIN CRS_ADDRESS VARCHAR(128);
CREATE DOMAIN CRS_EMAIL VARCHAR(256);
CREATE DOMAIN CRS_PASSWORD VARCHAR(1024);
CREATE DOMAIN CRS_DESCRIPTION VARCHAR(2048);
CREATE DOMAIN CRS_CURRENCY DECIMAL(19,4);

--Tables for Car Mangement ER diagram 

CREATE TABLE customer (
    customer_id CRS_ID PRIMARY KEY,
    crs_name CRS_NAME NOT NULL,
	crs_lastname CRS_NAME NOT NULL,
    username CRS_NAME, --Added as 
    password CRS_PASSWORD , --should be encrypted 
    email CRS_EMAIL UNIQUE,
    phonenr CRS_PHONE
);

CREATE TABLE booking_car (
    bookingnr CRS_ID NOT NULL PRIMARY KEY,
    status CRS_NAME NOT NULL,
    startdato DATE,
    starttime DATE,
    enddate TIME,
    endtime TIME,
    price CRS_CURRENCY,
    carid CRS_ID,
    customerid CRS_ID,
    FOREIGN KEY (customerid) REFERENCES customer(customer_id),
    FOREIGN KEY (carid) REFERENCES car(car_id)
);

CREATE TABLE car (
    car_id CRS_ID PRIMARY KEY,
    vin CRS_ID UNIQUE,
    yearproduced SMALLINT,
    manufactor CRS_NAME,
    model CRS_NAME,
    color CRS_NAME,
    altname CRS_NAME,
    seats TINYINT,
    range INT,
    localhubref CRS_ID,
    FOREIGN KEY localhubref REFERENCES localhub(id)
);

CREATE TABLE localhub (
    id CRS_ID PRIMARY KEY,
    locationname CRS_NAME,
    address CRS_ADDRESS,
    city CRS_NAME,
    country CRS_NAME,
    email CRS_EMAIL,
    phonenr CRS_PHONE,
    carcapacity INT
);




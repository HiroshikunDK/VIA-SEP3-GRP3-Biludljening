/*
CREATE DOMAIN CRS_ID BIGINT;
CREATE DOMAIN CRS_NAME VARCHAR(128);
CREATE DOMAIN CRS_PHONE VARCHAR(128);
CREATE DOMAIN CRS_ADDRESS VARCHAR(128);
CREATE DOMAIN CRS_EMAIL VARCHAR(256);
CREATE DOMAIN CRS_PASSWORD VARCHAR(1024);
CREATE DOMAIN CRS_DESCRIPTION VARCHAR(2048);
CREATE DOMAIN CRS_CURRENCY DECIMAL(19,4);
*/

CREATE TABLE user (
  userid CRS_ID PRIMARY KEY,
  userfirstname CRS_NAME,
  userlastname CRS_NAME,
  title CRS_NAME ,
  username CRS_NAME UNIQUE,
  password CRS_PASSWORD , --should be encrypted
  email CRS_EMAIL,
  phonenr CRS_PHONE,
  userpermissions INTEGER
);


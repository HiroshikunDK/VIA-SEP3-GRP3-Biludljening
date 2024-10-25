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

CREATE TABLE customer (
    customer_id CRS_ID PRIMARY KEY,
    crs_name CRS_NAME ,
	crs_lastname CRS_NAME ,
    username CRS_NAME, --Added as 
    password CRS_PASSWORD , --should be encrypted 
    email CRS_EMAIL UNIQUE,
    phonenr CRS_PHONE,
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


-- Dummydata for tables

INSERT INTO customer (customer_id, crs_name, crs_lastname, username, password, email, phonenr) VALUES
(1, 'John', 'Doe', 'john.doe', 'hashed_password_1', 'john.doe@example.com', '555-0101'),
(2, 'Jane', 'Smith', 'jane.smith', 'hashed_password_2', 'jane.smith@example.com', '555-0102'),
(3, 'Alice', 'Johnson', 'alice.j', 'hashed_password_3', 'alice.j@example.com', '555-0103'),
(4, 'Bob', 'Brown', 'bob.brown', 'hashed_password_4', 'bob.brown@example.com', '555-0104'),
(5, 'Charlie', 'Davis', 'charlie.d', 'hashed_password_5', 'charlie.d@example.com', '555-0105'),
(6, 'David', 'Miller', 'david.m', 'hashed_password_6', 'david.m@example.com', '555-0106'),
(7, 'Eva', 'Wilson', 'eva.wilson', 'hashed_password_7', 'eva.wilson@example.com', '555-0107'),
(8, 'Frank', 'Moore', 'frank.moore', 'hashed_password_8', 'frank.moore@example.com', '555-0108'),
(9, 'Grace', 'Taylor', 'grace.taylor', 'hashed_password_9', 'grace.taylor@example.com', '555-0109'),
(10, 'Hank', 'Anderson', 'hank.a', 'hashed_password_10', 'hank.a@example.com', '555-0110'),
(11, 'Ivy', 'Thomas', 'ivy.t', 'hashed_password_11', 'ivy.t@example.com', '555-0111'),
(12, 'Jack', 'Jackson', 'jack.j', 'hashed_password_12', 'jack.j@example.com', '555-0112'),
(13, 'Kathy', 'White', 'kathy.w', 'hashed_password_13', 'kathy.w@example.com', '555-0113'),
(14, 'Leo', 'Harris', 'leo.h', 'hashed_password_14', 'leo.h@example.com', '555-0114'),
(15, 'Mona', 'Martin', 'mona.m', 'hashed_password_15', 'mona.m@example.com', '555-0115'),
(16, 'Nate', 'Thompson', 'nate.t', 'hashed_password_16', 'nate.t@example.com', '555-0116'),
(17, 'Olivia', 'Garcia', 'olivia.g', 'hashed_password_17', 'olivia.g@example.com', '555-0117'),
(18, 'Paul', 'Martinez', 'paul.m', 'hashed_password_18', 'paul.m@example.com', '555-0118'),
(19, 'Quinn', 'Robinson', 'quinn.r', 'hashed_password_19', 'quinn.r@example.com', '555-0119'),
(20, 'Rachel', 'Clark', 'rachel.c', 'hashed_password_20', 'rachel.c@example.com', '555-0120'),
(21, 'Sam', 'Rodriguez', 'sam.r', 'hashed_password_21', 'sam.r@example.com', '555-0121'),
(22, 'Tina', 'Lewis', 'tina.l', 'hashed_password_22', 'tina.l@example.com', '555-0122'),
(23, 'Uma', 'Lee', 'uma.l', 'hashed_password_23', 'uma.l@example.com', '555-0123'),
(24, 'Victor', 'Walker', 'victor.w', 'hashed_password_24', 'victor.w@example.com', '555-0124'),
(25, 'Wendy', 'Hall', 'wendy.h', 'hashed_password_25', 'wendy.h@example.com', '555-0125');


INSERT INTO booking_rideshare (bookingnr, status, startdato, starttime, startlocation, enddate, endtime, endlocation, price, customerid) VALUES
(1, 'Confirmed', '2024-12-01', '08:00', '123 Main St, Copenhagen', '2024-12-01', '10:00', '456 Elm St, Aarhus', 20.00, 1),
(2, 'Pending', '2024-12-02', '09:00', '789 Airport Rd, Chicago', '2024-12-02', '11:00', '321 Oak St, Esbjerg', 25.00, 2),
(3, 'Cancelled', '2024-12-03', '10:00', 'Købmagergade 1, Odense', '2024-12-03', '12:00', '135 Maple St, Aalborg', 15.00, 3),
(4, 'Confirmed', '2024-12-04', '11:00', 'Kildeparken 1, Aalborg', '2024-12-04', '13:00', 'Torvet 1, Randers', 30.00, 4),
(5, 'Confirmed', '2024-12-05', '12:00', 'Rådhuspladsen 1, Kolding', '2024-12-05', '14:00', 'Sønderbrogade 1, Horsens', 28.00, 5),
(6, 'Pending', '2024-12-06', '13:00', 'Vejle Havn, Vejle', '2024-12-06', '15:00', 'Torvet 1, Silkeborg', 22.00, 6),
(7, 'Confirmed', '2024-12-07', '14:00', 'Næstved Havn, Næstved', '2024-12-07', '16:00', 'Fredericia Havn, Fredericia', 18.00, 7),
(8, 'Confirmed', '2024-12-08', '15:00', 'Kronborg 1, Helsingør', '2024-12-08', '17:00', 'Ballerup Havn, Ballerup', 20.00, 8),
(9, 'Cancelled', '2024-12-09', '16:00', 'Roskilde Havn, Roskilde', '2024-12-09', '18:00', '123 Main St, Copenhagen', 15.00, 9),
(10, 'Confirmed', '2024-12-10', '17:00', '456 Elm St, Aarhus', '2024-12-10', '19:00', '789 Airport Rd, Chicago', 25.00, 10),
(11, 'Pending', '2024-12-11', '08:30', '321 Oak St, Esbjerg', '2024-12-11', '10:30', 'Købmagergade 1, Odense', 19.00, 11),
(12, 'Confirmed', '2024-12-12', '09:30', 'Kildeparken 1, Aalborg', '2024-12-12', '11:30', 'Torvet 1, Randers', 27.00, 12),
(13, 'Confirmed', '2024-12-13', '10:30', 'Rådhuspladsen 1, Kolding', '2024-12-13', '12:30', 'Sønderbrogade 1, Horsens', 24.00, 13),
(14, 'Cancelled', '2024-12-14', '11:30', 'Vejle Havn, Vejle', '2024-12-14', '13:30', 'Torvet 1, Silkeborg', 16.00, 14),
(15, 'Confirmed', '2024-12-15', '12:30', 'Næstved Havn, Næstved', '2024-12-15', '14:30', 'Fredericia Havn, Fredericia', 21.00, 15),
(16, 'Confirmed', '2024-12-16', '08:00', 'Kronborg 1, Helsingør', '2024-12-16', '10:00', 'Ballerup Havn, Ballerup', 30.00, 1),
(17, 'Pending', '2024-12-17', '09:00', 'Roskilde Havn, Roskilde', '2024-12-17', '11:00', '123 Main St, Copenhagen', 26.00, 2),
(18, 'Cancelled', '2024-12-18', '10:00', '456 Elm St, Aarhus', '2024-12-18', '12:00', '789 Airport Rd, Chicago', 14.00, 3),
(19, 'Confirmed', '2024-12-19', '11:00', '321 Oak St, Esbjerg', '2024-12-19', '13:00', 'Købmagergade 1, Odense', 29.00, 4),
(20, 'Confirmed', '2024-12-20', '12:00', 'Kildeparken 1, Aalborg', '2024-12-20', '14:00', 'Torvet 1, Randers', 31.00, 5),
(21, 'Pending', '2024-12-21', '13:00', 'Rådhuspladsen 1, Kolding', '2024-12-21', '15:00', 'Sønderbrogade 1, Horsens', 23.00, 6),
(22, 'Confirmed', '2024-12-22', '14:00', 'Vejle Havn, Vejle', '2024-12-22', '16:00', 'Torvet 1, Silkeborg', 20.00, 7),
(23, 'Confirmed', '2024-12-23', '15:00', 'Næstved Havn, Næstved', '2024-12-23', '17:00', 'Fredericia Havn, Fredericia', 22.00, 8),
(24, 'Cancelled', '2024-12-24', '16:00', 'Kronborg 1, Helsingør', '2024-12-24', '18:00', 'Ballerup Havn, Ballerup', 18.00, 9),
(25, 'Confirmed', '2024-12-25', '17:00', 'Roskilde Havn, Roskilde', '2024-12-25', '19:00', '123 Main St, Copenhagen', 25.00, 10),
(26, 'Pending', '2024-12-26', '08:30', '321 Oak St, Esbjerg', '2024-12-26', '10:30', 'Købmagergade 1, Odense', 15.00, 11),
(27, 'Confirmed', '2024-12-27', '09:30', 'Kildeparken 1, Aalborg', '2024-12-27', '11:30', 'Torvet 1, Randers', 28.00, 12),
(28, 'Confirmed', '2024-12-28', '10:30', 'Rådhuspladsen 1, Kolding', '2024-12-28', '12:30', 'Sønderbrogade 1, Horsens', 20.00, 13),
(29, 'Cancelled', '2024-12-29', '11:30', 'Vejle Havn, Vejle', '2024-12-29', '13:30', 'Torvet 1, Silkeborg', 16.00, 14),
(30, 'Confirmed', '2024-12-30', '12:30', 'Næstved Havn, Næstved', '2024-12-30', '14:30', 'Fredericia Havn, Fredericia', 22.00, 15);

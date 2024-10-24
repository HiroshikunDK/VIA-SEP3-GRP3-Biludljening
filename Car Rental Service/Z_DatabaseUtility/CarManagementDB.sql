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
    phonenr CRS_PHONE,
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


-- Dummy Data for car mangement

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


INSERT INTO car (car_id, vin, yearproduced, manufactor, model, color, altname, seats, range, localhubref) VALUES
(1, '1HGCM82633A123456', 2020, 'Honda', 'Accord', 'Blue', 'Accord LX', 5, 400, 1),
(2, '1FMCU9J91CUB12345', 2019, 'Ford', 'Escape', 'Red', 'Escape SE', 5, 350, 1),
(3, '2C4RDGCG5ER123456', 2021, 'Chrysler', 'Pacifica', 'White', 'Pacifica Limited', 7, 500, 2),
(4, '1N4AL3AP3DC123456', 2022, 'Nissan', 'Altima', 'Black', 'Altima SV', 5, 450, 2),
(5, '1FTEW1EG0KFB12345', 2018, 'Ford', 'F-150', 'Silver', 'F-150 XLT', 5, 600, 3),
(6, '1G1YY26U565123456', 2023, 'Chevrolet', 'Corvette', 'Yellow', 'Corvette Stingray', 2, 300, 3),
(7, '5XYKT3A60DG123456', 2020, 'Kia', 'Sorento', 'Green', 'Sorento EX', 7, 400, 1),
(8, '1GNSKHKC3JZ123456', 2021, 'Chevrolet', 'Tahoe', 'Blue', 'Tahoe LT', 8, 450, 2),
(9, 'WBA8F7C52A1234567', 2019, 'BMW', '3 Series', 'Gray', '3 Series M Sport', 5, 390, 3),
(10, 'WAU2GBFC0E1234567', 2022, 'Audi', 'A4', 'Red', 'A4 Premium', 5, 420, 1);


INSERT INTO booking_car (bookingnr, status, startdato, starttime, enddate, endtime, price, carid, customerid) VALUES
(16, 'Confirmed', '2024-12-16', '08:00', '2024-12-16', '10:00', 50.00, 1, 16),
(17, 'Pending', '2024-12-17', '09:00', '2024-12-17', '11:00', 75.00, 2, 17),
(18, 'Cancelled', '2024-12-18', '10:00', '2024-12-18', '12:00', 60.00, 3, 18),
(19, 'Confirmed', '2024-12-19', '11:00', '2024-12-19', '13:00', 80.00, 4, 19),
(20, 'Confirmed', '2024-12-20', '12:00', '2024-12-20', '14:00', 100.00, 5, 20),
(21, 'Pending', '2024-12-21', '13:00', '2024-12-21', '15:00', 90.00, 6, 21),
(22, 'Confirmed', '2024-12-22', '14:00', '2024-12-22', '16:00', 55.00, 7, 22),
(23, 'Confirmed', '2024-12-23', '15:00', '2024-12-23', '17:00', 70.00, 8, 23),
(24, 'Cancelled', '2024-12-24', '16:00', '2024-12-24', '18:00', 45.00, 9, 24),
(25, 'Confirmed', '2024-12-25', '17:00', '2024-12-25', '19:00', 65.00, 10, 25),
(26, 'Pending', '2024-12-26', '08:30', '2024-12-26', '10:30', 85.00, 1, 16),
(27, 'Confirmed', '2024-12-27', '09:30', '2024-12-27', '11:30', 95.00, 2, 17),
(28, 'Confirmed', '2024-12-28', '10:30', '2024-12-28', '12:30', 75.00, 3, 18),
(29, 'Cancelled', '2024-12-29', '11:30', '2024-12-29', '13:30', 60.00, 4, 19),
(30, 'Confirmed', '2024-12-30', '12:30', '2024-12-30', '14:30', 80.00, 5, 20),
(31, 'Confirmed', '2024-12-01', '13:00', '2024-12-01', '15:00', 90.00, 6, 21),
(32, 'Pending', '2024-12-02', '14:00', '2024-12-02', '16:00', 70.00, 7, 22),
(33, 'Confirmed', '2024-12-03', '15:00', '2024-12-03', '17:00', 50.00, 8, 23),
(34, 'Cancelled', '2024-12-04', '16:00', '2024-12-04', '18:00', 60.00, 9, 24),
(35, 'Confirmed', '2024-12-05', '17:00', '2024-12-05', '19:00', 65.00, 10, 25),
(36, 'Pending', '2024-12-06', '08:30', '2024-12-06', '10:30', 55.00, 1, 1),
(37, 'Confirmed', '2024-12-07', '09:30', '2024-12-07', '11:30', 95.00, 2, 2),
(38, 'Cancelled', '2024-12-08', '10:30', '2024-12-08', '12:30', 45.00, 3, 3),
(39, 'Confirmed', '2024-12-09', '11:30', '2024-12-09', '13:30', 80.00, 4, 4),
(40, 'Confirmed', '2024-12-10', '12:30', '2024-12-10', '14:30', 100.00, 5, 5),
(41, 'Pending', '2024-12-11', '13:30', '2024-12-11', '15:30', 90.00, 6, 6),
(42, 'Confirmed', '2024-12-12', '14:30', '2024-12-12', '16:30', 55.00, 7, 7),
(43, 'Confirmed', '2024-12-13', '15:30', '2024-12-13', '17:30', 70.00, 8, 8),
(44, 'Cancelled', '2024-12-14', '16:30', '2024-12-14', '18:30', 45.00, 9, 9),
(45, 'Confirmed', '2024-12-15', '17:30', '2024-12-15', '19:30', 65.00, 10, 10),
(46, 'Pending', '2024-12-16', '08:00', '2024-12-16', '10:00', 50.00, 1, 11),
(47, 'Confirmed', '2024-12-17', '09:00', '2024-12-17', '11:00', 75.00, 2, 12),
(48, 'Cancelled', '2024-12-18', '10:00', '2024-12-18', '12:00', 60.00, 3, 13),
(49, 'Confirmed', '2024-12-19', '11:00', '2024-12-19', '13:00', 80.00, 4, 14),
(50, 'Confirmed', '2024-12-20', '12:00', '2024-12-20', '14:00', 100.00, 5, 15);


INSERT INTO localhub (id, locationname, address, city, country, email, phonenr, carcapacity) VALUES
(1, 'Copenhagen Hub', 'Rådhuspladsen 1', 'Copenhagen', 'Denmark', 'copenhagen@example.com', '555-0001', 100),
(2, 'Aarhus Hub', 'Aarhus Havn', 'Aarhus', 'Denmark', 'aarhus@example.com', '555-0002', 60),
(3, 'Odense Hub', 'Købmagergade 1', 'Odense', 'Denmark', 'odense@example.com', '555-0003', 50),
(4, 'Aalborg Hub', 'Kildeparken 1', 'Aalborg', 'Denmark', 'aalborg@example.com', '555-0004', 40),
(5, 'Esbjerg Hub', 'Torvet 1', 'Esbjerg', 'Denmark', 'esbjerg@example.com', '555-0005', 30),
(6, 'Randers Hub', 'Torv 1', 'Randers', 'Denmark', 'randers@example.com', '555-0006', 20),
(7, 'Kolding Hub', 'Rådhuspladsen 1', 'Kolding', 'Denmark', 'kolding@example.com', '555-0007', 35),
(8, 'Horsens Hub', 'Sønderbrogade 1', 'Horsens', 'Denmark', 'horsens@example.com', '555-0008', 25),
(9, 'Vejle Hub', 'Vejle Havn', 'Vejle', 'Denmark', 'vejle@example.com', '555-0009', 30),
(10, 'Silkeborg Hub', 'Torvet 1', 'Silkeborg', 'Denmark', 'silkeborg@example.com', '555-0010', 15),
(11, 'Næstved Hub', 'Næstved Havn', 'Næstved', 'Denmark', 'naestved@example.com', '555-0011', 20),
(12, 'Fredericia Hub', 'Fredericia Havn', 'Fredericia', 'Denmark', 'fredericia@example.com', '555-0012', 25),
(13, 'Helsingør Hub', 'Kronborg 1', 'Helsingør', 'Denmark', 'helsingor@example.com', '555-0013', 20),
(14, 'Ballerup Hub', 'Ballerup Havn', 'Ballerup', 'Denmark', 'ballerup@example.com', '555-0014', 15),
(15, 'Roskilde Hub', 'Roskilde Havn', 'Roskilde', 'Denmark', 'roskilde@example.com', '555-0015', 30);



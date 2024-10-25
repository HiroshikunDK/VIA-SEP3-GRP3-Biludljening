CREATE DOMAIN CRS_ID BIGINT;
CREATE DOMAIN CRS_NAME VARCHAR(128);
CREATE DOMAIN CRS_PHONE VARCHAR(128);
CREATE DOMAIN CRS_ADDRESS VARCHAR(128);
CREATE DOMAIN CRS_EMAIL VARCHAR(256);
CREATE DOMAIN CRS_PASSWORD VARCHAR(1024);
CREATE DOMAIN CRS_DESCRIPTION VARCHAR(2048);
CREATE DOMAIN CRS_CURRENCY DECIMAL(19,4);

CREATE TABLE creditcard (

    creditcard_id CRS_ID PRIMARY KEY,
    creditcardnr CRS_PASSWORD, --encrypted like 
	cc_name CRS_NAME,
	cc_lastname CRS_NAME,
    customerid CRS_ID, --Added as a part of unitofwork 
);

CREATE TABLE payment (
    id CRS_ID PRIMARY KEY,
    customer CRS_ID,
    bookingType SMALLINT, --is it car or greenshare
    booking CRS_ID,
    status TEXT, --is it payed or not
    creditcardref CRS_PASSWORD,
    FOREIGN KEY creditcardref REFERENCES creditcard(creditcard_id)
);


INSERT INTO creditcard (creditcard_id, creditcardnr, cc_name, cc_lastname, customerid) VALUES
(1, 'ENC_1234567890123456', 'John', 'Doe', 1),
(2, 'ENC_2345678901234567', 'Jane', 'Smith', 2),
(3, 'ENC_3456789012345678', 'Emily', 'Johnson', 3),
(4, 'ENC_4567890123456789', 'Michael', 'Brown', 4),
(5, 'ENC_5678901234567890', 'Chris', 'Davis', 5),
(6, 'ENC_6789012345678901', 'Jessica', 'Garcia', 6),
(7, 'ENC_7890123456789012', 'Daniel', 'Martinez', 7),
(8, 'ENC_8901234567890123', 'Sarah', 'Hernandez', 8),
(9, 'ENC_9012345678901234', 'David', 'Lopez', 9),
(10, 'ENC_0123456789012345', 'Laura', 'Wilson', 10),
(11, 'ENC_1234567890123457', 'Matthew', 'Moore', 11),
(12, 'ENC_2345678901234568', 'Ashley', 'Taylor', 12),
(13, 'ENC_3456789012345679', 'Joshua', 'Anderson', 13),
(14, 'ENC_4567890123456790', 'Alyssa', 'Thomas', 14),
(15, 'ENC_5678901234567901', 'James', 'Jackson', 15),
(16, 'ENC_6789012345678912', 'Sophia', 'White', 16),
(17, 'ENC_7890123456789023', 'Alexander', 'Harris', 17),
(18, 'ENC_8901234567890134', 'Mia', 'Martin', 18),
(19, 'ENC_9012345678901245', 'Ethan', 'Thompson', 19),
(20, 'ENC_0123456789012356', 'Isabella', 'Garrett', 20),
(21, 'ENC_1234567890123467', 'Oliver', 'Nelson', 21),
(22, 'ENC_2345678901234578', 'Sofia', 'Carter', 22),
(23, 'ENC_3456789012345689', 'Benjamin', 'Mitchell', 23),
(24, 'ENC_4567890123456700', 'Charlotte', 'Perez', 24),
(25, 'ENC_5678901234567811', 'Lucas', 'Roberts', 25);

INSERT INTO payment (customer, bookingType, booking, status, creditcardref) VALUES
(1, 1, 5, 'paid', 1),
(2, 2, 12, 'not paid', 2),
(3, 1, 22, 'paid', 3),
(4, 2, 30, 'paid', 4),
(5, 1, 45, 'not paid', 5),
(6, 2, 8, 'paid', 6),
(7, 1, 16, 'paid', 7),
(8, 2, 29, 'not paid', 8),
(9, 1, 33, 'paid', 9),
(10, 2, 50, 'paid', 10),
(11, 1, 3, 'not paid', 11),
(12, 2, 19, 'paid', 12),
(13, 1, 27, 'paid', 13),
(14, 2, 35, 'not paid', 14),
(15, 1, 6, 'paid', 15),
(16, 2, 43, 'paid', 16),
(17, 1, 1, 'not paid', 17),
(18, 2, 14, 'paid', 18),
(19, 1, 20, 'paid', 19),
(20, 2, 38, 'not paid', 20),
(21, 1, 11, 'paid', 21),
(22, 2, 24, 'paid', 22),
(23, 1, 39, 'not paid', 23),
(24, 2, 7, 'paid', 24),
(25, 1, 15, 'paid', 25),
(1, 2, 28, 'not paid', 1),
(2, 1, 2, 'paid', 2),
(3, 2, 41, 'paid', 3),
(4, 1, 4, 'not paid', 4),
(5, 2, 36, 'paid', 5),
(6, 1, 9, 'paid', 6),
(7, 2, 25, 'not paid', 7),
(8, 1, 46, 'paid', 8),
(9, 2, 17, 'paid', 9),
(10, 1, 32, 'not paid', 10),
(11, 2, 48, 'paid', 11),
(12, 1, 10, 'paid', 12),
(13, 2, 40, 'not paid', 13),
(14, 1, 26, 'paid', 14),
(15, 2, 3, 'paid', 15),
(16, 1, 44, 'not paid', 16),
(17, 2, 13, 'paid', 17),
(18, 1, 21, 'paid', 18),
(19, 2, 34, 'not paid', 19),
(20, 1, 47, 'paid', 20),
(21, 2, 23, 'paid', 21),
(22, 1, 18, 'not paid', 22),
(23, 2, 49, 'paid', 23),
(24, 1, 42, 'paid', 24),
(25, 2, 37, 'not paid', 25);

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

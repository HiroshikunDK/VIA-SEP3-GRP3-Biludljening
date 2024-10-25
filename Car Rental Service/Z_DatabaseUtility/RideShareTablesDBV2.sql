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

CREATE TABLE available_rideshare (
    bookingid CRS_ID PRIMARY KEY,
    availablespaces SMALLINT,
    status CRS_NAME, -- full, partiallybokked, or cancelled
    startdato DATE,
    starttime DATE,
	startlocation CRS_ADDRESS,
    enddate TIME,
    endtime TIME,
	endlocation CRS_ADDRESS,
    price CRS_CURRENCY, --published price
    bookingref CRS_ID -- from car booking table
 );

CREATE TABLE booking_rideshare (
    bookingid CRS_ID PRIMARY KEY,
    status CRS_NAME,
    startdato DATE,
	startlocation CRS_ADDRESS,
    enddate DATE,
	endlocation CRS_ADDRESS,
    price CRS_CURRENCY, --customer price
    customerid CRS_ID,
    bookingref CRS_ID,
    FOREIGN KEY bookingref REFERENCES available_rideshare(bookingid)
);




-- Dummydata for tables

INSERT INTO available_rideshare (bookingid, availablespaces, status, startdato, starttime, startlocation, enddate, endtime, endlocation, price, bookingref) VALUES
(1, 3, 'Full', '2024-12-01', '08:00', '123 Main St, Copenhagen', '2024-12-01', '10:00', '456 Elm St, Aarhus', 20.00, 1),
(2, 2, 'Partially Booked', '2024-12-02', '09:00', '789 Airport Rd, Chicago', '2024-12-02', '11:00', '321 Oak St, Esbjerg', 25.00, 2),
(3, 5, 'Cancelled', '2024-12-03', '10:00', 'Købmagergade 1, Odense', '2024-12-03', '12:00', '135 Maple St, Aalborg', 15.00, 3),
(4, 4, 'Full', '2024-12-04', '11:00', 'Kildeparken 1, Aalborg', '2024-12-04', '13:00', 'Torvet 1, Randers', 30.00, 4),
(5, 5, 'Full', '2024-12-05', '12:00', 'Rådhuspladsen 1, Kolding', '2024-12-05', '14:00', 'Sønderbrogade 1, Horsens', 28.00, 5),
(6, 2, 'Partially Booked', '2024-12-06', '13:00', 'Vejle Havn, Vejle', '2024-12-06', '15:00', 'Torvet 1, Silkeborg', 22.00, 6),
(7, 0, 'Full', '2024-12-07', '14:00', 'Næstved Havn, Næstved', '2024-12-07', '16:00', 'Fredericia Havn, Fredericia', 18.00, 7),
(8, 1, 'Full', '2024-12-08', '15:00', 'Kronborg 1, Helsingør', '2024-12-08', '17:00', 'Ballerup Havn, Ballerup', 20.00, 8),
(9, 3, 'Cancelled', '2024-12-09', '16:00', 'Roskilde Havn, Roskilde', '2024-12-09', '18:00', '123 Main St, Copenhagen', 15.00, 9),
(10, 3, 'Full', '2024-12-10', '17:00', '456 Elm St, Aarhus', '2024-12-10', '19:00', '789 Airport Rd, Chicago', 25.00, 10),
(11, 1, 'Partially Booked', '2024-12-11', '08:30', '321 Oak St, Esbjerg', '2024-12-11', '10:30', 'Købmagergade 1, Odense', 19.00, 11),
(12, 4, 'Full', '2024-12-12', '09:30', 'Kildeparken 1, Aalborg', '2024-12-12', '11:30', 'Torvet 1, Randers', 27.00, 12),
(13, 3, 'Full', '2024-12-13', '10:30', 'Rådhuspladsen 1, Kolding', '2024-12-13', '12:30', 'Sønderbrogade 1, Horsens', 24.00, 13),
(14, 2, 'Cancelled', '2024-12-14', '11:30', 'Vejle Havn, Vejle', '2024-12-14', '13:30', 'Torvet 1, Silkeborg', 16.00, 14),
(15, 2, 'Full', '2024-12-15', '12:30', 'Næstved Havn, Næstved', '2024-12-15', '14:30', 'Fredericia Havn, Fredericia', 21.00, 15),
(16, 4, 'Full', '2024-12-16', '08:00', 'Kronborg 1, Helsingør', '2024-12-16', '10:00', 'Ballerup Havn, Ballerup', 30.00, 1),
(17, 1, 'Partially Booked', '2024-12-17', '09:00', 'Roskilde Havn, Roskilde', '2024-12-17', '11:00', '123 Main St, Copenhagen', 26.00, 2),
(18, 2, 'Cancelled', '2024-12-18', '10:00', '456 Elm St, Aarhus', '2024-12-18', '12:00', '789 Airport Rd, Chicago', 14.00, 3),
(19, 5, 'Full', '2024-12-19', '11:00', '321 Oak St, Esbjerg', '2024-12-19', '13:00', 'Købmagergade 1, Odense', 29.00, 4),
(20, 3, 'Full', '2024-12-20', '12:00', 'Kildeparken 1, Aalborg', '2024-12-20', '14:00', 'Torvet 1, Randers', 31.00, 5);




INSERT INTO booking_rideshare (bookingid, status, startdato, startlocation, enddate, endlocation, price, customerid, bookingref) VALUES
(1, 'Confirmed', '2024-12-01', '123 Main St, Copenhagen', '2024-12-01', '456 Elm St, Aarhus', 20.00, 1, 1),
(2, 'Confirmed', '2024-12-01', '123 Main St, Copenhagen', '2024-12-01', '456 Elm St, Aarhus', 20.00, 2, 1),
(3, 'Confirmed', '2024-12-01', '123 Main St, Copenhagen', '2024-12-01', '456 Elm St, Aarhus', 20.00, 3, 1),
(4, 'Confirmed', '2024-12-02', '789 Airport Rd, Chicago', '2024-12-02', '321 Oak St, Esbjerg', 25.00, 4, 2),
(5, 'Confirmed', '2024-12-02', '789 Airport Rd, Chicago', '2024-12-02', '321 Oak St, Esbjerg', 25.00, 5, 2),
(6, 'Confirmed', '2024-12-02', '789 Airport Rd, Chicago', '2024-12-02', '321 Oak St, Esbjerg', 25.00, 6, 2),
(7, 'Cancelled', '2024-12-03', 'Købmagergade 1, Odense', '2024-12-03', '135 Maple St, Aalborg', 15.00, 7, 3),
(8, 'Confirmed', '2024-12-04', 'Kildeparken 1, Aalborg', '2024-12-04', 'Torvet 1, Randers', 30.00, 8, 4),
(9, 'Confirmed', '2024-12-04', 'Kildeparken 1, Aalborg', '2024-12-04', 'Torvet 1, Randers', 30.00, 9, 4),
(10, 'Confirmed', '2024-12-04', 'Kildeparken 1, Aalborg', '2024-12-04', 'Torvet 1, Randers', 30.00, 10, 4),
(11, 'Confirmed', '2024-12-05', 'Rådhuspladsen 1, Kolding', '2024-12-05', 'Sønderbrogade 1, Horsens', 28.00, 11, 5),
(12, 'Confirmed', '2024-12-05', 'Rådhuspladsen 1, Kolding', '2024-12-05', 'Sønderbrogade 1, Horsens', 28.00, 12, 5),
(13, 'Confirmed', '2024-12-05', 'Rådhuspladsen 1, Kolding', '2024-12-05', 'Sønderbrogade 1, Horsens', 28.00, 13, 5),
(14, 'Partially Booked', '2024-12-06', 'Vejle Havn, Vejle', '2024-12-06', 'Torvet 1, Silkeborg', 22.00, 14, 6),
(15, 'Partially Booked', '2024-12-06', 'Vejle Havn, Vejle', '2024-12-06', 'Torvet 1, Silkeborg', 22.00, 15, 6),
(16, 'Confirmed', '2024-12-07', 'Næstved Havn, Næstved', '2024-12-07', 'Fredericia Havn, Fredericia', 18.00, 16, 7),
(17, 'Confirmed', '2024-12-08', 'Kronborg 1, Helsingør', '2024-12-08', 'Ballerup Havn, Ballerup', 20.00, 17, 8),
(18, 'Confirmed', '2024-12-08', 'Kronborg 1, Helsingør', '2024-12-08', 'Ballerup Havn, Ballerup', 20.00, 18, 8),
(19, 'Cancelled', '2024-12-09', 'Roskilde Havn, Roskilde', '2024-12-09', '123 Main St, Copenhagen', 15.00, 19, 9),
(20, 'Confirmed', '2024-12-10', '456 Elm St, Aarhus', '2024-12-10', '789 Airport Rd, Chicago', 25.00, 20, 10),
(21, 'Confirmed', '2024-12-10', '456 Elm St, Aarhus', '2024-12-10', '789 Airport Rd, Chicago', 25.00, 21, 10),
(22, 'Partially Booked', '2024-12-11', '321 Oak St, Esbjerg', '2024-12-11', 'Købmagergade 1, Odense', 19.00, 22, 11),
(23, 'Confirmed', '2024-12-12', 'Kildeparken 1, Aalborg', '2024-12-12', 'Torvet 1, Randers', 27.00, 23, 12),
(24, 'Confirmed', '2024-12-12', 'Kildeparken 1, Aalborg', '2024-12-12', 'Torvet 1, Randers', 27.00, 24, 12),
(25, 'Confirmed', '2024-12-13', 'Rådhuspladsen 1, Kolding', '2024-12-13', 'Sønderbrogade 1, Horsens', 24.00, 25, 13),
(26, 'Confirmed', '2024-12-13', 'Rådhuspladsen 1, Kolding', '2024-12-13', 'Sønderbrogade 1, Horsens', 24.00, 26, 13),
(27, 'Cancelled', '2024-12-14', 'Vejle Havn, Vejle', '2024-12-14', 'Torvet 1, Silkeborg', 16.00, 27, 14),
(28, 'Confirmed', '2024-12-15', 'Næstved Havn, Næstved', '2024-12-15', 'Fredericia Havn, Fredericia', 21.00, 28, 15),
(29, 'Confirmed', '2024-12-15', 'Næstved Havn, Næstved', '2024-12-15', 'Fredericia Havn, Fredericia', 21.00, 29, 15),
(30, 'Confirmed', '2024-12-16', 'Kronborg 1, Helsingør', '2024-12-16', 'Ballerup Havn, Ballerup', 30.00, 30, 1),
(31, 'Confirmed', '2024-12-16', 'Kronborg 1, Helsingør', '2024-12-16', 'Ballerup Havn, Ballerup', 30.00, 31, 1),
(32, 'Partially Booked', '2024-12-17', 'Roskilde Havn, Roskilde', '2024-12-17', '123 Main St, Copenhagen', 26.00, 32, 2),
(33, 'Cancelled', '2024-12-18', '456 Elm St, Aarhus', '2024-12-18', '789 Airport Rd, Chicago', 14.00, 33, 3),
(34, 'Confirmed', '2024-12-19', '321 Oak St, Esbjerg', '2024-12-19', 'Købmagergade 1, Odense', 29.00, 34, 4),
(35, 'Confirmed', '2024-12-20', 'Kildeparken 1, Aalborg', '2024-12-20', 'Torvet 1, Randers', 31.00, 35, 5),
(36, 'Confirmed', '2024-12-21', 'Rådhuspladsen 1, Kolding', '2024-12-21', 'Sønderbrogade 1, Horsens', 23.00, 36, 6),
(37, 'Confirmed', '2024-12-22', 'Vejle Havn, Vejle', '2024-12-22', 'Torvet 1, Silkeborg', 20.00, 37, 7),
(38, 'Confirmed', '2024-12-23', 'Næstved Havn, Næstved', '2024-12-23', 'Fredericia Havn, Fredericia', 22.00, 38, 8),
(39, 'Cancelled', '2024-12-24', 'Kronborg 1, Helsingør', '2024-12-24', 'Ballerup Havn, Ballerup', 18.00, 39, 9),
(40, 'Confirmed', '2024-12-25', 'Roskilde Havn, Roskilde', '2024-12-25', '123 Main St, Copenhagen', 25.00, 40, 10),
(41, 'Partially Booked', '2024-12-26', '321 Oak St, Esbjerg', '2024-12-26', 'Købmagergade 1, Odense', 15.00, 41, 11),
(42, 'Confirmed', '2024-12-27', 'Kildeparken 1, Aalborg', '2024-12-27', 'Torvet 1, Randers', 28.00, 42, 12),
(43, 'Confirmed', '2024-12-28', 'Rådhuspladsen 1, Kolding', '2024-12-28', 'Sønderbrogade 1, Horsens', 20.00, 43, 13),
(44, 'Cancelled', '2024-12-29', 'Vejle Havn, Vejle', '2024-12-29', 'Torvet 1, Silkeborg', 16.00, 44, 14),
(45, 'Confirmed', '2024-12-30', 'Næstved Havn, Næstved', '2024-12-30', 'Fredericia Havn, Fredericia', 22.00, 45, 15);


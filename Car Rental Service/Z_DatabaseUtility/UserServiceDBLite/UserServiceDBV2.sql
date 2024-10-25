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
/*
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
*/
CREATE TABLE customer (
  customer_id CRS_ID PRIMARY KEY,
  crs_name CRS_NAME NOT NULL,
 	crs_lastname CRS_NAME NOT NULL,
  username CRS_NAME, --Added as 
  password CRS_PASSWORD , --should be encrypted 
  email CRS_EMAIL UNIQUE,
  phonenr CRS_PHONE
);

INSERT INTO user (userid, userfirstname, userlastname, title, username, password, email, phonenr, userpermissions) VALUES
(1, 'Alice', 'Smith', 'Admin', 'alicesmith', 'hashed_password1', 'alice.smith@example.com', '1112223333', 1),
(2, 'Bob', 'Johnson', 'Editor', 'bobjohnson', 'hashed_password2', 'bob.johnson@example.com', '1112223334', 2),
(3, 'Charlie', 'Williams', 'Viewer', 'charliewilliams', 'hashed_password3', 'charlie.williams@example.com', '1112223335', 3),
(4, 'David', 'Brown', 'Admin', 'davidbrown', 'hashed_password4', 'david.brown@example.com', '1112223336', 1),
(5, 'Emma', 'Jones', 'Editor', 'emmajones', 'hashed_password5', 'emma.jones@example.com', '1112223337', 2),
(6, 'Frank', 'Garcia', 'Viewer', 'frankgarcia', 'hashed_password6', 'frank.garcia@example.com', '1112223338', 3),
(7, 'Grace', 'Martinez', 'Admin', 'gracemartinez', 'hashed_password7', 'grace.martinez@example.com', '1112223339', 1),
(8, 'Henry', 'Davis', 'Editor', 'henrydavis', 'hashed_password8', 'henry.davis@example.com', '1112223340', 2),
(9, 'Ivy', 'Rodriguez', 'Viewer', 'ivyrodriguez', 'hashed_password9', 'ivy.rodriguez@example.com', '1112223341', 3),
(10, 'Jack', 'Martinez', 'Admin', 'jackmartinez', 'hashed_password10', 'jack.martinez@example.com', '1112223342', 1),
(11, 'Kathy', 'Hernandez', 'Editor', 'kathyhernandez', 'hashed_password11', 'kathy.hernandez@example.com', '1112223343', 2),
(12, 'Liam', 'Lopez', 'Viewer', 'liamlopez', 'hashed_password12', 'liam.lopez@example.com', '1112223344', 3),
(13, 'Mia', 'Gonzalez', 'Admin', 'miagonzalez', 'hashed_password13', 'mia.gonzalez@example.com', '1112223345', 1),
(14, 'Noah', 'Wilson', 'Editor', 'noahwilson', 'hashed_password14', 'noah.wilson@example.com', '1112223346', 2),
(15, 'Olivia', 'Anderson', 'Viewer', 'oliviaanderson', 'hashed_password15', 'olivia.anderson@example.com', '1112223347', 3),
(16, 'Paul', 'Thomas', 'Admin', 'paulthomas', 'hashed_password16', 'paul.thomas@example.com', '1112223348', 1),
(17, 'Quinn', 'Taylor', 'Editor', 'quinntaylor', 'hashed_password17', 'quinn.taylor@example.com', '1112223349', 2),
(18, 'Rachel', 'Moore', 'Viewer', 'rachelmoore', 'hashed_password18', 'rachel.moore@example.com', '1112223350', 3),
(19, 'Sam', 'Jackson', 'Admin', 'samjackson', 'hashed_password19', 'sam.jackson@example.com', '1112223351', 1),
(20, 'Tina', 'Lee', 'Editor', 'tinalee', 'hashed_password20', 'tina.lee@example.com', '1112223352', 2),
(21, 'Victor', 'Harris', 'Viewer', 'victorharris', 'hashed_password21', 'victor.harris@example.com', '1112223353', 3),
(22, 'Wendy', 'Clark', 'Admin', 'wendyclark', 'hashed_password22', 'wendy.clark@example.com', '1112223354', 1),
(23, 'Xander', 'Lewis', 'Editor', 'xanderlewis', 'hashed_password23', 'xander.lewis@example.com', '1112223355', 2),
(24, 'Yara', 'Walker', 'Viewer', 'yarawalker', 'hashed_password24', 'yara.walker@example.com', '1112223356', 3),
(25, 'Zach', 'Hall', 'Admin', 'zachhall', 'hashed_password25', 'zach.hall@example.com', '1112223357', 1);


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
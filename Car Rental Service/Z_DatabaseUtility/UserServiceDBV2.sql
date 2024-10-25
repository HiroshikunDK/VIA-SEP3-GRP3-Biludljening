CREATE DOMAIN CRS_ID BIGINT;
CREATE DOMAIN CRS_NAME VARCHAR(128);
CREATE DOMAIN CRS_PHONE VARCHAR(128);
CREATE DOMAIN CRS_ADDRESS VARCHAR(128);
CREATE DOMAIN CRS_EMAIL VARCHAR(256);
CREATE DOMAIN CRS_PASSWORD VARCHAR(1024);
CREATE DOMAIN CRS_DESCRIPTION VARCHAR(2048);
CREATE DOMAIN CRS_CURRENCY DECIMAL(19,4);

CREATE TABLE user (
  userid CRS_ID PRIMARY KEY,
  username CRS_NAME,
  userlastname CRS_NAME,
  title CRS_NAME ,
  username CRS_NAME UNIQUE,
  password CRS_PASSWORD , --should be encrypted
  email CRS_EMAIL,
  phonenr CRS_PHONE,
  userpermissions INTEGER
);

CREATE TABLE customer (
  customer_id CRS_ID PRIMARY KEY,
  crs_name CRS_NAME NOT NULL,
 	crs_lastname CRS_NAME NOT NULL,
  username CRS_NAME, --Added as 
  password CRS_PASSWORD , --should be encrypted 
  email CRS_EMAIL UNIQUE,
  phonenr CRS_PHONE,
  FOREIGN KEY localhubref REFERENCES localhub(id)
);

INSERT INTO user (userid, username, userlastname, title, password, email, phonenr, userpermissions) VALUES
(1, 'johndoe', 'Doe', 'Mr.', 'ENC_Password1', 'johndoe@example.com', '555-0101', 1),
(2, 'janesmith', 'Smith', 'Ms.', 'ENC_Password2', 'janesmith@example.com', '555-0102', 2),
(3, 'emilyjohnson', 'Johnson', 'Mrs.', 'ENC_Password3', 'emilyj@example.com', '555-0103', 1),
(4, 'michaelbrown', 'Brown', 'Mr.', 'ENC_Password4', 'michaelb@example.com', '555-0104', 3),
(5, 'chrisdavis', 'Davis', 'Mr.', 'ENC_Password5', 'chrisd@example.com', '555-0105', 2),
(6, 'jessicagarcia', 'Garcia', 'Ms.', 'ENC_Password6', 'jessicag@example.com', '555-0106', 1),
(7, 'danielmartinez', 'Martinez', 'Mr.', 'ENC_Password7', 'danielm@example.com', '555-0107', 3),
(8, 'sarahhernandez', 'Hernandez', 'Ms.', 'ENC_Password8', 'sarahh@example.com', '555-0108', 2),
(9, 'davidlopez', 'Lopez', 'Mr.', 'ENC_Password9', 'davidl@example.com', '555-0109', 1),
(10, 'laurawilson', 'Wilson', 'Ms.', 'ENC_Password10', 'lauraw@example.com', '555-0110', 2),
(11, 'matthewmoore', 'Moore', 'Mr.', 'ENC_Password11', 'matthewm@example.com', '555-0111', 1),
(12, 'ashleytaylor', 'Taylor', 'Ms.', 'ENC_Password12', 'ashleyt@example.com', '555-0112', 3),
(13, 'joshuanderson', 'Anderson', 'Mr.', 'ENC_Password13', 'joshuaa@example.com', '555-0113', 2),
(14, 'alyssathomas', 'Thomas', 'Ms.', 'ENC_Password14', 'alyssat@example.com', '555-0114', 1),
(15, 'jamesjackson', 'Jackson', 'Mr.', 'ENC_Password15', 'jamesj@example.com', '555-0115', 3),
(16, 'sophiawhite', 'White', 'Ms.', 'ENC_Password16', 'sophiaw@example.com', '555-0116', 2),
(17, 'alexanderharris', 'Harris', 'Mr.', 'ENC_Password17', 'alexh@example.com', '555-0117', 1),
(18, 'miamartin', 'Martin', 'Ms.', 'ENC_Password18', 'miam@example.com', '555-0118', 3),
(19, 'ethanthompson', 'Thompson', 'Mr.', 'ENC_Password19', 'ethant@example.com', '555-0119', 2),
(20, 'isabellagarrett', 'Garrett', 'Ms.', 'ENC_Password20', 'isabellag@example.com', '555-0120', 1),
(21, 'olivernelson', 'Nelson', 'Mr.', 'ENC_Password21', 'olivern@example.com', '555-0121', 3),
(22, 'sofiacarter', 'Carter', 'Ms.', 'ENC_Password22', 'sofiac@example.com', '555-0122', 2),
(23, 'benjaminmitchell', 'Mitchell', 'Mr.', 'ENC_Password23', 'benjaminm@example.com', '555-0123', 1),
(24, 'charlotteperez', 'Perez', 'Ms.', 'ENC_Password24', 'charlottep@example.com', '555-0124', 3),
(25, 'lucasroberts', 'Roberts', 'Mr.', 'ENC_Password25', 'lucasr@example.com', '555-0125', 2);

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
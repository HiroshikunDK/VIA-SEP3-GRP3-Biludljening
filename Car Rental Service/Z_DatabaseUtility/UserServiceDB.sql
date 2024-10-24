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

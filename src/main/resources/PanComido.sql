<<<<<<< HEAD
CREATE TABLE CreditCard (
 card_number VARCHAR(20) NOT NULL,
 securityCode NUMERIC(3) NOT NULL,
 expiration_date VARCHAR(4) NOT NULL,
 user_name VARCHAR(150) NOT NULL,
 TYPE VARCHAR(20) NOT NULL
);

ALTER TABLE CreditCard ADD CONSTRAINT PK_CreditCard PRIMARY KEY (card_number);


CREATE TABLE Users (
 user_id  INT AUTO_INCREMENT PRIMARY KEY,
 email VARCHAR(30) NOT NULL,
 user_password VARCHAR(20) NOT NULL,
 firstname  VARCHAR(40) NOT NULL,
 lastname  VARCHAR(40) NOT NULL,
 cellphone VARCHAR(10),
 city VARCHAR(30),
 image VARCHAR(300)
);

CREATE TABLE Friend (
 id_friend INT AUTO_INCREMENT PRIMARY KEY,
 user_id  INT NOT NULL,
 friend_id INT NOT NULL,
 state INT NOT NULL
);

CREATE TABLE PaymentMethod (
 id_payment_method INT AUTO_INCREMENT PRIMARY KEY,
 user_id  INT NOT NULL,
 card_number VARCHAR(20) NOT NULL
);

CREATE TABLE Rest_Order (
 id_order INT AUTO_INCREMENT PRIMARY KEY,
 creation_date DATE NOT NULL,
 user_id  INT
);

CREATE TABLE Restaurant (
 id_restaurant INT AUTO_INCREMENT PRIMARY KEY,
 NAME VARCHAR(100) NOT NULL,
 longitude DECIMAL(10, 10) NOT NULL,
 latitude DECIMAL(10, 10) NOT NULL,
 likes NUMERIC,
 dislike NUMERIC,
 love NUMERIC,
 angry NUMERIC,
 user_id INT
);

CREATE TABLE Command (
 id_command INT AUTO_INCREMENT PRIMARY KEY,
 state INT NOT NULL,
 id_order INT,
 creation_date DATE NOT NULL
);

CREATE TABLE Comments (
 id_comment INT AUTO_INCREMENT PRIMARY KEY,
 id_restaurant INT NOT NULL,
 comment_des VARCHAR(100) NOT NULL,
 comment_date DATE NOT NULL
);

CREATE TABLE Dish (
 id_dish INT AUTO_INCREMENT PRIMARY KEY,
 NAME VARCHAR(100) NOT NULL,
 price INT NOT NULL,
 description VARCHAR(100) NOT NULL,
 prep_time NUMERIC NOT NULL,
 image VARCHAR(300),
 id_restaurant INT NOT NULL
);

CREATE TABLE Payment (
 id_payment INT AUTO_INCREMENT PRIMARY KEY,
 payment_date DATE NOT NULL,
 transaction_state INT,
 id_command INT NOT NULL,
 user_id  INT
);

CREATE TABLE Command_Dish (
 id_command_dish INT AUTO_INCREMENT PRIMARY KEY,
 id_command INT NOT NULL,
 id_dish INT NOT NULL
);
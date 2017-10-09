CREATE TABLE CreditCard (
 card_number VARCHAR(20) NOT NULL,
 securityCode NUMERIC(3) NOT NULL,
 expiration_date VARCHAR(4) NOT NULL,
 user_name VARCHAR(150) NOT NULL,
 type VARCHAR(20) NOT NULL
);



CREATE TABLE Users (
 user_id  NUMERIC(15) NOT NULL,
 email VARCHAR(30) NOT NULL,
 password VARCHAR(20) NOT NULL,
 firstname  VARCHAR(40) NOT NULL,
 lastname  VARCHAR(40) NOT NULL,
 cellphone VARCHAR(10),
 city VARCHAR(30),
 image VARCHAR(300)
);



CREATE TABLE Friend (
 id_friend NUMERIC(30) NOT NULL,
 user_id  NUMERIC(15) NOT NULL,
 friend_id NUMERIC(15) NOT NULL,
 state INT NOT NULL
);



CREATE TABLE PaymentMethod (
 id_payment_method NUMERIC(30) NOT NULL,
 user_id  NUMERIC(15) NOT NULL,
 card_number VARCHAR(20) NOT NULL
);


CREATE TABLE Rest_Order (
 id_order NUMERIC(10) NOT NULL,
 creation_date DATE NOT NULL,
 user_id  NUMERIC(15)
);

CREATE TABLE Restaurant (
 id_restaurant NUMERIC(15) NOT NULL,
 name VARCHAR(100) NOT NULL,
 longitude DECIMAL(10, 10) NOT NULL,
 latitude DECIMAL(10, 10) NOT NULL,
 likes NUMERIC,
 dislike NUMERIC,
 love NUMERIC,
 angry NUMERIC,
 user_id NUMERIC(15)
);

CREATE TABLE Command (
 id_command NUMERIC(10) NOT NULL,
 state INT NOT NULL,
 id_order NUMERIC(10),
 creation_date DATE NOT NULL
);



CREATE TABLE Dish (
 id_dish NUMERIC(10) NOT NULL,
 name VARCHAR(100) NOT NULL,
 price INT NOT NULL,
 description VARCHAR(100) NOT NULL,
 prep_time NUMERIC NOT NULL,
 image VARCHAR(300),
 id_restaurant NUMERIC(15) NOT NULL
);



CREATE TABLE Payment (
 id_payment NUMERIC(20) NOT NULL,
 payment_date DATE NOT NULL,
 transaction_state INT,
 id_command NUMERIC(10) NOT NULL,
 user_id  NUMERIC(15)
);



CREATE TABLE Command_Dish (
 id_command_dish NUMERIC(10) NOT NULL,
 id_command NUMERIC(10) NOT NULL,
 id_dish NUMERIC(10) NOT NULL
);

CREATE TABLE Comments (
 id_restaurant NUMERIC(15) NOT NULL,
 comment VARCHAR(100) NOT NULL,
 comment_date DATE NOT NULL
);

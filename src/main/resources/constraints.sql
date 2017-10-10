ALTER TABLE Friend ADD CONSTRAINT FK_Friend_0 FOREIGN KEY (user_id ) REFERENCES Users (user_id );
ALTER TABLE Friend ADD CONSTRAINT FK_Friend_1 FOREIGN KEY (friend_id) REFERENCES Users (user_id );
ALTER TABLE PaymentMethod ADD CONSTRAINT FK_PaymentMethod_0 FOREIGN KEY (user_id ) REFERENCES Users (user_id );
ALTER TABLE PaymentMethod ADD CONSTRAINT FK_PaymentMethod_1 FOREIGN KEY (card_number) REFERENCES CreditCard (card_number);
ALTER TABLE Rest_Order ADD CONSTRAINT FK_Rest_Order_0 FOREIGN KEY (user_id ) REFERENCES Users (user_id );
ALTER TABLE Restaurant ADD CONSTRAINT FK_Restaurant_0 FOREIGN KEY (user_id) REFERENCES Users (user_id );
ALTER TABLE Command ADD CONSTRAINT FK_Command_0 FOREIGN KEY (id_order) REFERENCES Rest_Order (id_order);
ALTER TABLE Comments ADD CONSTRAINT FK_Comments_0 FOREIGN KEY (id_restaurant) REFERENCES Restaurant (id_restaurant);
ALTER TABLE Dish ADD CONSTRAINT FK_Dish_0 FOREIGN KEY (id_restaurant) REFERENCES Restaurant (id_restaurant);
ALTER TABLE Payment ADD CONSTRAINT FK_Payment_0 FOREIGN KEY (id_command) REFERENCES Command (id_command);
ALTER TABLE Payment ADD CONSTRAINT FK_Payment_1 FOREIGN KEY (user_id ) REFERENCES Users (user_id );
ALTER TABLE Command_Dish ADD CONSTRAINT FK_Command_Dish_0 FOREIGN KEY (id_command) REFERENCES Command (id_command);
ALTER TABLE Command_Dish ADD CONSTRAINT FK_Command_Dish_1 FOREIGN KEY (id_dish) REFERENCES Dish (id_dish);



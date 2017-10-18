`restaurant`INSERT INTO Restaurant(NAME, longitude, latitude, likes, dislike, love, angry, user_id) VALUES ('El caldito feliz', 4.659924, 74.06593, '', '', '', '', 1);
INSERT INTO Restaurant(NAME, longitude, latitude, likes, dislike, love, angry, user_id) VALUES ('Pollo al cien', 4.593878, 74.183233, '', '', '', '', 2);
INSERT INTO Restaurant(NAME, longitude, latitude, likes, dislike, love, angry, user_id) VALUES ('Vida sana y mas', 4.734175, 74.07955, '', '', '', '', 3);

INSERT INTO Dish(NAME, price, description, prep_time, image, id_restaurant) VALUES ('Mazamorra chiquita', 8300, 'Mazamorra para una persona', 25, '', 1);
INSERT INTO Dish(NAME, price, description, prep_time, image, id_restaurant) VALUES ('Caldo parao', 6400, 'Caldo pa que le de perrenque', 23, '', 1);
INSERT INTO Dish(NAME, price, description, prep_time, image, id_restaurant) VALUES ('Arroz atollao', 5400, 'Arroz de la tierrita', 18, '', 1);
INSERT INTO Dish(NAME, price, description, prep_time, image, id_restaurant) VALUES ('Frijoles con garra', 7350, 'Frijoles poderosos', 15, '', 1);
INSERT INTO Dish(NAME, price, description, prep_time, image, id_restaurant) VALUES ('Cuchuco de trigo', 6000, 'Mejor que el de espinazo', 13, '', 1);
INSERT INTO Dish(NAME, price, description, prep_time, image, id_restaurant) VALUES ('Arroz con pollo', 7200, 'Delicioso arroz con trozos de pollo', 22, '', 2);
INSERT INTO Dish(NAME, price, description, prep_time, image, id_restaurant) VALUES ('Pollo al horno', 6500, 'Buen pollo para acompañar', 15, '', 2);
INSERT INTO Dish(NAME, price, description, prep_time, image, id_restaurant) VALUES ('Combo broaster', 14350, 'Especial para mas de uno', 27, '', 2);
INSERT INTO Dish(NAME, price, description, prep_time, image, id_restaurant) VALUES ('Caldo de muslo', 5700, 'Caldo con toda la esencia del pollo', 9, '', 2);
INSERT INTO Dish(NAME, price, description, prep_time, image, id_restaurant) VALUES ('Picada', 8000, '', 18, 'Para compartir con la familia', 2);
INSERT INTO Dish(NAME, price, description, prep_time, image, id_restaurant) VALUES ('Ensalada cesar', 6300, 'Deliciosa entrada', 25, '', 3);
INSERT INTO Dish(NAME, price, description, prep_time, image, id_restaurant) VALUES ('Pastel de tofu', 7400, 'Ideal para cuidar la figura', 17, '', 3);
INSERT INTO Dish(NAME, price, description, prep_time, image, id_restaurant) VALUES ('Salmon ahumado', 12700, 'Perfecto para un saludable almuerzo', 32, '', 3);
INSERT INTO Dish(NAME, price, description, prep_time, image, id_restaurant) VALUES ('Caldo de pasta ', 6500, 'Especial de reemplazo al plato fuerte', 22, '', 3);
INSERT INTO Dish(NAME, price, description, prep_time, image, id_restaurant) VALUES ('Croquetas light', 5500, 'Para disfrutar sin remordimientos', 12, '', 3);

INSERT INTO Rest_Order(creation_date, user_id) VALUES ('2018-03-12', 4);
INSERT INTO Rest_Order(creation_date, user_id) VALUES ('2018-03-27', 5);

INSERT INTO Command(state, id_order, creation_date) VALUES (0, 1, '2018-03-12');
INSERT INTO Command(state, id_order, creation_date) VALUES (0, 2, '2018-03-27');
create table products (
id INT auto_increment primary key,
product_name varchar(30) unique not null,
calories INT not null,
units varchar (15) not null
);

create table `meal_types`(
id INT auto_increment primary key,
type varchar(15) unique not null
);

create table meals (
id INT auto_increment primary key,
name VARCHAR (30) unique not null,
meal_type_id INT not null,
description TEXT,	
recipe_id INT not null,
constraint fk_meal_type_id
foreign key (meal_type_id)
references meal_types(id)
);


create table meals_products (
meal_id INT not null,
product_id INT not null,
ingredient_quantity int not null,
constraint pk_meals_products
primary key (meal_id, product_id),
constraint fk_product_id
foreign key (product_id)
references products(id),
constraint fk_meal_id
foreign key (meal_id)
references meals(id)
);






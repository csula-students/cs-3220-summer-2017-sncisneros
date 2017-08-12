USE cs3220_lab

CREATE TABLE food_items(
id INTEGER AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL,
description VARCHAR(255) NOT NULL,
price FLOAT NOT NULL
);

CREATE TABLE orders(
id INTEGER AUTO_INCREMENT PRIMARY KEY,
customer_name VARCHAR(255) NOT NULL,
created DATETIME NOT NULL
);

CREATE TABLE shopping_cart(
id INTEGER,
customer_name VARCHAR(255) NOT NULL,
food_id INTEGER NOT NULL,
quantity INTEGER NOT NULL
)


insert into food_items values(1, 'Hamburger', 'a hamburger', 9.99);
insert into food_items values(2, 'Fries', 'Some Fries', 4.99), (3, 'Coke', 'Coca Cola', 2.99);

insert into orders values(1, 'Eric', current_timestamp());
insert into orders values(2, 'John', current_timestamp()), (3, 'Jane', current_timestamp()), (4, 'Alice', current_timestamp());

insert into shopping_cart values(1, 'Anonymous', 1, 2), (1,'Anonymous',2,1), (1,'Anonymous',2,1), (2, 'Mike',1,1), (2, 'Mike',2,1), (3, 'Bob', 3, 1);

select * from food_items;
select * from orders;


UPDATE food_items SET name='Salad' where id=1;
select * from food_items;

UPDATE orders SET customer_name='Doe' where id='3';
select * from orders;

CREATE TABLE order_foods(
order_id INTEGER,
food_id INTEGER,
quantity INTEGER
)

insert into order_foods values(1, 1, 1), (1,2,2),(2,2,2),(2,3,1),(3,3,1),(4,2,1),(4,3,2);

select * from food_items join order_foods where food_items.id=order_foods.food_id;
select food_id, MAX(food_id_sum) from (SELECT food_id, SUM(quantity) as food_id_sum from order_foods GROUP BY food_id, food_id) a GROUP BY food_id;

SELECT id, MIN(food_id_sum) from (SELECT id, SUM(quantity) as food_id_sum from shopping_cart GROUP BY id, food_id) a GROUP BY id;

SELECT * FROM food_items;
SELECT * FROM orders;

SELECT id, customer_name from orders where created=20170722;

DROP TABLE food_items;
DROP TABLE orders;
DROP TABLE shopping_cart;

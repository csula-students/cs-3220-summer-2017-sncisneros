USE cs3220xstu05


CREATE TABLE food_items(
id INTEGER AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
description VARCHAR(255) NOT NULL,
imageurl VARCHAR(255) NOT NULL,
price FLOAT NOT NULL
);

INSERT INTO food_items values(1, 'Hamburger', 'An all-American burger, made medium-well, with a whole wheat bun. Unlimited fries included!', 'http://toriavey.com/images/2013/08/Hamburger-History-1.jpg', 12.99), (2, 'Tacos', 'Three tacos with grilled chicken, and a side of rice and beans. Your choice of salsa!', 'http://www.smells-like-home.com/wp-content/uploads/2012/08/roast-chicken-tacos-with-cilantro-cream-1.jpg', 17.95), (3, 'Buffalo Wings', 'Ten chicken wings soaked in a spicy buffalo sauce. Served with ranch!','http://fodmapliving.com/wp-content/uploads/2013/01/buffalo-wings.jpg', 15.95);

SELECT * FROM food_items;

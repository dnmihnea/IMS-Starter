DROP TABLE IF EXISTS `items` CASCADE;

DROP TABLE IF EXISTS `customers` CASCADE;

DROP TABLE IF EXISTS `orders` CASCADE;

DROP TABLE IF EXISTS `orders_items` CASCADE;

CREATE TABLE IF NOT EXISTS `customers`
(
   `id` INT AUTO_INCREMENT PRIMARY KEY,
   `firstName` VARCHAR(40),
   `surname` VARCHAR(40)
);

CREATE TABLE IF NOT EXISTS `items`
(
   `id` INT AUTO_INCREMENT PRIMARY KEY,
   `productName` VARCHAR(40),
   `price` DOUBLE
);

CREATE TABLE IF NOT EXISTS `orders`
(
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`fk_customer_id` INT NOT NULL,
	FOREIGN KEY (fk_customer_id) REFERENCES customers(id)
);

CREATE TABLE IF NOT EXISTS `orders_items`
(
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`fk_order_id` INT NOT NULL,
	`fk_item_id` INT NOT NULL,
	FOREIGN KEY (fk_order_id) REFERENCES orders(id),
	FOREIGN KEY (fk_item_id) REFERENCES items(id)
);
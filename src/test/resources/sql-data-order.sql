INSERT INTO `customers` (`firstName`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `customers` (`firstName`, `surname`) VALUES ('john', 'smith');

INSERT INTO `items`(`productName`, `price`) VALUES ('glasses', 39.99);
INSERT INTO `items`(`productName`, `price`) VALUES ('pen', 1.99);

INSERT INTO `orders`(`fk_customer_id`) VALUES (1);

INSERT INTO `orders_items`(`fk_order_id`, `fk_item_id`) VALUES (1, 1);
INSERT INTO `orders_items`(`fk_order_id`, `fk_item_id`) VALUES (2, 1);
INSERT INTO `orders_items`(`fk_order_id`, `fk_item_id`) VALUES (2, 2);
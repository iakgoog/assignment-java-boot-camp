CREATE TABLE product(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    description VARCHAR(255),
    price INT
);

CREATE TABLE cart(
    id INT PRIMARY KEY AUTO_INCREMENT,
    created_date DATETIME,
    product_id INT,
    quantity INT
);

ALTER TABLE cart ADD FOREIGN KEY (product_id) REFERENCES product(id);

CREATE TABLE shopping_order(
    id INT PRIMARY KEY AUTO_INCREMENT,
    created_date DATETIME,
    total_price INT,
    payment_status VARCHAR(50)
);

CREATE TABLE order_item(
    id INT PRIMARY KEY AUTO_INCREMENT,
    quantity INT,
    price INT,
    order_id INT,
    product_id INT
);

ALTER TABLE order_item ADD FOREIGN KEY (order_id) REFERENCES shopping_order(id);
ALTER TABLE order_item ADD FOREIGN KEY (product_id) REFERENCES product(id);
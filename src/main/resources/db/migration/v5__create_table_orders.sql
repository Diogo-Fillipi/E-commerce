CREATE TABLE order(
    orderId INT PRIMARY KEY AUTO_INCREMENT,
    cartId INT UNIQUE,
    orderStatus VARCHAR(100),
    constraint fk_order_cart FOREIGN KEY (cartId) REFERENCES cart(id) DELETE ON CASCADE
)
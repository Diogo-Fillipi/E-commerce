CREATE TABLE cart_item(
    cartItemId INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    cart_id INT,
    cart_item_price FLOAT,
    CONSTRAINT fk_cart_items FOREIGN KEY (cart_id) REFERENCES cart(id) ON DELETE CASCADE

)
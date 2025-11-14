CREATE TABLE cart(
    cartId INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT UNIQUE,
    cartItemId INT UNIQUE,
    CONSTRAINT fk_cart_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_cart_item FOREING KEY (cartItemId) references cartItems(id) ON DELETE CASCADE
);
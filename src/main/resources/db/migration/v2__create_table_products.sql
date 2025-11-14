CREATE TABLE products(
    productId INT PRIMARY KEY AUTO_INCREMENT,
    namee VARCHAR(255) NOT NULL UNIQUE,
    description TEXT,
    category VARCHAR(255),
    imageURL VARCHAR(255)
);
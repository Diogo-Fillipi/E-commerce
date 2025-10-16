CREATE TABLE users(
    id INT PRIMARY KEY AUTO_INCREMENT,
    namee VARCHAR(255) NOT NULL
    email VARCHAR(255) NOT NULL UNIQUE
    password VARCHAR(255) NOT NULL
    age INT NOT NULL
    userType VARCHAR(255) NOT NULL
    );

INSERT INTO users(namee, email, password, age, userType)
VALUES('admin', 'admin@gmail.com', 'admin123', 20, 'ADMIN');
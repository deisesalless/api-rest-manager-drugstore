CREATE TABLE tb_medication (
    id BINARY(16) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    concentration VARCHAR(255),
    pharmaceuticalForm TINYINT NOT NULL,
    laboratory TINYINT NOT NULL,
    registrationDate DATE NOT NULL,
    expirationDate DATE NOT NULL,
    quantityInStock INT NOT NULL,
    costPrice DOUBLE NOT NULL,
    salePrice DOUBLE NOT NULL
);

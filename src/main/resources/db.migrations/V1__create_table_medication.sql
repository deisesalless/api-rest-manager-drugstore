CREATE TABLE tb_medication (
    id BINARY(16) PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    concentration VARCHAR(255),
    pharmaceuticalForm TINYINT NOT NULL,
    laboratory TINYINT NOT NULL,
    expirationDate DATE,
    salePrice DOUBLE
);

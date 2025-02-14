CREATE TABLE tb_medication (
    id BINARY(16) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    concentration VARCHAR(255),
    pharmaceutical_form TINYINT NOT NULL,
    laboratory TINYINT NOT NULL,
    registration_date DATE NOT NULL,
    expiration_date DATE NOT NULL,
    quantity_in_stock INT NOT NULL,
    cost_price DOUBLE NOT NULL,
    sale_price DOUBLE NOT NULL
);

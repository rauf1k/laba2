-- Таблиця для рахунків
CREATE TABLE accounts (
                          id SERIAL PRIMARY KEY,
                          balance NUMERIC(12, 2) NOT NULL
);

-- Таблиця для клієнтів з посиланням на рахунок
CREATE TABLE clients (
                         id SERIAL PRIMARY KEY,
                         first_name VARCHAR(100) NOT NULL,
                         last_name VARCHAR(100) NOT NULL,
                         age INT NOT NULL,
                         account_id INT,
                         FOREIGN KEY (account_id) REFERENCES accounts(id)
);

-- Додаємо початкові записи в таблицю accounts
INSERT INTO accounts (id, balance) VALUES
                                       (1, 100.0),
                                       (2, 150.0),
                                       (3, 200.0);

-- Додаємо початкові записи в таблицю clients з посиланням на account_id
INSERT INTO clients (id, first_name, last_name, age, account_id) VALUES
                                                                     (1, 'Vasya', 'Pypkin', 18, 1),
                                                                     (2, 'Iva', 'Pypkina', 19, 2),
                                                                     (3, 'Inna', 'Pypkina', 20, 3);

-- Таблиця для напоїв
CREATE TABLE drinks (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        price NUMERIC(12, 2) NOT NULL,
                        quantity INT NOT NULL
);

-- Таблиця для інгредієнтів
CREATE TABLE ingredients (
                             id SERIAL PRIMARY KEY,
                             name VARCHAR(100) NOT NULL,
                             price NUMERIC(12, 2) NOT NULL,
                             quantity INT NOT NULL
);

-- Додаємо початкові записи в таблицю drinks
INSERT INTO drinks (id, name, price, quantity) VALUES
                                                   (1, 'Cappuccino', 50.0, 10),
                                                   (2, 'Latte', 55.0, 15),
                                                   (3, 'Americano', 40.0, 20),
                                                   (4, 'Espresso', 45.0, 12);

-- Додаємо початкові записи в таблицю ingredients
INSERT INTO ingredients (id, name, price, quantity) VALUES
                                                        (1, 'Milk', 10.0, 100),
                                                        (2, 'Sugar', 5.0, 200),
                                                        (3, 'Chocolate', 15.0, 50),
                                                        (4, 'Vanilla Syrup', 20.0, 30);

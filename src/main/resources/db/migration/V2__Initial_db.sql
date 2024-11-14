
CREATE TABLE drinks (
                        id int NOT NULL,
                        name VARCHAR(100) NOT NULL,
                        price NUMERIC(12,2) NOT NULL,
                        quantity INT NOT NULL,
                        PRIMARY KEY (id)
);


CREATE TABLE ingredients (
                             id int NOT NULL,
                             name VARCHAR(100) NOT NULL,
                             price NUMERIC(12,2) NOT NULL,
                             quantity INT NOT NULL,
                             PRIMARY KEY (id)
);




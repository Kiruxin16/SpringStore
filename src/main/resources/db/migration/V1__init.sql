CREATE TABLE IF NOT EXISTS products (id bigserial PRIMARY KEY, title varchar(255), price int);
INSERT INTO products (title,price)
VALUES
    ('Soccer вall',800),
    ('Jump rope', 600),
    ('Punching bag',12000),
    ('Barbell',20000),
    ('Dumbell',8000);
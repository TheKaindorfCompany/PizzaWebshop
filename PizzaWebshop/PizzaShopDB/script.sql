DROP CONSTRAINT ing_pro_PK;
DROP CONSTRAINT pro_PK;
DROP CONSTRAINT ing_PK;

DROP TABLE ingredients_in_product;
DROP TABLE products;
DROP TABLE ingredients;

CREATE TABLE products
(
  product_id NUMBER(10, 0),
  name VARCHAR2(50) NOT NULL,
  price NUMBER(5, 2) NOT NULL,
  picture VARCHAR(50)
);

CREATE TABLE ingredients
(
  ingredient_id NUMBER(10, 0),
  name VARCHAR2(50) NOT NULL,
  price NUMBER(5, 2) NOT NULL,
  amount NUMBER(10, 0) NOT NULL,
  picture VARCHAR(50)
);

CREATE TABLE ingredients_in_product
(
  product_id NUMBER(10, 0),
  ingredient_id NUMBER(10, 0)
);

ALTER TABLE products
ADD CONSTRAINT pro_PK PRIMARY KEY (product_id);
ALTER TABLE ingredients
ADD CONSTRAINT ing_PK PRIMARY KEY (ingredient_id);
ALTER TABLE ingredients_in_product
ADD CONSTRAINT ing_pro_PK PRIMARY KEY (product_id, ingredient_id);

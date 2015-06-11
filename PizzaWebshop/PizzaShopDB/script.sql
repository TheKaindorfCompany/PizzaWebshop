ALTER TABLE ingredients_in_product
DROP CONSTRAINT ing_pro_PK;
ALTER TABLE ingredients_in_product
DROP CONSTRAINT inp_pro_FK;
ALTER TABLE ingredients_in_product
DROP CONSTRAINT inp_ing_FK;

ALTER TABLE ingredients
DROP CONSTRAINT ing_PK;
ALTER TABLE ingredients
DROP CONSTRAINT ing_res_FK;

ALTER TABLE products
DROP CONSTRAINT pro_PK;
ALTER TABLE products
DROP CONSTRAINT pro_res_FK;

ALTER TABLE restaurant
DROP CONSTRAINT res_adr_PK;
ALTER TABLE restaurant
DROP CONSTRAINT res_adr_FK;

ALTER TABLE address
DROP CONSTRAINT adr_PK;

ALTER TABLE member
DROP CONSTRAINT mem_id_PK;
ALTER TABLE member
DROP CONSTRAINT mem_adr_FK;

DROP TABLE ingredients_in_product;
DROP TABLE products;
DROP TABLE ingredients;
DROP TABLE restaurant;
DROP TABLE address;
DROP TABLE member;

CREATE TABLE products
(
  product_id NUMBER(10, 0),
  restaurant_id NUMBER(10, 0),
  name VARCHAR2(50) NOT NULL,
  price NUMBER(5, 2) NOT NULL,
  picture VARCHAR(50)
);

CREATE TABLE ingredients
(
  ingredient_id NUMBER(10, 0),
  restaurant_id NUMBER(10, 0),
  name VARCHAR2(50) NOT NULL,
  price NUMBER(5, 2) NOT NULL,
  amount NUMBER(10, 0) NOT NULL,
  picture VARCHAR(50)
);

CREATE TABLE ingredients_in_product
(
  product_id NUMBER(10, 0),
  ingredient_id NUMBER(10, 0),
  restaurant_id NUMBER(10, 0)
);

CREATE TABLE address
(
  address_id NUMBER(10, 0),
  street VARCHAR2(50) NOT NULL,
  zip VARCHAR2(10) NOT NULL,
  town VARCHAR2(50) NOT NULL,
  xCoord NUMBER(10,10) NOT NULL,
  yCoord NUMBER(10,10) NOT NULL
);

CREATE TABLE restaurant
(
  restaurant_id NUMBER(10, 0),
  address_id NUMBER(10, 0) NOT NULL,
  name VARCHAR2(50) NOT NULL,
  description VARCHAR2(50) NOT NULL,
  picture VARCHAR(50)
);

CREATE TABLE member
(
  member_id NUMBER(10,0),
  first_name VARCHAR2(50),
  last_name VARCHAR2(50),
  address_id NUMBER(10, 0) NOT NULL,
  email VARCHAR2(150),
  password VARCHAR2(50)
);

CREATE TABLE restaurantowner
(
	restaurantowner_ID		NUMBER(4) NOT NULL PRIMARY KEY,
	first_name VARCHAR2(50),
  last_name VARCHAR2(50),
  address_id NUMBER(10, 0),
	email 		VARCHAR2(40) NOT NULL,
	password	VARCHAR2(40) NOT NULL
)

CREATE TABLE owners
{
  restaurantowner_ID		NUMBER(4) NOT NULL PRIMARY KEY,
  restaurant_id NUMBER(10, 0) NOT NULL PRIMARY KEY
}

CREATE TABLE newsletter
(
	newsletterID NUMBER(4) NOT NULL PRIMARY KEY,
	restaurantID NUMBER(4) NOT NULL PRIMARY KEY,
	text VARCHAR(40)
)

CREATE TABLE discount
(	
    discountID NUMBER(4) NOT NULL PRIMARY KEY
    restaurantID NUMBER(4) NOT NULL PRIMARY KEY,
    discount NUMBER(3) NOT NULL
)

ALTER TABLE address
ADD CONSTRAINT adr_PK PRIMARY KEY (address_id);

ALTER TABLE restaurant
ADD CONSTRAINT res_adr_FK FOREIGN KEY (address_id) REFERENCES address(address_id);
ALTER TABLE restaurant
ADD CONSTRAINT res_adr_PK PRIMARY KEY (restaurant_id);

ALTER TABLE products
ADD CONSTRAINT pro_res_FK FOREIGN KEY (restaurant_id) REFERENCES restaurant(restaurant_id);
ALTER TABLE products
ADD CONSTRAINT pro_PK PRIMARY KEY (product_id, restaurant_id);

ALTER TABLE ingredients
ADD CONSTRAINT ing_res_FK FOREIGN KEY (restaurant_id) REFERENCES restaurant(restaurant_id);
ALTER TABLE ingredients
ADD CONSTRAINT ing_PK PRIMARY KEY (ingredient_id, restaurant_id);

ALTER TABLE ingredients_in_product
ADD CONSTRAINT inp_pro_FK FOREIGN KEY (product_id, restaurant_id) REFERENCES products(product_id, restaurant_id);
ALTER TABLE ingredients_in_product
ADD CONSTRAINT inp_ing_FK FOREIGN KEY (ingredient_id, restaurant_id) REFERENCES ingredients(ingredient_id, restaurant_id);
ALTER TABLE ingredients_in_product
ADD CONSTRAINT ing_pro_PK PRIMARY KEY (product_id, ingredient_id, restaurant_id);

ALTER TABLE member
ADD CONSTRAINT mem_id_PK PRIMARY KEY (member_id);
ALTER TABLE member
ADD CONSTRAINT mem_adr_FK FOREIGN KEY (address_id) REFERENCES address(address_id);

ALTER TABLE newsletter
ADD CONSTANT nl_rid_fk FOREIGN KEY (restaurantID) REFERENCES restaurant(restaurantID);

ALTER TABLE discount
ADD CONSTANT di_rid_fk FOREIGN KEY (restaurantID) REFERENCES restaurant(restaurantID);

ALTER TABLE owners
ADD CONSTRAINT own_oid_FK FOREIGN KEY (restaurantowner_ID) REFERENCES restaurantowner(restaurantowner_ID);
ALTER TABLE owners
ADD CONSTRAINT res_oid_FK FOREIGN KEY (restaurant_id) REFERENCES restaurant(restaurant_id);


INSERT INTO restaurant (restaurant_id, address_id, name, description, picture)
VALUES(0, 0, 'Bread Zeppelin', 'SuperDuperDescription','bla.jpg');
INSERT INTO restaurant (restaurant_id, address_id, name, description, picture)
VALUES(1, 1, 'Thai Tanic','SuperDuperDescription',  'bla.jpg');
INSERT INTO restaurant (restaurant_id, address_id, name, description, picture)
VALUES(2, 2,  'Pita Pan', 'SuperDuperDescription','bla.jpg');
INSERT INTO restaurant (restaurant_id, address_id, name, description, picture)
VALUES(3, 3,  'Lord of the Wings', 'SuperDuperDescription','bla.jpg');
INSERT INTO restaurant (restaurant_id, address_id, name, description, picture)
VALUES(4, 4, 'Wok this way', 'SuperDuperDescription','bla.jpg');
INSERT INTO restaurant (restaurant_id, address_id, name, description, picture)
VALUES(5, 5,  'Grillenium Falcon', 'SuperDuperDescription','bla.jpg');


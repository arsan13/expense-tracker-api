CREATE DATABASE expense_tracker;

USE expense_tracker;

CREATE TABLE person (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(30) NOT NULL,
  last_name VARCHAR(30) NOT NULL,
  email VARCHAR(30) NOT NULL,
  password TEXT NOT NULL
);
CREATE TABLE category (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  title VARCHAR(30) NOT NULL,
  description VARCHAR(255)
);
ALTER TABLE
  category
ADD
  CONSTRAINT cat_users_fk FOREIGN KEY (id) REFERENCES person (id);
CREATE TABLE transaction (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    category_id INT NOT NULL,
    user_id INT NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    note VARCHAR(30) NOT NULL,
    transaction_date BIGINT NOT NULL
  );
ALTER TABLE
  transaction AUTO_INCREMENT = 1000;
ALTER TABLE
  transaction
ADD
  CONSTRAINT trans_cat_fk FOREIGN KEY (category_id) REFERENCES category (id);
ALTER TABLE
  transaction
ADD
  CONSTRAINT trans_user_fk FOREIGN KEY (user_id) REFERENCES person (id);

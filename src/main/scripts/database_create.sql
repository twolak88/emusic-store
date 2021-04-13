-- -----------------------------------------------------
-- Schema full-stack-ecommerce
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `emusicapp`;

CREATE SCHEMA `emusicapp`;
USE `emusicapp` ;


CREATE USER 'emusicuser'@'%' IDENTIFIED BY 'emusicuser';

GRANT ALL PRIVILEGES ON * . * TO 'emusicuser'@'%';

ALTER USER 'emusicuser'@'%' IDENTIFIED WITH mysql_native_password BY 'emusicuser';

CREATE TABLE authorities (
    id BIGINT NOT NULL AUTO_INCREMENT,
    authority VARCHAR(255),
    username VARCHAR(255),
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE billing_addresses (
    id BIGINT NOT NULL AUTO_INCREMENT,
    apartmentNumber VARCHAR(255),
    city VARCHAR(255),
    country VARCHAR(255),
    state VARCHAR(255),
    streetName VARCHAR(255),
    zipCode VARCHAR(255),
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE cart_items (
    id BIGINT NOT NULL AUTO_INCREMENT,
    quantity INTEGER NOT NULL,
    totalPrice DOUBLE PRECISION NOT NULL,
    cart_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE carts (
    id BIGINT NOT NULL AUTO_INCREMENT,
    active BIT NOT NULL,
    dateCreated DATETIME(6),
    grandTotal DOUBLE PRECISION NOT NULL,
    lastUpdated DATETIME(6),
    customer_id BIGINT,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE customers (
    id BIGINT NOT NULL AUTO_INCREMENT,
    dateCreated DATETIME(6),
    email VARCHAR(255),
    enabled BIT NOT NULL,
    lastUpdated DATETIME(6),
    name VARCHAR(255),
    password VARCHAR(255),
    phone VARCHAR(255),
    username VARCHAR(255),
    billing_address_id BIGINT,
    shipping_address_id BIGINT,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE orders (
    id BIGINT NOT NULL AUTO_INCREMENT,
    dateCreated DATETIME(6),
    lastUpdated DATETIME(6),
    status VARCHAR(255),
    billing_address_id BIGINT,
    cart_id BIGINT,
    customer_id BIGINT,
    shipping_address_id BIGINT,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE products (
    id BIGINT NOT NULL AUTO_INCREMENT,
    category VARCHAR(255),
    prod_condition VARCHAR(255),
    dateCreated DATETIME(6),
    description VARCHAR(255),
    product_image_url VARCHAR(255),
    lastUpdated DATETIME(6),
    manufacturer VARCHAR(255),
    name VARCHAR(255),
    price DOUBLE PRECISION,
    status VARCHAR(255),
    unit_in_stock INTEGER,
    user_id BIGINT,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE shipping_addresses (
    id BIGINT NOT NULL AUTO_INCREMENT,
    apartmentNumber VARCHAR(255),
    city VARCHAR(255),
    country VARCHAR(255),
    state VARCHAR(255),
    streetName VARCHAR(255),
    zipCode VARCHAR(255),
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE users (
    id BIGINT NOT NULL AUTO_INCREMENT,
    customerId BIGINT,
    enabled BIT NOT NULL,
    password VARCHAR(255),
    username VARCHAR(255),
    PRIMARY KEY (id)
)  ENGINE=INNODB;
alter table customers drop index UK_rfbvkrffamfql7cjmen8v976v;
alter table customers add constraint UK_rfbvkrffamfql7cjmen8v976v unique (email);
alter table customers drop index UK_to73biqfrti0j9f7k12l255w5;
alter table customers add constraint UK_to73biqfrti0j9f7k12l255w5 unique (name);
alter table customers drop index UK_m3iom37efaxd5eucmxjqqcbe9;
alter table customers add constraint UK_m3iom37efaxd5eucmxjqqcbe9 unique (phone);
alter table customers drop index UK_bepynu3b6l8k2ppuq6b33xfxc;
alter table customers add constraint UK_bepynu3b6l8k2ppuq6b33xfxc unique (username);
alter table users drop index UK_2sds9i5vely5j7w8xo9wqn66d;
alter table users add constraint UK_2sds9i5vely5j7w8xo9wqn66d unique (customerId);
alter table users drop index UK_r43af9ap4edm43mmtq01oddj6;
alter table users add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);
alter table cart_items add constraint FKpcttvuq4mxppo8sxggjtn5i2c foreign key (cart_id) references carts (id);
alter table cart_items add constraint FK1re40cjegsfvw58xrkdp6bac6 foreign key (product_id) references products (id);
alter table carts add constraint FK8ba3sryid5k8a9kidpkvqipyt foreign key (customer_id) references customers (id);
alter table customers add constraint FKiwlu6u5pdouj1gxt7whyb2prr foreign key (billing_address_id) references billing_addresses (id);
alter table customers add constraint FKfxir83vk7by833a6hsygpk7jl foreign key (shipping_address_id) references shipping_addresses (id);
alter table orders add constraint FKnfwvcsqt2ssekkvqqu67a31i1 foreign key (billing_address_id) references billing_addresses (id);
alter table orders add constraint FK594fgx8wpklcf3t41jq3grhlh foreign key (cart_id) references carts (id);
alter table orders add constraint FKpxtb8awmi0dk6smoh2vp1litg foreign key (customer_id) references customers (id);
alter table orders add constraint FKstjxbn0162q6csb4f7ejx3fwe foreign key (shipping_address_id) references shipping_addresses (id);
alter table products add constraint FKdb050tk37qryv15hd932626th foreign key (user_id) references users (id);

-- DROP TABLE users;
-- DROP TABLE clients;
-- DROP TABLE contacts;
-- DROP TABLE orders;
-- DROP TABLE ordersToContactsBinding;

CREATE TABLE IF NOT EXISTS users (
  user_id BIGINT NOT NULL ,
  login VARCHAR(100),
  password VARCHAR(100),
  name VARCHAR(100),
  PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS clients (
  client_id BIGINT NOT NULL,
  name VARCHAR(100) NOT NULL,
  advertisementId BIGINT,
  PRIMARY KEY (client_id)
);

CREATE TABLE IF NOT EXISTS contacts (
  contact_id BIGINT NOT NULL,
  client_id BIGINT,
  name VARCHAR(100),
  phone VARCHAR(100),
  PRIMARY KEY (contact_id),
  FOREIGN KEY (client_id) REFERENCES clients(client_id)
);

CREATE TABLE orders (
  order_id BIGINT NOT NULL,
  amount DOUBLE,
  description VARCHAR(1024),
  client_id BIGINT,
  contact_id BIGINT,
  PRIMARY KEY (order_id),
  FOREIGN KEY (client_id) REFERENCES clients(client_id),
  FOREIGN KEY (contact_id) REFERENCES contacts(contact_id)
);

CREATE TABLE orders_contacts_binding (
  order_id BIGINT NOT NULL,
  contact_id BIGINT NOT NULL,
  PRIMARY KEY (order_id, contact_id),
  FOREIGN KEY (order_id) REFERENCES orders(order_id),
  FOREIGN KEY (contact_id) REFERENCES contacts(contact_id)
)

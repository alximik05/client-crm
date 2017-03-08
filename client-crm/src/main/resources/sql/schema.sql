-- DROP TABLE users;
-- DROP TABLE clients;
-- DROP TABLE contacts;
-- DROP TABLE orders;
-- DROP TABLE ordersToContactsBinding;

CREATE TABLE IF NOT EXISTS users (
  id BIGINT NOT NULL ,
  login VARCHAR(100),
  password VARCHAR(100),
  name VARCHAR(100),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS clients (
  id BIGINT NOT NULL,
  name VARCHAR(100) NOT NULL,
  advertisementId BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS contacts (
  id BIGINT NOT NULL,
  idClient BIGINT,
  name VARCHAR(100),
  phone VARCHAR(100),
  PRIMARY KEY (id),
  FOREIGN KEY (idClient) REFERENCES clients(id)
);

CREATE TABLE orders (
  id BIGINT NOT NULL,
  amount DOUBLE,
  description VARCHAR(1024),
  idClient BIGINT,
  idContact BIGINT,
  PRIMARY KEY (id),
  FOREIGN KEY (idClient) REFERENCES clients,
  FOREIGN KEY (idContact) REFERENCES contacts
);

CREATE TABLE ordersToContactsBinding (
  id BIGINT NOT NULL,
  idOrder BIGINT NOT NULL,
  idContact BIGINT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (idOrder) REFERENCES orders,
  FOREIGN KEY (idContact) REFERENCES contacts
)

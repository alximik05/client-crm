INSERT INTO USERS(USER_ID, LOGIN, PASSWORD, NAME) VALUES (1, 'admin', 'admin', 'админ');
INSERT INTO USERS(USER_ID, LOGIN, PASSWORD, NAME) VALUES (2, 'user', 'user', 'юзер');

INSERT INTO CLIENTS(CLIENT_ID, NAME,ADVERTISEMENTID) VALUES (1, 'газпром', 1);
INSERT INTO CLIENTS(CLIENT_ID, NAME,ADVERTISEMENTID) VALUES (2, 'роснано', 2);
INSERT INTO CLIENTS(CLIENT_ID, NAME,ADVERTISEMENTID) VALUES (3, 'башнефть', 1);

INSERT INTO CONTACTS(CONTACT_ID, CLIENT_ID, NAME, PHONE) VALUES (1, 1, 'Ванек', '111-11-11');
INSERT INTO CONTACTS(CONTACT_ID, CLIENT_ID, NAME, PHONE) VALUES (2, 2, 'Игорян', '222-22-22');
INSERT INTO CONTACTS(CONTACT_ID, CLIENT_ID, NAME, PHONE) VALUES (3, 3, 'Сослан', '333-33-33');

INSERT INTO ORDERS(ORDER_ID, AMOUNT, DESCRIPTION, CLIENT_ID, CONTACT_ID) VALUES (1, 1000000, 'пару кубов газа', 1, 1);
INSERT INTO ORDERS(ORDER_ID, AMOUNT, DESCRIPTION, CLIENT_ID, CONTACT_ID) VALUES (2, 2000000, 'пару нано штуковин', 2, 2);
INSERT INTO ORDERS (ORDER_ID, AMOUNT, DESCRIPTION, CLIENT_ID, CONTACT_ID) VALUES (3, 3000000, 'пару галонов нефти', 3, 3);

INSERT INTO ORDERSTOCONTACTSBINDING(ORDER_TO_CONTACT_ID, ORDER_ID, CONTACT_ID) VALUES (1, 1, 1);
INSERT INTO ORDERSTOCONTACTSBINDING(ORDER_TO_CONTACT_ID, ORDER_ID, CONTACT_ID) VALUES (2, 2, 2);
INSERT INTO ORDERSTOCONTACTSBINDING(ORDER_TO_CONTACT_ID, ORDER_ID, CONTACT_ID) VALUES (3, 3, 3);
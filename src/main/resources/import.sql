INSERT INTO users(id, firstName, password) VALUES (1, 'admin', 'admin');
INSERT INTO role(id, name) VALUES (1, 'ROLE_ADMIN'), (2, 'ROLE_USER');
INSERT INTO users_role(User_id, roles_id) VALUES (1, 1);
DELETE FROM userA_roles;
DELETE FROM usersA;
ALTER SEQUENCE global_seqa RESTART WITH 100000;

INSERT INTO usersA (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO userA_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

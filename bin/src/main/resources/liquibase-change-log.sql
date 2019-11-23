--liquibase formatted sql
--changeset nvoxland:1

INSERT INTO users(id, username, password, enabled) 
SELECT 1, 'superuser@management-equipments.com', '$2a$10$EXHs2XSi8bgA7C1TBiDkWeISW3YBlTqYIjVF75MVrdqB6GfO1GNA.', true
 WHERE NOT EXISTS (SELECT username FROM users WHERE username = 'superuser@management-equipments.com');

--changeset nvoxland:8
INSERT INTO roles SELECT 1,'ADMIN' WHERE NOT EXISTS (SELECT role FROM roles WHERE role = 'ADMIN');
INSERT INTO roles SELECT 2,'NORMAL' WHERE NOT EXISTS (SELECT role FROM roles WHERE role = 'NORMAL');



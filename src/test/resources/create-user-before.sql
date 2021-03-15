delete from users_roles;
delete from roles;
delete from users;


INSERT INTO users (id, username, password, first_name, last_name, email)
VALUES (1, 'andrey', '$2a$10$/K.WdZlnm6GJni3i2ahWiueIovcoUoTHMHIDYD.JzqDL7RcMG8Q.y', 'Andrey', 'Savin', 'andrey@crm' ||
                                                                                                        '.com'),
       (2, 'boris', '$2a$10$/K.WdZlnm6GJni3i2ahWiueIovcoUoTHMHIDYD.JzqDL7RcMG8Q.y', 'Boris', 'Borisov',
        'boris@crm.com'),
       (3, 'alena', '$2a$10$/K.WdZlnm6GJni3i2ahWiueIovcoUoTHMHIDYD.JzqDL7RcMG8Q.y', 'Alena', 'Alenova',
        'alena@crm.com');


INSERT INTO roles (id, name)
VALUES (1, 'ROLE_EMPLOYEE'),
       (2, 'ROLE_MANAGER'),
       (3, 'ROLE_ADMIN');


INSERT INTO users_roles (user_id, role_id)
VALUES (1, 1),
       (2, 1),
       (2, 2),
       (3, 1),
       (3, 2),
       (3, 3);


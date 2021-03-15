delete from employee;

ALTER SEQUENCE employee_id_seq RESTART WITH 10;

INSERT INTO employee (id, first_name, last_name, email, photo)
VALUES (1, 'Andrey', 'Savin', 'savin@gmail.com', 'Savin-photo.jpg'),
       (2, 'Emma', 'Baumgarten', 'emma@gmail.com', 'Savin-photo.jpg'),
       (3, 'Avani', 'Gupta', 'avani@gmail.com', 'Savin-photo.jpg'),
       (4, 'Yuri', 'Petrov', 'yuri@gmail.com', 'Savin-photo.jpg');
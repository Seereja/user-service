-- Вставка данных в таблицу user с указанными UUID
INSERT INTO users (id, first_name, last_name, birth_date, passport_number, login, password, snils)
VALUES ('7261f898-f3a5-40b6-8b31-cac81866b78e', 'Name1', 'Surname1', '1990-01-01', 123456, 'login1', 'password1',
        '123-456-789 12'),
       ('5cf4584f-2110-49ff-abed-de583fb2a4bc', 'Name2', 'Surname2', '1995-05-15', 654321, 'login2', 'password2',
        '987-654-321 98');


-- Вставка данных в таблицу user_roles с указанными UUID
INSERT INTO user_roles (user_id, role)
VALUES ('7261f898-f3a5-40b6-8b31-cac81866b78e', 'ADMIN'),
       ('5cf4584f-2110-49ff-abed-de583fb2a4bc', 'USER');

-- Вставка данных в таблицу user с указанными UUID
INSERT INTO users (id, first_name, last_name, birth_date, passport_number, login, password, snils)
VALUES ('7261f898-f3a5-40b6-8b31-cac81866b78e', 'Name', 'Surname', '1990-01-01', 12345678, 'login1',
        'password1', '123-456-789 12'),
       ('5cf4584f-2110-49ff-abed-de583fb2a4bc', 'Name', 'Surname', '1995-05-15', 654321, 'login2',
        'password2', '987-654-321 98');


-- Вставка данных в таблицу user_roles с указанными UUID
INSERT INTO user_roles (user_id, role)
VALUES ('7261f898-f3a5-40b6-8b31-cac81866b78e', 'ADMIN'),
       ('5cf4584f-2110-49ff-abed-de583fb2a4bc', 'USER');


-- Вставка данных в таблицу requisites с указанными UUID
INSERT INTO requisites (id, settlement_account, bik, correspondent_account, inn, kpp, kbk, user_id)
VALUES ('87511a8c-8a7d-47e3-90c1-9268bec562ba', '12345678901234567890', '044525225', '30101810400000000225', '1234567890',
        '771501001', '03531000000000000130', '7261f898-f3a5-40b6-8b31-cac81866b78e'),
       ('fb1e084b-e009-4ea1-bf72-a09f53e4c67d', 'SettlementAccount2', 'Bik2', 'CorrespondentAccount2', '0987654321',
        NULL, NULL, '5cf4584f-2110-49ff-abed-de583fb2a4bc');

-- Вставка данных в таблицу user с указанными UUID
INSERT INTO users (id, first_name, last_name, birth_date, inn, passport_number, login, password, snils)
VALUES
    ('7261f898-f3a5-40b6-8b31-cac81866b78e', 'Name1', 'Surname1', '1990-01-01', '1234567890', 123456, 'login1', 'password1', '123-456-789 12'),
    ('5cf4584f-2110-49ff-abed-de583fb2a4bc', 'Name2', 'Surname2', '1995-05-15', '0987654321', 654321, 'login2', 'password2', '987-654-321 98'),
    ('d812a938-ee06-4fd6-aa4a-646e1c00633d', 'Name3', 'Surname3', '1988-07-20', '1357908642', 987654, 'login3', 'password3', '246-135-789 33'),
    ('67cc4567-60bb-45bc-ad0d-74fa3d2eab46', 'Name4', 'Surname4', '1993-03-10', '2468135790', 159357, 'login4', 'password4', '357-246-813 44'),
    ('05336f97-9d63-402f-b983-31bf7be8cd6d', 'Name5', 'Surname5', '1997-09-25', '9876543210', 753159, 'login5', 'password5', '654-987-321 88'),
    ('eefd7ae6-995b-4fc4-9bbe-5606613ceb6a', 'Name6', 'Surname6', '1991-11-05', '1029384756', 951753, 'login6', 'password6', '987-654-321 99'),
    ('17993939-f415-4003-b38b-fe34ef283645', 'Name7', 'Surname7', '1985-12-30', '9876543211', 753159, 'login7', 'password7', '654-987-321 87'),
    ('5dd8475d-ac91-4980-ae8b-77cefc3a6267', 'Name8', 'Surname8', '1980-08-17', '1234567899', 987654, 'login8', 'password8', '987-654-321 66'),
    ('178e1c0e-506c-490a-9b97-90059a4ce9f8', 'Name9', 'Surname9', '1999-04-12', '9876543212', 753159, 'login9', 'password9', '654-987-321 55'),
    ('3e59b43f-8ff1-403d-993b-7f7181d6ffd4', 'Name10', 'Surname10', '1994-06-18', '1029384756', 951753, 'login10', 'password10', '987-654-321 44'),
    ('2fedb9b9-1176-408d-942f-bd2ba26cd187', 'Name11', 'Surname11', '1983-02-22', '1234567898', 987654, 'login11', 'password11', '654-987-321 33'),
    ('b4281a7f-04d5-4a39-8cc5-27880bb25653', 'Name12', 'Surname12', '1996-08-07', '9876543213', 753159, 'login12', 'password12', '987-654-321 22'),
    ('328f3ff6-2623-41bb-bc81-e09d6a1d864c', 'Name13', 'Surname13', '1987-10-14', '1029384756', 951753, 'login13', 'password13', '654-987-321 11'),
    ('6ec313e1-e79e-44ff-8a62-dd4b71af75d3', 'Name14', 'Surname14', '1992-12-29', '1234567897', 987654, 'login14', 'password14', '987-654-321 00'),
    ('545d14fc-41c4-4dcd-82d8-4a2308b42cbc', 'Name15', 'Surname15', '1989-04-03', '9876543214', 753159, 'login15', 'password15', '654-987-321 99'),
    ('c6c97c52-d8d7-431a-aafa-088cccae96b5', 'Name16', 'Surname16', '1998-07-28', '1029384756', 951753, 'login16', 'password16', '987-654-321 88'),
    ('e65d47ab-0bd9-49e8-95f4-320feeef2e81', 'Name17', 'Surname17', '1986-11-11', '1234567896', 987654, 'login17', 'password17', '654-987-321 77'),
    ('ae432eb6-b4c8-435a-9727-80c07d382514', 'Name18', 'Surname18', '1995-01-24', '1029384756', 951753, 'login18', 'password18', '987-654-321 66'),
    ('28689965-c0a0-4c35-b583-987c353452ae', 'Name19', 'Surname19', '1984-03-15', '1234567895', 987654, 'login19', 'password19', '654-987-321 55'),
    ('e361bbdf-c1da-49bd-a83e-60e625df1c70', 'Name20', 'Surname20', '1990-01-01', '1234567890', 123456, 'login20', 'password20', '123-456-789 12');

-- Вставка данных в таблицу user_roles с указанными UUID
INSERT INTO user_roles (user_id, role)
VALUES
    ('7261f898-f3a5-40b6-8b31-cac81866b78e', 'ADMIN'),
    ('5cf4584f-2110-49ff-abed-de583fb2a4bc', 'USER'),
    ('d812a938-ee06-4fd6-aa4a-646e1c00633d', 'ADMIN'),
    ('67cc4567-60bb-45bc-ad0d-74fa3d2eab46', 'USER'),
    ('05336f97-9d63-402f-b983-31bf7be8cd6d', 'ADMIN'),
    ('eefd7ae6-995b-4fc4-9bbe-5606613ceb6a', 'USER'),
    ('17993939-f415-4003-b38b-fe34ef283645', 'ADMIN'),
    ('5dd8475d-ac91-4980-ae8b-77cefc3a6267', 'USER'),
    ('178e1c0e-506c-490a-9b97-90059a4ce9f8', 'ADMIN'),
    ('3e59b43f-8ff1-403d-993b-7f7181d6ffd4', 'USER'),
    ('2fedb9b9-1176-408d-942f-bd2ba26cd187', 'ADMIN'),
    ('b4281a7f-04d5-4a39-8cc5-27880bb25653', 'USER'),
    ('328f3ff6-2623-41bb-bc81-e09d6a1d864c', 'ADMIN'),
    ('6ec313e1-e79e-44ff-8a62-dd4b71af75d3', 'USER'),
    ('545d14fc-41c4-4dcd-82d8-4a2308b42cbc', 'ADMIN'),
    ('c6c97c52-d8d7-431a-aafa-088cccae96b5', 'USER'),
    ('e65d47ab-0bd9-49e8-95f4-320feeef2e81', 'ADMIN'),
    ('ae432eb6-b4c8-435a-9727-80c07d382514', 'USER'),
    ('28689965-c0a0-4c35-b583-987c353452ae', 'ADMIN'),
    ('e361bbdf-c1da-49bd-a83e-60e625df1c70', 'USER');

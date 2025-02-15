
INSERT INTO addresses (region, postal_code, city, street, house, building, flat) VALUES
('Москва', '101000', 'Москва', 'Тверская', 1, NULL, 10),
('Санкт-Петербург', '190000', 'Санкт-Петербург', 'Невский проспект', 5, 1, 20),
('Новосибирск', '630000', 'Новосибирск', 'Улица Ленина', 15, NULL, 5);
›
-- Заполнение таблицы breeds
INSERT INTO breeds (breed_name) VALUES
('Сибирский Хаски'),
('Персидская Кошка'),
('Золотистый Ретривер'),
('Мейн-кун');

-- Заполнение таблицы colors
INSERT INTO colors (color_name) VALUES
('Черный'),
('Белый'),
('Серый'),
('Коричневый'),
('Табби');

-- Заполнение таблицы breed_colors
INSERT INTO breed_colors (breed_id, color_id) VALUES
(1, 1), -- Сибирский Хаски - Черный
(1, 2), -- Сибирский Хаски - Белый
(2, 3), -- Персидская Кошка - Серый
(2, 4), -- Персидская Кошка - Коричневый
(3, 1), -- Золотистый Ретривер - Черный
(3, 5); -- Золотистый Ретривер - Табби

-- Заполнение таблицы animals
INSERT INTO animals (breed_id, animal_name, gender, description, date_of_birth, owner_id) VALUES
(1, 'Макс', 'M', 'Трехцветный нос', '2020-05-01', 1),
(2, 'Мурзик', 'F', 'Вьющиеся вибриссы', '2019-08-15', 2),
(3, 'Друг', 'M', 'левое ухо меньше правого', '2021-03-10', 3);

-- Заполнение таблицы pricelists
INSERT INTO pricelists (procedure_name, price) VALUES
('Вакцинация', 1500.00),
('Груминг', 800.00),
('Общий осмотр', 1200.00);

-- Заполнение таблицы procedures
INSERT INTO procedures (name_procedures) VALUES
('Вакцинация'),
('Груминг'),
('Профилактический осмотр');


INSERT INTO types_procedures (procedure_id, animal_id) values
(1, 1);
(2, 1);
(3, 3);

-- Заполнение таблицы owners
INSERT INTO owners (owner_name, surname, telephone, address_id) VALUES
('Иван', 'Иванов', '+79001234567', 1),
('Анна', 'Петрова', '+79007654321', 2),
('Петр', 'Сидоров', '+79009876543', 3);

-- Заполнение таблицы breeders
INSERT INTO breeders (name_club, rkf_number) VALUES
('Клуб любителей собак', 123456),
('Ассоциация кошководов', 654321);

-- Заполнение таблицы medical_records
INSERT INTO medical_records (animal_id, complaints, diagnosis, weight, is_reproducible, date_visit, doctor_surname) VALUES
(1, 'Кашель', 'Бронхит', 25.5, false, '2021-02-14', 'Емельянова'),
(2, NULL, NULL, 4.0, true, '2022-11-30', 'Новицкий'),
(3, 'Вялость', 'Обезвоживание', 30.0, true, '2022-02-02', 'Емельянова');

-- Заполнение таблицы vaccinations
INSERT INTO vaccinations (animal_id, vaccination_type, vaccine_used, batch_number, vaccination_date, valid_until) VALUES
(1, 'Вакцинация от бешенства', 'Rabivax', 'RB12345A', '2022-05-01', '2025-05-01'),
(2, 'Вакцинация от панлейкопении у кошек', 'Felovax', 'FD54321B', '2021-08-15', '2024-08-15');

-- Заполнение таблицы identifications
INSERT INTO identifications (animal_id, date_of_microchipping, location_microchip, tattoo_number, date_of_tattooing, pedigree_number) VALUES
(1, NULL, NULL, 89765, '2020-06-01', 90399),
(2, '2021-08-12', 'холка', null, null, 895487);
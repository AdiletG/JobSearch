
-- =====================
-- 1. USERS (20 EMPLOYER + 20 APPLICANT)
-- =====================
INSERT INTO users (name, surname, age, email, password, phone_number, avatar, account_type)
VALUES
    ('Adilet',    'Janybek',      35, 'adilet@techcorp.kg',      '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996700111001', 'avatars/adilet.jpg',      'EMPLOYER'),
    ('Bakyt',     'Mamytov',      42, 'bakyt@logistic.kg',       '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996700111002', 'avatars/bakyt.jpg',       'EMPLOYER'),
    ('Cholpon',   'Sydykova',     38, 'cholpon@edunet.kg',       '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996700111003', 'avatars/cholpon.jpg',     'EMPLOYER'),
    ('Daniyar',   'Usenov',       45, 'daniyar@medclinic.kg',    '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996700111004', 'avatars/daniyar.jpg',     'EMPLOYER'),
    ('Elmira',    'Kadyrova',     39, 'elmira@buildpro.kg',      '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996700111005', 'avatars/elmira.jpg',      'EMPLOYER'),
    ('Farukh',    'Tashmatov',    41, 'farukh@fintech.kg',       '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996700111006', 'avatars/farukh.jpg',      'EMPLOYER'),
    ('Gulzat',    'Omurzakova',   36, 'gulzat@retailplus.kg',    '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996700111007', 'avatars/gulzat.jpg',      'EMPLOYER'),
    ('Hamza',     'Ryskulov',     44, 'hamza@agro.kg',           '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996700111008', 'avatars/hamza.jpg',       'EMPLOYER'),
    ('Irina',     'Sokolova',     37, 'irina@lawfirm.kg',        '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996700111009', 'avatars/irina.jpg',       'EMPLOYER'),
    ('Jyldyz',    'Bekturova',    40, 'jyldyz@tourism.kg',       '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996700111010', 'avatars/jyldyz.jpg',      'EMPLOYER'),
    ('Kanat',     'Dzhaksybekov', 43, 'kanat@mining.kg',         '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996700111011', 'avatars/kanat.jpg',       'EMPLOYER'),
    ('Larisa',    'Ivanova',      38, 'larisa@media.kg',         '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996700111012', 'avatars/larisa.jpg',      'EMPLOYER'),
    ('Marat',     'Sydykov',      46, 'marat@energy.kg',         '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996700111013', 'avatars/marat.jpg',       'EMPLOYER'),
    ('Nurgul',    'Asanova',      35, 'nurgul@pharma.kg',        '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996700111014', 'avatars/nurgul.jpg',      'EMPLOYER'),
    ('Osmon',     'Toktosunov',   42, 'osmon@security.kg',       '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996700111015', 'avatars/osmon.jpg',       'EMPLOYER'),
    ('Perizat',   'Nurlanovna',   39, 'perizat@design.kg',       '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996700111016', 'avatars/perizat.jpg',     'EMPLOYER'),
    ('Ruslan',    'Mamatov',      44, 'ruslan@transport.kg',     '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996700111017', 'avatars/ruslan.jpg',      'EMPLOYER'),
    ('Saltanat',  'Bekova',       37, 'saltanat@food.kg',        '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996700111018', 'avatars/saltanat.jpg',    'EMPLOYER'),
    ('Talant',    'Orozov',       41, 'talant@consulting.kg',    '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996700111019', 'avatars/talant.jpg',      'EMPLOYER'),
    ('Ulanbek',   'Mamytov',      38, 'ulanbek@realestate.kg',   '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996700111020', 'avatars/ulanbek.jpg',     'EMPLOYER'),

    ('Ainura',    'Dzhaksybekova',24, 'ainura@mail.kg',          '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996770211001', 'avatars/ainura.jpg',      'APPLICANT'),
    ('Bekzat',    'Usenov',       27, 'bekzat@mail.kg',          '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996770211002', 'avatars/bekzat.jpg',      'APPLICANT'),
    ('Cholponai', 'Ryskulova',    30, 'cholponai@mail.kg',       '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996770211003', 'avatars/cholponai.jpg',   'APPLICANT'),
    ('Dastan',    'Mamatov',      22, 'dastan@mail.kg',          '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996770211004', 'avatars/dastan.jpg',      'APPLICANT'),
    ('Eliza',     'Nurlanovna',   29, 'eliza@mail.kg',           '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996770211005', 'avatars/eliza.jpg',       'APPLICANT'),
    ('Farida',    'Asanova',      26, 'farida@mail.kg',          '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996770211006', 'avatars/farida.jpg',      'APPLICANT'),
    ('Gulnara',   'Bekova',       31, 'gulnara@mail.kg',         '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996770211007', 'avatars/gulnara.jpg',     'APPLICANT'),
    ('Hamid',     'Jumaev',       25, 'hamid@mail.kg',           '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996770211008', 'avatars/hamid.jpg',       'APPLICANT'),
    ('Iskender',  'Orozov',       28, 'iskender@mail.kg',        '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996770211009', 'avatars/iskender.jpg',    'APPLICANT'),
    ('Janara',    'Seitova',      33, 'janara@mail.kg',          '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996770211010', 'avatars/janara.jpg',      'APPLICANT'),
    ('Kuban',     'Dzhaksybekov', 26, 'kuban@mail.kg',           '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996770211011', 'avatars/kuban.jpg',       'APPLICANT'),
    ('Lira',      'Mamytova',     31, 'lira@mail.kg',            '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996770211012', 'avatars/lira.jpg',        'APPLICANT'),
    ('Manas',     'Atabekov',     25, 'manas@mail.kg',           '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996770211013', 'avatars/manas.jpg',       'APPLICANT'),
    ('Nurzat',    'Isaeva',       28, 'nurzat@mail.kg',          '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996770211014', 'avatars/nurzat.jpg',      'APPLICANT'),
    ('Omurbek',   'Toktosunov',   33, 'omurbek@mail.kg',         '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996770211015', 'avatars/omurbek.jpg',     'APPLICANT'),
    ('Perizat',   'Kadyrova',     27, 'perizat_a@mail.kg',       '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996770211016', 'avatars/perizat_a.jpg',   'APPLICANT'),
    ('Ruslan',    'Sydykov',      30, 'ruslan_a@mail.kg',        '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996770211017', 'avatars/ruslan_a.jpg',    'APPLICANT'),
    ('Saltanat',  'Omurzakova',   24, 'saltanat_a@mail.kg',      '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996770211018', 'avatars/saltanat_a.jpg',  'APPLICANT'),
    ('Talant',    'Bekturov',     29, 'talant_a@mail.kg',        '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996770211019', 'avatars/talant_a.jpg',    'APPLICANT'),
    ('Ulanbek',   'Ryskulov',     32, 'ulanbek_a@mail.kg',       '$2a$10$KjfQHUUBTBVxNbAIJCluOewq8VhfdjNJpdT0fpnVa5/K9ipzSUzmG', '996770211020', 'avatars/ulanbek_a.jpg',   'APPLICANT');


-- =====================
-- 2. CATEGORIES (5 родительских + 15 дочерних)
-- =====================
INSERT INTO categories (name, parent_id) VALUES
    ('IT',              null),
    ('Логистика',       null),
    ('Образование',     null),
    ('Медицина',        null),
    ('Строительство',   null),
    ('Финансы',         null),
    ('Маркетинг',       null),
    ('Юриспруденция',   null),
    ('Туризм',          null),
    ('Агропромышленность', null);

INSERT INTO categories (name, parent_id) VALUES
    ('Backend-разработка',      (SELECT id FROM categories WHERE name = 'IT')),
    ('Frontend-разработка',     (SELECT id FROM categories WHERE name = 'IT')),
    ('DevOps / Инфраструктура', (SELECT id FROM categories WHERE name = 'IT')),
    ('Водители',                (SELECT id FROM categories WHERE name = 'Логистика')),
    ('Диспетчеры',              (SELECT id FROM categories WHERE name = 'Логистика')),
    ('Учителя',                 (SELECT id FROM categories WHERE name = 'Образование')),
    ('Репетиторы',              (SELECT id FROM categories WHERE name = 'Образование')),
    ('Врачи',                   (SELECT id FROM categories WHERE name = 'Медицина')),
    ('Медсёстры / Медбратья',   (SELECT id FROM categories WHERE name = 'Медицина')),
    ('Прорабы',                 (SELECT id FROM categories WHERE name = 'Строительство')),
    ('Инженеры-сметчики',       (SELECT id FROM categories WHERE name = 'Строительство')),
    ('Бухгалтеры',              (SELECT id FROM categories WHERE name = 'Финансы')),
    ('SMM-специалисты',         (SELECT id FROM categories WHERE name = 'Маркетинг')),
    ('Юристы',                  (SELECT id FROM categories WHERE name = 'Юриспруденция')),
    ('Гиды',                    (SELECT id FROM categories WHERE name = 'Туризм'));


-- =====================
-- 3. VACANCIES (20 работодателей × 5 вакансий = 100)
-- =====================
INSERT INTO vacancies (name, description, category_id, salary, exp_from, exp_to, is_active, author_id, created_date)
VALUES
-- Adilet (IT-компания)
('Java Backend Developer',
 'Разработка микросервисов на Spring Boot, работа с PostgreSQL и Kafka.',
 (SELECT id FROM categories WHERE name = 'Backend-разработка'),
 120000.00, 2, 5, true,
 (SELECT id FROM users WHERE email = 'adilet@techcorp.kg'), '2026-01-10'),

('React Frontend Developer',
 'Разработка UI на React + TypeScript, интеграция с REST API.',
 (SELECT id FROM categories WHERE name = 'Frontend-разработка'),
 100000.00, 1, 4, true,
 (SELECT id FROM users WHERE email = 'adilet@techcorp.kg'), '2026-01-12'),

('DevOps Engineer',
 'Настройка CI/CD, управление Kubernetes-кластерами, мониторинг.',
 (SELECT id FROM categories WHERE name = 'DevOps / Инфраструктура'),
 130000.00, 3, 7, true,
 (SELECT id FROM users WHERE email = 'adilet@techcorp.kg'), '2026-01-14'),

('Python Backend Developer',
 'Разработка API на FastAPI/Django, работа с Redis и Celery.',
 (SELECT id FROM categories WHERE name = 'Backend-разработка'),
 115000.00, 2, 6, true,
 (SELECT id FROM users WHERE email = 'adilet@techcorp.kg'), '2026-01-15'),

('QA Engineer',
 'Ручное и автоматизированное тестирование, написание тест-кейсов.',
 (SELECT id FROM categories WHERE name = 'IT'),
 90000.00, 1, 4, true,
 (SELECT id FROM users WHERE email = 'adilet@techcorp.kg'), '2026-01-16'),

-- Bakyt (Логистика)
('Водитель-дальнобойщик',
 'Перевозка грузов по маршрутам Бишкек–Алматы–Ташкент.',
 (SELECT id FROM categories WHERE name = 'Водители'),
 60000.00, 3, 10, true,
 (SELECT id FROM users WHERE email = 'bakyt@logistic.kg'), '2026-01-15'),

('Логист-диспетчер',
 'Координация маршрутов, работа с водителями, оформление ТТН.',
 (SELECT id FROM categories WHERE name = 'Диспетчеры'),
 55000.00, 2, 7, true,
 (SELECT id FROM users WHERE email = 'bakyt@logistic.kg'), '2026-01-16'),

('Водитель категории B',
 'Городские развозки, работа с клиентами, ведение путевых листов.',
 (SELECT id FROM categories WHERE name = 'Водители'),
 45000.00, 1, 5, true,
 (SELECT id FROM users WHERE email = 'bakyt@logistic.kg'), '2026-01-17'),

('Старший диспетчер',
 'Управление командой диспетчеров, оптимизация маршрутов.',
 (SELECT id FROM categories WHERE name = 'Диспетчеры'),
 70000.00, 4, 10, true,
 (SELECT id FROM users WHERE email = 'bakyt@logistic.kg'), '2026-01-18'),

('Менеджер по логистике',
 'Планирование цепочек поставок, работа с поставщиками.',
 (SELECT id FROM categories WHERE name = 'Логистика'),
 80000.00, 3, 8, true,
 (SELECT id FROM users WHERE email = 'bakyt@logistic.kg'), '2026-01-19'),

-- Cholpon (Образование)
('Учитель математики',
 'Преподавание математики в старших классах, подготовка к ОРТ.',
 (SELECT id FROM categories WHERE name = 'Учителя'),
 45000.00, 2, 10, true,
 (SELECT id FROM users WHERE email = 'cholpon@edunet.kg'), '2026-01-20'),

('Учитель английского языка',
 'Ведение уроков английского, уровень владения не ниже C1.',
 (SELECT id FROM categories WHERE name = 'Учителя'),
 50000.00, 1, 8, true,
 (SELECT id FROM users WHERE email = 'cholpon@edunet.kg'), '2026-01-21'),

('Репетитор по физике',
 'Индивидуальные занятия по физике для учеников 9–11 классов.',
 (SELECT id FROM categories WHERE name = 'Репетиторы'),
 40000.00, 1, 5, true,
 (SELECT id FROM users WHERE email = 'cholpon@edunet.kg'), '2026-01-22'),

('Учитель начальных классов',
 'Работа с детьми 1–4 классов, развивающие программы.',
 (SELECT id FROM categories WHERE name = 'Учителя'),
 42000.00, 1, 7, true,
 (SELECT id FROM users WHERE email = 'cholpon@edunet.kg'), '2026-01-23'),

('Методист учебного центра',
 'Разработка учебных программ, контроль качества обучения.',
 (SELECT id FROM categories WHERE name = 'Образование'),
 60000.00, 3, 8, true,
 (SELECT id FROM users WHERE email = 'cholpon@edunet.kg'), '2026-01-24'),

-- Daniyar (Медицина)
('Врач-терапевт',
 'Ведение амбулаторного приёма пациентов, ведение медицинских карт.',
 (SELECT id FROM categories WHERE name = 'Врачи'),
 90000.00, 3, 15, true,
 (SELECT id FROM users WHERE email = 'daniyar@medclinic.kg'), '2026-01-25'),

('Медсестра / Медбрат',
 'Подготовка процедурного кабинета, помощь врачу на приёме.',
 (SELECT id FROM categories WHERE name = 'Медсёстры / Медбратья'),
 40000.00, 1, 5, true,
 (SELECT id FROM users WHERE email = 'daniyar@medclinic.kg'), '2026-01-25'),

('Врач-педиатр',
 'Приём детей до 14 лет, профилактические осмотры.',
 (SELECT id FROM categories WHERE name = 'Врачи'),
 95000.00, 3, 12, true,
 (SELECT id FROM users WHERE email = 'daniyar@medclinic.kg'), '2026-01-26'),

('Старшая медсестра',
 'Управление сестринским персоналом, контроль процедур.',
 (SELECT id FROM categories WHERE name = 'Медсёстры / Медбратья'),
 55000.00, 3, 10, true,
 (SELECT id FROM users WHERE email = 'daniyar@medclinic.kg'), '2026-01-27'),

('Врач-невролог',
 'Диагностика и лечение неврологических заболеваний.',
 (SELECT id FROM categories WHERE name = 'Врачи'),
 100000.00, 5, 15, true,
 (SELECT id FROM users WHERE email = 'daniyar@medclinic.kg'), '2026-01-28'),

-- Elmira (Строительство)
('Прораб строительных работ',
 'Контроль качества строительства жилых домов, работа с подрядчиками.',
 (SELECT id FROM categories WHERE name = 'Прорабы'),
 80000.00, 5, 15, true,
 (SELECT id FROM users WHERE email = 'elmira@buildpro.kg'), '2026-02-01'),

('Инженер-сметчик',
 'Составление смет, работа в программе Гранд-смета.',
 (SELECT id FROM categories WHERE name = 'Инженеры-сметчики'),
 70000.00, 2, 8, true,
 (SELECT id FROM users WHERE email = 'elmira@buildpro.kg'), '2026-02-02'),

('Архитектор',
 'Проектирование жилых и коммерческих объектов, работа в AutoCAD.',
 (SELECT id FROM categories WHERE name = 'Строительство'),
 90000.00, 3, 10, true,
 (SELECT id FROM users WHERE email = 'elmira@buildpro.kg'), '2026-02-03'),

('Мастер отделочных работ',
 'Выполнение отделочных работ: штукатурка, покраска, укладка плитки.',
 (SELECT id FROM categories WHERE name = 'Строительство'),
 55000.00, 2, 8, true,
 (SELECT id FROM users WHERE email = 'elmira@buildpro.kg'), '2026-02-04'),

('Инженер по охране труда',
 'Контроль соблюдения норм безопасности на строительных объектах.',
 (SELECT id FROM categories WHERE name = 'Строительство'),
 65000.00, 2, 7, true,
 (SELECT id FROM users WHERE email = 'elmira@buildpro.kg'), '2026-02-05'),

-- Farukh (Финансы)
('Бухгалтер',
 'Ведение бухгалтерского учёта, подготовка отчётности.',
 (SELECT id FROM categories WHERE name = 'Бухгалтеры'),
 65000.00, 2, 8, true,
 (SELECT id FROM users WHERE email = 'farukh@fintech.kg'), '2026-02-06'),

('Финансовый аналитик',
 'Анализ финансовых показателей, построение моделей в Excel.',
 (SELECT id FROM categories WHERE name = 'Финансы'),
 85000.00, 2, 7, true,
 (SELECT id FROM users WHERE email = 'farukh@fintech.kg'), '2026-02-07'),

('Главный бухгалтер',
 'Руководство бухгалтерией, налоговая отчётность, аудит.',
 (SELECT id FROM categories WHERE name = 'Бухгалтеры'),
 100000.00, 5, 15, true,
 (SELECT id FROM users WHERE email = 'farukh@fintech.kg'), '2026-02-08'),

('Кредитный специалист',
 'Оценка кредитоспособности клиентов, оформление кредитов.',
 (SELECT id FROM categories WHERE name = 'Финансы'),
 70000.00, 1, 5, true,
 (SELECT id FROM users WHERE email = 'farukh@fintech.kg'), '2026-02-09'),

('Налоговый консультант',
 'Консультирование по вопросам налогообложения, оптимизация налогов.',
 (SELECT id FROM categories WHERE name = 'Финансы'),
 90000.00, 3, 10, true,
 (SELECT id FROM users WHERE email = 'farukh@fintech.kg'), '2026-02-10'),

-- Gulzat (Маркетинг)
('SMM-специалист',
 'Ведение социальных сетей, создание контента, таргетированная реклама.',
 (SELECT id FROM categories WHERE name = 'SMM-специалисты'),
 55000.00, 1, 4, true,
 (SELECT id FROM users WHERE email = 'gulzat@retailplus.kg'), '2026-02-11'),

('Маркетолог',
 'Разработка маркетинговых стратегий, анализ рынка.',
 (SELECT id FROM categories WHERE name = 'Маркетинг'),
 70000.00, 2, 7, true,
 (SELECT id FROM users WHERE email = 'gulzat@retailplus.kg'), '2026-02-12'),

('Контент-менеджер',
 'Создание и публикация контента, работа с CMS.',
 (SELECT id FROM categories WHERE name = 'Маркетинг'),
 50000.00, 1, 4, true,
 (SELECT id FROM users WHERE email = 'gulzat@retailplus.kg'), '2026-02-13'),

('Бренд-менеджер',
 'Управление брендом, разработка рекламных кампаний.',
 (SELECT id FROM categories WHERE name = 'Маркетинг'),
 80000.00, 3, 8, true,
 (SELECT id FROM users WHERE email = 'gulzat@retailplus.kg'), '2026-02-14'),

('Специалист по рекламе',
 'Настройка контекстной рекламы Google Ads и Яндекс.Директ.',
 (SELECT id FROM categories WHERE name = 'Маркетинг'),
 65000.00, 1, 5, true,
 (SELECT id FROM users WHERE email = 'gulzat@retailplus.kg'), '2026-02-15'),

-- Hamza (Агро)
('Агроном',
 'Планирование и контроль сельскохозяйственных работ.',
 (SELECT id FROM categories WHERE name = 'Агропромышленность'),
 55000.00, 2, 8, true,
 (SELECT id FROM users WHERE email = 'hamza@agro.kg'), '2026-02-16'),

('Водитель сельхозтехники',
 'Управление тракторами и комбайнами, техническое обслуживание.',
 (SELECT id FROM categories WHERE name = 'Водители'),
 50000.00, 1, 7, true,
 (SELECT id FROM users WHERE email = 'hamza@agro.kg'), '2026-02-17'),

('Зоотехник',
 'Уход за животными, контроль кормления и здоровья поголовья.',
 (SELECT id FROM categories WHERE name = 'Агропромышленность'),
 48000.00, 2, 8, true,
 (SELECT id FROM users WHERE email = 'hamza@agro.kg'), '2026-02-18'),

('Ветеринарный врач',
 'Лечение и профилактика заболеваний сельскохозяйственных животных.',
 (SELECT id FROM categories WHERE name = 'Медицина'),
 65000.00, 2, 8, true,
 (SELECT id FROM users WHERE email = 'hamza@agro.kg'), '2026-02-19'),

('Менеджер по продажам агропродукции',
 'Реализация сельскохозяйственной продукции, работа с оптовыми клиентами.',
 (SELECT id FROM categories WHERE name = 'Агропромышленность'),
 60000.00, 1, 5, true,
 (SELECT id FROM users WHERE email = 'hamza@agro.kg'), '2026-02-20'),

-- Irina (Юриспруденция)
('Юрист',
 'Правовое сопровождение сделок, составление договоров.',
 (SELECT id FROM categories WHERE name = 'Юристы'),
 80000.00, 2, 8, true,
 (SELECT id FROM users WHERE email = 'irina@lawfirm.kg'), '2026-02-21'),

('Помощник юриста',
 'Подготовка документов, работа с судебными делами.',
 (SELECT id FROM categories WHERE name = 'Юристы'),
 50000.00, 0, 3, true,
 (SELECT id FROM users WHERE email = 'irina@lawfirm.kg'), '2026-02-22'),

('Корпоративный юрист',
 'Юридическое сопровождение корпоративных процедур.',
 (SELECT id FROM categories WHERE name = 'Юристы'),
 95000.00, 3, 10, true,
 (SELECT id FROM users WHERE email = 'irina@lawfirm.kg'), '2026-02-23'),

('Юрист по трудовым спорам',
 'Ведение трудовых споров, консультирование сотрудников.',
 (SELECT id FROM categories WHERE name = 'Юристы'),
 85000.00, 2, 8, true,
 (SELECT id FROM users WHERE email = 'irina@lawfirm.kg'), '2026-02-24'),

('Нотариус',
 'Нотариальное удостоверение сделок и документов.',
 (SELECT id FROM categories WHERE name = 'Юриспруденция'),
 110000.00, 5, 15, true,
 (SELECT id FROM users WHERE email = 'irina@lawfirm.kg'), '2026-02-25'),

-- Jyldyz (Туризм)
('Гид-переводчик',
 'Проведение экскурсий на русском и английском языках.',
 (SELECT id FROM categories WHERE name = 'Гиды'),
 45000.00, 1, 5, true,
 (SELECT id FROM users WHERE email = 'jyldyz@tourism.kg'), '2026-02-26'),

('Менеджер по туризму',
 'Продажа туров, работа с клиентами, бронирование отелей.',
 (SELECT id FROM categories WHERE name = 'Туризм'),
 55000.00, 1, 5, true,
 (SELECT id FROM users WHERE email = 'jyldyz@tourism.kg'), '2026-02-27'),

('Горный гид',
 'Сопровождение туристов в горных походах, знание маршрутов Тянь-Шаня.',
 (SELECT id FROM categories WHERE name = 'Гиды'),
 50000.00, 2, 8, true,
 (SELECT id FROM users WHERE email = 'jyldyz@tourism.kg'), '2026-02-28'),

('Администратор гостиницы',
 'Приём и размещение гостей, работа с системой бронирования.',
 (SELECT id FROM categories WHERE name = 'Туризм'),
 40000.00, 1, 4, true,
 (SELECT id FROM users WHERE email = 'jyldyz@tourism.kg'), '2026-03-01'),

('Специалист по въездному туризму',
 'Организация туров для иностранных туристов, визовая поддержка.',
 (SELECT id FROM categories WHERE name = 'Туризм'),
 60000.00, 2, 7, true,
 (SELECT id FROM users WHERE email = 'jyldyz@tourism.kg'), '2026-03-02'),

-- Kanat (Горнодобывающая)
('Горный инженер',
 'Проектирование горных выработок, контроль добычи.',
 (SELECT id FROM categories WHERE name = 'Строительство'),
 110000.00, 3, 10, true,
 (SELECT id FROM users WHERE email = 'kanat@mining.kg'), '2026-03-03'),

('Взрывник',
 'Проведение взрывных работ, соблюдение норм безопасности.',
 (SELECT id FROM categories WHERE name = 'Строительство'),
 95000.00, 3, 10, true,
 (SELECT id FROM users WHERE email = 'kanat@mining.kg'), '2026-03-04'),

('Геолог',
 'Геологическая разведка, отбор проб, составление отчётов.',
 (SELECT id FROM categories WHERE name = 'Строительство'),
 100000.00, 3, 10, true,
 (SELECT id FROM users WHERE email = 'kanat@mining.kg'), '2026-03-05'),

('Оператор горной техники',
 'Управление экскаваторами и бульдозерами на горных объектах.',
 (SELECT id FROM categories WHERE name = 'Строительство'),
 80000.00, 2, 8, true,
 (SELECT id FROM users WHERE email = 'kanat@mining.kg'), '2026-03-06'),

('Инженер по безопасности',
 'Контроль соблюдения правил безопасности на горных объектах.',
 (SELECT id FROM categories WHERE name = 'Строительство'),
 90000.00, 3, 10, true,
 (SELECT id FROM users WHERE email = 'kanat@mining.kg'), '2026-03-07'),

-- Larisa (Медиа)
('Журналист',
 'Написание статей, интервью, репортажи для онлайн-издания.',
 (SELECT id FROM categories WHERE name = 'Маркетинг'),
 50000.00, 1, 5, true,
 (SELECT id FROM users WHERE email = 'larisa@media.kg'), '2026-03-08'),

('Видеооператор',
 'Съёмка и монтаж видеоматериалов, работа с Adobe Premiere.',
 (SELECT id FROM categories WHERE name = 'Маркетинг'),
 60000.00, 1, 5, true,
 (SELECT id FROM users WHERE email = 'larisa@media.kg'), '2026-03-09'),

('Редактор',
 'Редактирование текстов, работа с авторами, вычитка материалов.',
 (SELECT id FROM categories WHERE name = 'Маркетинг'),
 55000.00, 2, 7, true,
 (SELECT id FROM users WHERE email = 'larisa@media.kg'), '2026-03-10'),

('Фотограф',
 'Фотосъёмка мероприятий, обработка фото в Lightroom/Photoshop.',
 (SELECT id FROM categories WHERE name = 'Маркетинг'),
 50000.00, 1, 5, true,
 (SELECT id FROM users WHERE email = 'larisa@media.kg'), '2026-03-11'),

('Главный редактор',
 'Управление редакцией, формирование редакционной политики.',
 (SELECT id FROM categories WHERE name = 'Маркетинг'),
 90000.00, 5, 12, true,
 (SELECT id FROM users WHERE email = 'larisa@media.kg'), '2026-03-12'),

-- Marat (Энергетика)
('Электрик',
 'Монтаж и обслуживание электрооборудования.',
 (SELECT id FROM categories WHERE name = 'Строительство'),
 60000.00, 2, 8, true,
 (SELECT id FROM users WHERE email = 'marat@energy.kg'), '2026-03-13'),

('Инженер-энергетик',
 'Проектирование энергосистем, расчёт нагрузок.',
 (SELECT id FROM categories WHERE name = 'Строительство'),
 85000.00, 3, 10, true,
 (SELECT id FROM users WHERE email = 'marat@energy.kg'), '2026-03-14'),

('Оператор котельной',
 'Обслуживание котельного оборудования, контроль параметров.',
 (SELECT id FROM categories WHERE name = 'Строительство'),
 50000.00, 1, 5, true,
 (SELECT id FROM users WHERE email = 'marat@energy.kg'), '2026-03-15'),

('Монтажник электрооборудования',
 'Монтаж кабельных трасс, щитового оборудования.',
 (SELECT id FROM categories WHERE name = 'Строительство'),
 55000.00, 1, 5, true,
 (SELECT id FROM users WHERE email = 'marat@energy.kg'), '2026-03-16'),

('Главный энергетик',
 'Управление энергохозяйством предприятия, оптимизация потребления.',
 (SELECT id FROM categories WHERE name = 'Строительство'),
 100000.00, 5, 15, true,
 (SELECT id FROM users WHERE email = 'marat@energy.kg'), '2026-03-17'),

-- Nurgul (Фармацевтика)
('Фармацевт',
 'Отпуск лекарственных препаратов, консультирование покупателей.',
 (SELECT id FROM categories WHERE name = 'Медицина'),
 55000.00, 1, 5, true,
 (SELECT id FROM users WHERE email = 'nurgul@pharma.kg'), '2026-03-18'),

('Провизор',
 'Управление аптекой, контроль запасов, работа с поставщиками.',
 (SELECT id FROM categories WHERE name = 'Медицина'),
 70000.00, 3, 10, true,
 (SELECT id FROM users WHERE email = 'nurgul@pharma.kg'), '2026-03-19'),

('Медицинский представитель',
 'Продвижение препаратов среди врачей и аптек.',
 (SELECT id FROM categories WHERE name = 'Медицина'),
 75000.00, 1, 5, true,
 (SELECT id FROM users WHERE email = 'nurgul@pharma.kg'), '2026-03-20'),

('Лаборант',
 'Проведение лабораторных анализов, работа с оборудованием.',
 (SELECT id FROM categories WHERE name = 'Медицина'),
 45000.00, 1, 5, true,
 (SELECT id FROM users WHERE email = 'nurgul@pharma.kg'), '2026-03-21'),

('Заведующий аптекой',
 'Управление аптечным пунктом, контроль персонала и ассортимента.',
 (SELECT id FROM categories WHERE name = 'Медицина'),
 85000.00, 4, 12, true,
 (SELECT id FROM users WHERE email = 'nurgul@pharma.kg'), '2026-03-22'),

-- Osmon (Безопасность)
('Охранник',
 'Охрана объекта, контроль пропускного режима.',
 (SELECT id FROM categories WHERE name = 'IT'),
 35000.00, 0, 3, true,
 (SELECT id FROM users WHERE email = 'osmon@security.kg'), '2026-03-23'),

('Начальник охраны',
 'Управление службой охраны, разработка инструкций.',
 (SELECT id FROM categories WHERE name = 'IT'),
 65000.00, 3, 10, true,
 (SELECT id FROM users WHERE email = 'osmon@security.kg'), '2026-03-24'),

('Специалист по информационной безопасности',
 'Защита информационных систем, аудит безопасности.',
 (SELECT id FROM categories WHERE name = 'IT'),
 100000.00, 3, 8, true,
 (SELECT id FROM users WHERE email = 'osmon@security.kg'), '2026-03-25'),

('Инспектор по безопасности',
 'Проверка соблюдения норм безопасности на объектах.',
 (SELECT id FROM categories WHERE name = 'IT'),
 55000.00, 2, 7, true,
 (SELECT id FROM users WHERE email = 'osmon@security.kg'), '2026-03-26'),

('Кинолог',
 'Работа со служебными собаками, охрана периметра.',
 (SELECT id FROM categories WHERE name = 'IT'),
 45000.00, 1, 5, true,
 (SELECT id FROM users WHERE email = 'osmon@security.kg'), '2026-03-27'),

-- Perizat (Дизайн)
('Графический дизайнер',
 'Создание визуальных материалов, работа в Adobe Illustrator/Photoshop.',
 (SELECT id FROM categories WHERE name = 'Маркетинг'),
 60000.00, 1, 5, true,
 (SELECT id FROM users WHERE email = 'perizat@design.kg'), '2026-03-28'),

('UX/UI дизайнер',
 'Проектирование интерфейсов, прототипирование в Figma.',
 (SELECT id FROM categories WHERE name = 'IT'),
 85000.00, 2, 6, true,
 (SELECT id FROM users WHERE email = 'perizat@design.kg'), '2026-03-29'),

('Веб-дизайнер',
 'Дизайн сайтов и лендингов, базовые знания HTML/CSS.',
 (SELECT id FROM categories WHERE name = 'IT'),
 70000.00, 1, 5, true,
 (SELECT id FROM users WHERE email = 'perizat@design.kg'), '2026-03-30'),

('Арт-директор',
 'Руководство дизайн-командой, формирование визуального стиля.',
 (SELECT id FROM categories WHERE name = 'Маркетинг'),
 100000.00, 4, 10, true,
 (SELECT id FROM users WHERE email = 'perizat@design.kg'), '2026-03-31'),

('Иллюстратор',
 'Создание иллюстраций для книг, рекламы и цифровых продуктов.',
 (SELECT id FROM categories WHERE name = 'Маркетинг'),
 55000.00, 1, 5, true,
 (SELECT id FROM users WHERE email = 'perizat@design.kg'), '2026-04-01'),

-- Ruslan (Транспорт)
('Водитель автобуса',
 'Перевозка пассажиров по городским маршрутам.',
 (SELECT id FROM categories WHERE name = 'Водители'),
 40000.00, 2, 10, true,
 (SELECT id FROM users WHERE email = 'ruslan@transport.kg'), '2026-04-02'),

('Механик',
 'Техническое обслуживание и ремонт транспортных средств.',
 (SELECT id FROM categories WHERE name = 'Строительство'),
 55000.00, 2, 8, true,
 (SELECT id FROM users WHERE email = 'ruslan@transport.kg'), '2026-04-03'),

('Диспетчер автопарка',
 'Координация выхода транспорта, ведение путевых листов.',
 (SELECT id FROM categories WHERE name = 'Диспетчеры'),
 45000.00, 1, 5, true,
 (SELECT id FROM users WHERE email = 'ruslan@transport.kg'), '2026-04-04'),

('Водитель такси',
 'Перевозка пассажиров, работа в приложении.',
 (SELECT id FROM categories WHERE name = 'Водители'),
 35000.00, 1, 5, true,
 (SELECT id FROM users WHERE email = 'ruslan@transport.kg'), '2026-04-05'),

('Начальник автоколонны',
 'Управление автопарком, контроль технического состояния.',
 (SELECT id FROM categories WHERE name = 'Логистика'),
 75000.00, 4, 12, true,
 (SELECT id FROM users WHERE email = 'ruslan@transport.kg'), '2026-04-06'),

-- Saltanat (Общепит)
('Повар',
 'Приготовление блюд кыргызской и европейской кухни.',
 (SELECT id FROM categories WHERE name = 'Агропромышленность'),
 45000.00, 1, 7, true,
 (SELECT id FROM users WHERE email = 'saltanat@food.kg'), '2026-04-07'),

('Шеф-повар',
 'Управление кухней, разработка меню, контроль качества.',
 (SELECT id FROM categories WHERE name = 'Агропромышленность'),
 80000.00, 4, 12, true,
 (SELECT id FROM users WHERE email = 'saltanat@food.kg'), '2026-04-07'),

('Официант',
 'Обслуживание гостей, приём заказов, работа с кассой.',
 (SELECT id FROM categories WHERE name = 'Агропромышленность'),
 30000.00, 0, 3, true,
 (SELECT id FROM users WHERE email = 'saltanat@food.kg'), '2026-04-07'),

('Администратор ресторана',
 'Управление залом, работа с персоналом, контроль сервиса.',
 (SELECT id FROM categories WHERE name = 'Агропромышленность'),
 55000.00, 2, 7, true,
 (SELECT id FROM users WHERE email = 'saltanat@food.kg'), '2026-04-07'),

('Кондитер',
 'Приготовление тортов, пирожных и десертов.',
 (SELECT id FROM categories WHERE name = 'Агропромышленность'),
 40000.00, 1, 5, true,
 (SELECT id FROM users WHERE email = 'saltanat@food.kg'), '2026-04-07'),

-- Talant (Консалтинг)
('Бизнес-аналитик',
 'Анализ бизнес-процессов, разработка рекомендаций.',
 (SELECT id FROM categories WHERE name = 'Финансы'),
 90000.00, 2, 7, true,
 (SELECT id FROM users WHERE email = 'talant@consulting.kg'), '2026-04-08'),

('Консультант по управлению',
 'Оптимизация организационных структур, стратегическое планирование.',
 (SELECT id FROM categories WHERE name = 'Финансы'),
 100000.00, 3, 10, true,
 (SELECT id FROM users WHERE email = 'talant@consulting.kg'), '2026-04-08'),

('HR-менеджер',
 'Подбор персонала, адаптация, кадровое делопроизводство.',
 (SELECT id FROM categories WHERE name = 'Маркетинг'),
 65000.00, 2, 7, true,
 (SELECT id FROM users WHERE email = 'talant@consulting.kg'), '2026-04-08'),

('Тренер по продажам',
 'Проведение тренингов, разработка обучающих программ.',
 (SELECT id FROM categories WHERE name = 'Маркетинг'),
 75000.00, 3, 8, true,
 (SELECT id FROM users WHERE email = 'talant@consulting.kg'), '2026-04-08'),

('Проектный менеджер',
 'Управление проектами, работа с командой, контроль сроков.',
 (SELECT id FROM categories WHERE name = 'IT'),
 95000.00, 3, 10, true,
 (SELECT id FROM users WHERE email = 'talant@consulting.kg'), '2026-04-08'),

-- Ulanbek (Недвижимость)
('Риелтор',
 'Продажа и аренда недвижимости, работа с клиентами.',
 (SELECT id FROM categories WHERE name = 'Финансы'),
 60000.00, 1, 5, true,
 (SELECT id FROM users WHERE email = 'ulanbek@realestate.kg'), '2026-04-09'),

('Оценщик недвижимости',
 'Оценка рыночной стоимости объектов недвижимости.',
 (SELECT id FROM categories WHERE name = 'Финансы'),
 75000.00, 2, 8, true,
 (SELECT id FROM users WHERE email = 'ulanbek@realestate.kg'), '2026-04-09'),

('Менеджер по аренде',
 'Управление арендным портфелем, работа с арендаторами.',
 (SELECT id FROM categories WHERE name = 'Финансы'),
 65000.00, 1, 5, true,
 (SELECT id FROM users WHERE email = 'ulanbek@realestate.kg'), '2026-04-09'),

('Юрист по недвижимости',
 'Сопровождение сделок с недвижимостью, проверка документов.',
 (SELECT id FROM categories WHERE name = 'Юристы'),
 85000.00, 2, 8, true,
 (SELECT id FROM users WHERE email = 'ulanbek@realestate.kg'), '2026-04-09'),

('Директор агентства недвижимости',
 'Управление агентством, развитие бизнеса, работа с VIP-клиентами.',
 (SELECT id FROM categories WHERE name = 'Финансы'),
 120000.00, 5, 15, true,
 (SELECT id FROM users WHERE email = 'ulanbek@realestate.kg'), '2026-04-09');


-- =====================
-- 4. RESUMES (20 соискателей × 3 резюме = 60)
-- =====================
INSERT INTO resumes (applicant_id, name, category_id, salary, is_active, created_date)
VALUES
-- Ainura (IT)
((SELECT id FROM users WHERE email = 'ainura@mail.kg'),    'Ainura — Java Developer',          (SELECT id FROM categories WHERE name = 'Backend-разработка'),      110000.00, true, '2026-01-20'),
((SELECT id FROM users WHERE email = 'ainura@mail.kg'),    'Ainura — Python Developer',        (SELECT id FROM categories WHERE name = 'Backend-разработка'),      105000.00, true, '2026-01-21'),
((SELECT id FROM users WHERE email = 'ainura@mail.kg'),    'Ainura — QA Engineer',             (SELECT id FROM categories WHERE name = 'IT'),                        85000.00, true, '2026-01-22'),

-- Bekzat (IT)
((SELECT id FROM users WHERE email = 'bekzat@mail.kg'),    'Bekzat — React Developer',         (SELECT id FROM categories WHERE name = 'Frontend-разработка'),       95000.00, true, '2026-01-22'),
((SELECT id FROM users WHERE email = 'bekzat@mail.kg'),    'Bekzat — Frontend Engineer',       (SELECT id FROM categories WHERE name = 'Frontend-разработка'),       90000.00, true, '2026-01-23'),
((SELECT id FROM users WHERE email = 'bekzat@mail.kg'),    'Bekzat — UX/UI Designer',          (SELECT id FROM categories WHERE name = 'IT'),                        80000.00, true, '2026-01-24'),

-- Cholponai (Логистика)
((SELECT id FROM users WHERE email = 'cholponai@mail.kg'), 'Cholponai — Водитель CE',          (SELECT id FROM categories WHERE name = 'Водители'),                  58000.00, true, '2026-01-24'),
((SELECT id FROM users WHERE email = 'cholponai@mail.kg'), 'Cholponai — Водитель B',           (SELECT id FROM categories WHERE name = 'Водители'),                  43000.00, true, '2026-01-25'),
((SELECT id FROM users WHERE email = 'cholponai@mail.kg'), 'Cholponai — Диспетчер',            (SELECT id FROM categories WHERE name = 'Диспетчеры'),                50000.00, true, '2026-01-26'),

-- Dastan (Логистика)
((SELECT id FROM users WHERE email = 'dastan@mail.kg'),    'Dastan — Логист',                  (SELECT id FROM categories WHERE name = 'Диспетчеры'),                52000.00, true, '2026-01-26'),
((SELECT id FROM users WHERE email = 'dastan@mail.kg'),    'Dastan — Старший диспетчер',       (SELECT id FROM categories WHERE name = 'Диспетчеры'),                65000.00, true, '2026-01-27'),
((SELECT id FROM users WHERE email = 'dastan@mail.kg'),    'Dastan — Менеджер по логистике',   (SELECT id FROM categories WHERE name = 'Логистика'),                 75000.00, true, '2026-01-28'),

-- Eliza (Образование)
((SELECT id FROM users WHERE email = 'eliza@mail.kg'),     'Eliza — Учитель математики',       (SELECT id FROM categories WHERE name = 'Учителя'),                   44000.00, true, '2026-01-28'),
((SELECT id FROM users WHERE email = 'eliza@mail.kg'),     'Eliza — Репетитор по физике',      (SELECT id FROM categories WHERE name = 'Репетиторы'),                38000.00, true, '2026-01-29'),
((SELECT id FROM users WHERE email = 'eliza@mail.kg'),     'Eliza — Методист',                 (SELECT id FROM categories WHERE name = 'Образование'),               55000.00, true, '2026-01-30'),

-- Farida (Образование)
((SELECT id FROM users WHERE email = 'farida@mail.kg'),    'Farida — Учитель английского',     (SELECT id FROM categories WHERE name = 'Учителя'),                   48000.00, true, '2026-02-01'),
((SELECT id FROM users WHERE email = 'farida@mail.kg'),    'Farida — Учитель нач. классов',    (SELECT id FROM categories WHERE name = 'Учителя'),                   40000.00, true, '2026-02-02'),
((SELECT id FROM users WHERE email = 'farida@mail.kg'),    'Farida — Репетитор',               (SELECT id FROM categories WHERE name = 'Репетиторы'),                35000.00, true, '2026-02-03'),

-- Gulnara (Медицина)
((SELECT id FROM users WHERE email = 'gulnara@mail.kg'),   'Gulnara — Врач-терапевт',          (SELECT id FROM categories WHERE name = 'Врачи'),                     88000.00, true, '2026-02-03'),
((SELECT id FROM users WHERE email = 'gulnara@mail.kg'),   'Gulnara — Врач-педиатр',           (SELECT id FROM categories WHERE name = 'Врачи'),                     90000.00, true, '2026-02-04'),
((SELECT id FROM users WHERE email = 'gulnara@mail.kg'),   'Gulnara — Семейный врач',          (SELECT id FROM categories WHERE name = 'Врачи'),                     85000.00, true, '2026-02-05'),

-- Hamid (Медицина)
((SELECT id FROM users WHERE email = 'hamid@mail.kg'),     'Hamid — Медбрат',                  (SELECT id FROM categories WHERE name = 'Медсёстры / Медбратья'),     38000.00, true, '2026-02-05'),
((SELECT id FROM users WHERE email = 'hamid@mail.kg'),     'Hamid — Старший медбрат',          (SELECT id FROM categories WHERE name = 'Медсёстры / Медбратья'),     50000.00, true, '2026-02-06'),
((SELECT id FROM users WHERE email = 'hamid@mail.kg'),     'Hamid — Фармацевт',                (SELECT id FROM categories WHERE name = 'Медицина'),                  52000.00, true, '2026-02-07'),

-- Iskender (Строительство)
((SELECT id FROM users WHERE email = 'iskender@mail.kg'),  'Iskender — Прораб',                (SELECT id FROM categories WHERE name = 'Прорабы'),                   78000.00, true, '2026-02-07'),
((SELECT id FROM users WHERE email = 'iskender@mail.kg'),  'Iskender — Инженер-сметчик',       (SELECT id FROM categories WHERE name = 'Инженеры-сметчики'),          65000.00, true, '2026-02-08'),
((SELECT id FROM users WHERE email = 'iskender@mail.kg'),  'Iskender — Инженер по ОТ',         (SELECT id FROM categories WHERE name = 'Строительство'),              60000.00, true, '2026-02-09'),

-- Janara (Финансы)
((SELECT id FROM users WHERE email = 'janara@mail.kg'),    'Janara — Бухгалтер',               (SELECT id FROM categories WHERE name = 'Бухгалтеры'),                62000.00, true, '2026-02-10'),
((SELECT id FROM users WHERE email = 'janara@mail.kg'),    'Janara — Финансовый аналитик',     (SELECT id FROM categories WHERE name = 'Финансы'),                   80000.00, true, '2026-02-11'),
((SELECT id FROM users WHERE email = 'janara@mail.kg'),    'Janara — Кредитный специалист',    (SELECT id FROM categories WHERE name = 'Финансы'),                   65000.00, true, '2026-02-12'),

-- Kuban (Маркетинг)
((SELECT id FROM users WHERE email = 'kuban@mail.kg'),     'Kuban — SMM-специалист',           (SELECT id FROM categories WHERE name = 'SMM-специалисты'),            52000.00, true, '2026-02-12'),
((SELECT id FROM users WHERE email = 'kuban@mail.kg'),     'Kuban — Маркетолог',               (SELECT id FROM categories WHERE name = 'Маркетинг'),                 65000.00, true, '2026-02-13'),
((SELECT id FROM users WHERE email = 'kuban@mail.kg'),     'Kuban — Контент-менеджер',         (SELECT id FROM categories WHERE name = 'Маркетинг'),                 48000.00, true, '2026-02-14'),

-- Lira (Юриспруденция)
((SELECT id FROM users WHERE email = 'lira@mail.kg'),      'Lira — Юрист',                     (SELECT id FROM categories WHERE name = 'Юристы'),                    78000.00, true, '2026-02-14'),
((SELECT id FROM users WHERE email = 'lira@mail.kg'),      'Lira — Корпоративный юрист',       (SELECT id FROM categories WHERE name = 'Юристы'),                    90000.00, true, '2026-02-15'),
((SELECT id FROM users WHERE email = 'lira@mail.kg'),      'Lira — Юрист по трудовым спорам',  (SELECT id FROM categories WHERE name = 'Юристы'),                    82000.00, true, '2026-02-16'),

-- Manas (Туризм)
((SELECT id FROM users WHERE email = 'manas@mail.kg'),     'Manas — Гид-переводчик',           (SELECT id FROM categories WHERE name = 'Гиды'),                      43000.00, true, '2026-02-16'),
((SELECT id FROM users WHERE email = 'manas@mail.kg'),     'Manas — Горный гид',               (SELECT id FROM categories WHERE name = 'Гиды'),                      48000.00, true, '2026-02-17'),
((SELECT id FROM users WHERE email = 'manas@mail.kg'),     'Manas — Менеджер по туризму',      (SELECT id FROM categories WHERE name = 'Туризм'),                    52000.00, true, '2026-02-18'),

-- Nurzat (IT)
((SELECT id FROM users WHERE email = 'nurzat@mail.kg'),    'Nurzat — DevOps Engineer',         (SELECT id FROM categories WHERE name = 'DevOps / Инфраструктура'),   125000.00, true, '2026-02-18'),
((SELECT id FROM users WHERE email = 'nurzat@mail.kg'),    'Nurzat — Backend Developer',       (SELECT id FROM categories WHERE name = 'Backend-разработка'),        110000.00, true, '2026-02-19'),
((SELECT id FROM users WHERE email = 'nurzat@mail.kg'),    'Nurzat — Специалист по ИБ',        (SELECT id FROM categories WHERE name = 'IT'),                        95000.00, true, '2026-02-20'),

-- Omurbek (Маркетинг/Дизайн)
((SELECT id FROM users WHERE email = 'omurbek@mail.kg'),   'Omurbek — Графический дизайнер',   (SELECT id FROM categories WHERE name = 'Маркетинг'),                 58000.00, true, '2026-02-20'),
((SELECT id FROM users WHERE email = 'omurbek@mail.kg'),   'Omurbek — UX/UI Designer',         (SELECT id FROM categories WHERE name = 'IT'),                        80000.00, true, '2026-02-21'),
((SELECT id FROM users WHERE email = 'omurbek@mail.kg'),   'Omurbek — Веб-дизайнер',           (SELECT id FROM categories WHERE name = 'IT'),                        68000.00, true, '2026-02-22'),

-- Perizat_a (Финансы)
((SELECT id FROM users WHERE email = 'perizat_a@mail.kg'), 'Perizat — Бизнес-аналитик',        (SELECT id FROM categories WHERE name = 'Финансы'),                   85000.00, true, '2026-02-22'),
((SELECT id FROM users WHERE email = 'perizat_a@mail.kg'), 'Perizat — HR-менеджер',            (SELECT id FROM categories WHERE name = 'Маркетинг'),                 62000.00, true, '2026-02-23'),
((SELECT id FROM users WHERE email = 'perizat_a@mail.kg'), 'Perizat — Проектный менеджер',     (SELECT id FROM categories WHERE name = 'IT'),                        90000.00, true, '2026-02-24'),

-- Ruslan_a (Транспорт)
((SELECT id FROM users WHERE email = 'ruslan_a@mail.kg'),  'Ruslan — Водитель автобуса',       (SELECT id FROM categories WHERE name = 'Водители'),                  38000.00, true, '2026-02-24'),
((SELECT id FROM users WHERE email = 'ruslan_a@mail.kg'),  'Ruslan — Механик',                 (SELECT id FROM categories WHERE name = 'Строительство'),              52000.00, true, '2026-02-25'),
((SELECT id FROM users WHERE email = 'ruslan_a@mail.kg'),  'Ruslan — Диспетчер автопарка',     (SELECT id FROM categories WHERE name = 'Диспетчеры'),                43000.00, true, '2026-02-26'),

-- Saltanat_a (Общепит)
((SELECT id FROM users WHERE email = 'saltanat_a@mail.kg'),'Saltanat — Повар',                 (SELECT id FROM categories WHERE name = 'Агропромышленность'),        43000.00, true, '2026-02-26'),
((SELECT id FROM users WHERE email = 'saltanat_a@mail.kg'),'Saltanat — Кондитер',              (SELECT id FROM categories WHERE name = 'Агропромышленность'),        38000.00, true, '2026-02-27'),
((SELECT id FROM users WHERE email = 'saltanat_a@mail.kg'),'Saltanat — Администратор',         (SELECT id FROM categories WHERE name = 'Агропромышленность'),        52000.00, true, '2026-02-28'),

-- Talant_a (Консалтинг)
((SELECT id FROM users WHERE email = 'talant_a@mail.kg'),  'Talant — Консультант',             (SELECT id FROM categories WHERE name = 'Финансы'),                   95000.00, true, '2026-02-28'),
((SELECT id FROM users WHERE email = 'talant_a@mail.kg'),  'Talant — Тренер по продажам',      (SELECT id FROM categories WHERE name = 'Маркетинг'),                 72000.00, true, '2026-03-01'),
((SELECT id FROM users WHERE email = 'talant_a@mail.kg'),  'Talant — Бизнес-аналитик',         (SELECT id FROM categories WHERE name = 'Финансы'),                   88000.00, true, '2026-03-02'),

-- Ulanbek_a (Недвижимость)
((SELECT id FROM users WHERE email = 'ulanbek_a@mail.kg'), 'Ulanbek — Риелтор',                (SELECT id FROM categories WHERE name = 'Финансы'),                   58000.00, true, '2026-03-02'),
((SELECT id FROM users WHERE email = 'ulanbek_a@mail.kg'), 'Ulanbek — Оценщик недвижимости',   (SELECT id FROM categories WHERE name = 'Финансы'),                   72000.00, true, '2026-03-03'),
((SELECT id FROM users WHERE email = 'ulanbek_a@mail.kg'), 'Ulanbek — Менеджер по аренде',     (SELECT id FROM categories WHERE name = 'Финансы'),                   62000.00, true, '2026-03-04');


-- =====================
-- 5. CONTACT TYPES
-- =====================
INSERT INTO contact_types (type) VALUES
    ('Phone-number'),
    ('Telegram'),
    ('Email');


-- =====================
-- 6. CONTACTS_INFO (3 контакта на каждое резюме = 180 записей)
-- =====================
INSERT INTO contacts_info (type_id, resume_id, contact_value)
SELECT
    (SELECT id FROM contact_types WHERE type = 'Phone-number'),
    r.id,
    u.phone_number
FROM resumes r
JOIN users u ON u.id = r.applicant_id;

INSERT INTO contacts_info (type_id, resume_id, contact_value)
SELECT
    (SELECT id FROM contact_types WHERE type = 'Telegram'),
    r.id,
    '@' || LOWER(REPLACE(u.name, ' ', '_')) || '_' || LOWER(TRIM(SUBSTRING(r.name, LOCATE(' — ', r.name) + 3)))
FROM resumes r
         JOIN users u ON u.id = r.applicant_id;

INSERT INTO contacts_info (type_id, resume_id, contact_value)
SELECT
    (SELECT id FROM contact_types WHERE type = 'Email'),
    r.id,
    u.email
FROM resumes r
JOIN users u ON u.id = r.applicant_id;


-- =====================
-- 7. EDUCATION_INFO (по 1 на каждого соискателя, привязка к первому резюме)
-- =====================
INSERT INTO education_info (resume_id, institution, program, start_date, end_date, degree)
VALUES
((SELECT id FROM resumes WHERE name = 'Ainura — Java Developer'),
 'КРСУ — Кыргызско-Российский Славянский Университет', 'Информационные системы', '2018-09-01', '2022-06-30', 'Bachelor'),

((SELECT id FROM resumes WHERE name = 'Bekzat — React Developer'),
 'АУЦА — Американский Университет в Центральной Азии', 'Прикладная математика', '2017-09-01', '2021-06-30', 'Bachelor'),

((SELECT id FROM resumes WHERE name = 'Cholponai — Водитель CE'),
 'КТУ «Манас»', 'Автомобильный транспорт', '2014-09-01', '2018-06-30', 'Bachelor'),

((SELECT id FROM resumes WHERE name = 'Dastan — Логист'),
 'КНУ им. Жусупа Баласагына', 'Логистика и управление цепями поставок', '2016-09-01', '2020-06-30', 'Bachelor'),

((SELECT id FROM resumes WHERE name = 'Eliza — Учитель математики'),
 'Бишкекский Педагогический Университет', 'Математика и физика', '2015-09-01', '2019-06-30', 'Bachelor'),

((SELECT id FROM resumes WHERE name = 'Farida — Учитель английского'),
 'КРСУ', 'Лингвистика (Английский язык)', '2016-09-01', '2020-06-30', 'Bachelor'),

((SELECT id FROM resumes WHERE name = 'Gulnara — Врач-терапевт'),
 'Кыргызская Государственная Медицинская Академия', 'Лечебное дело', '2013-09-01', '2019-06-30', 'Specialist'),

((SELECT id FROM resumes WHERE name = 'Hamid — Медбрат'),
 'КГМА', 'Сестринское дело', '2017-09-01', '2021-06-30', 'Bachelor'),

((SELECT id FROM resumes WHERE name = 'Iskender — Прораб'),
 'Кыргызский Государственный Технический Университет', 'Строительство и архитектура', '2012-09-01', '2017-06-30', 'Specialist'),

((SELECT id FROM resumes WHERE name = 'Janara — Бухгалтер'),
 'КНУ им. Жусупа Баласагына', 'Финансы и кредит', '2015-09-01', '2019-06-30', 'Bachelor'),

((SELECT id FROM resumes WHERE name = 'Kuban — SMM-специалист'),
 'АУЦА', 'Медиа и коммуникации', '2016-09-01', '2020-06-30', 'Bachelor'),

((SELECT id FROM resumes WHERE name = 'Lira — Юрист'),
 'КНУ им. Жусупа Баласагына', 'Юриспруденция', '2015-09-01', '2019-06-30', 'Bachelor'),

((SELECT id FROM resumes WHERE name = 'Manas — Гид-переводчик'),
 'КРСУ', 'Туризм и гостеприимство', '2017-09-01', '2021-06-30', 'Bachelor'),

((SELECT id FROM resumes WHERE name = 'Nurzat — DevOps Engineer'),
 'КГТУ им. И. Раззакова', 'Информационные технологии', '2014-09-01', '2018-06-30', 'Bachelor'),

((SELECT id FROM resumes WHERE name = 'Omurbek — Графический дизайнер'),
 'Бишкекский Архитектурно-Строительный Институт', 'Дизайн среды', '2016-09-01', '2020-06-30', 'Bachelor'),

((SELECT id FROM resumes WHERE name = 'Perizat — Бизнес-аналитик'),
 'АУЦА', 'Бизнес-администрирование', '2015-09-01', '2019-06-30', 'Bachelor'),

((SELECT id FROM resumes WHERE name = 'Ruslan — Водитель автобуса'),
 'Бишкекский Автотранспортный Колледж', 'Техническое обслуживание автомобилей', '2013-09-01', '2016-06-30', 'Diploma'),

((SELECT id FROM resumes WHERE name = 'Saltanat — Повар'),
 'Бишкекский Технологический Колледж', 'Технология продуктов питания', '2016-09-01', '2019-06-30', 'Diploma'),

((SELECT id FROM resumes WHERE name = 'Talant — Консультант'),
 'КНУ им. Жусупа Баласагына', 'Менеджмент', '2014-09-01', '2018-06-30', 'Bachelor'),

((SELECT id FROM resumes WHERE name = 'Ulanbek — Риелтор'),
 'КРСУ', 'Экономика и управление недвижимостью', '2015-09-01', '2019-06-30', 'Bachelor');


-- =====================
-- 8. WORK_EXPERIENCE_INFO (по 1 на каждого соискателя, привязка к первому резюме)
-- =====================
INSERT INTO work_experience_info (resume_id, years, company_name, position_in_company, responsibilities)
VALUES
((SELECT id FROM resumes WHERE name = 'Ainura — Java Developer'),
 3, 'IT Solutions KG', 'Junior Java Developer',
 'Разработка REST API на Spring Boot, написание unit-тестов, code review'),

((SELECT id FROM resumes WHERE name = 'Bekzat — React Developer'),
 2, 'Digital Agency Bishkek', 'React Developer',
 'Вёрстка компонентов, интеграция с REST API, работа с Redux'),

((SELECT id FROM resumes WHERE name = 'Cholponai — Водитель CE'),
 7, 'TransKargo LLC', 'Водитель CE',
 'Международные перевозки, соблюдение режима труда и отдыха, техосмотр'),

((SELECT id FROM resumes WHERE name = 'Dastan — Логист'),
 4, 'AlphaLogist', 'Диспетчер',
 'Планирование маршрутов, координация 10+ водителей, работа с 1С'),

((SELECT id FROM resumes WHERE name = 'Eliza — Учитель математики'),
 5, 'Школа №60 г. Бишкек', 'Учитель математики',
 'Уроки 8–11 классов, подготовка к ОРТ, работа с методическими пособиями'),

((SELECT id FROM resumes WHERE name = 'Farida — Учитель английского'),
 3, 'Language Academy KG', 'Преподаватель английского',
 'Групповые и индивидуальные занятия, Cambridge-подготовка'),

((SELECT id FROM resumes WHERE name = 'Gulnara — Врач-терапевт'),
 6, 'Медицинский центр "Айболит"', 'Врач-терапевт',
 'Амбулаторный приём, постановка диагнозов, направление на обследование'),

((SELECT id FROM resumes WHERE name = 'Hamid — Медбрат'),
 2, 'Клиника "Надежда"', 'Медбрат',
 'Работа в процедурном кабинете, забор анализов, уход за пациентами'),

((SELECT id FROM resumes WHERE name = 'Iskender — Прораб'),
 8, 'BuildGroup KG', 'Прораб',
 'Контроль строительства 5-этажных домов, работа с подрядчиками, отчётность'),

((SELECT id FROM resumes WHERE name = 'Janara — Бухгалтер'),
 5, 'FinGroup KG', 'Бухгалтер',
 'Ведение бухгалтерского учёта, подготовка квартальной отчётности, работа в 1С'),

((SELECT id FROM resumes WHERE name = 'Kuban — SMM-специалист'),
 3, 'MediaBrand KG', 'SMM-специалист',
 'Ведение Instagram/Facebook, таргетированная реклама, аналитика'),

((SELECT id FROM resumes WHERE name = 'Lira — Юрист'),
 4, 'LawPartners KG', 'Юрист',
 'Составление договоров, правовая экспертиза, судебное представительство'),

((SELECT id FROM resumes WHERE name = 'Manas — Гид-переводчик'),
 3, 'Discover Kyrgyzstan', 'Гид-переводчик',
 'Проведение экскурсий, перевод для иностранных туристов, разработка маршрутов'),

((SELECT id FROM resumes WHERE name = 'Nurzat — DevOps Engineer'),
 5, 'CloudSystems KG', 'DevOps Engineer',
 'Настройка CI/CD на GitLab, управление Docker/Kubernetes, мониторинг Grafana'),

((SELECT id FROM resumes WHERE name = 'Omurbek — Графический дизайнер'),
 4, 'Creative Studio Bishkek', 'Графический дизайнер',
 'Разработка фирменного стиля, создание рекламных материалов, работа с клиентами'),

((SELECT id FROM resumes WHERE name = 'Perizat — Бизнес-аналитик'),
 3, 'ConsultPro KG', 'Бизнес-аналитик',
 'Анализ бизнес-процессов, написание ТЗ, работа с Jira и Confluence'),

((SELECT id FROM resumes WHERE name = 'Ruslan — Водитель автобуса'),
 6, 'Бишкекское ПАТП', 'Водитель автобуса',
 'Перевозка пассажиров, соблюдение расписания, техническое обслуживание'),

((SELECT id FROM resumes WHERE name = 'Saltanat — Повар'),
 4, 'Ресторан "Манас"', 'Повар',
 'Приготовление блюд кыргызской кухни, работа в горячем цеху, контроль качества'),

((SELECT id FROM resumes WHERE name = 'Talant — Консультант'),
 5, 'Strategy Group KG', 'Консультант по управлению',
 'Оптимизация бизнес-процессов, стратегическое планирование, обучение персонала'),

((SELECT id FROM resumes WHERE name = 'Ulanbek — Риелтор'),
 4, 'RealEstate KG', 'Риелтор',
 'Продажа и аренда жилой недвижимости, работа с клиентами, оформление сделок');


-- =====================
-- 9. RESPONDED_APPLICANTS
-- Отклики на 80 из 100 вакансий (пропускаем каждую 5-ю: 5,10,15,...,100)
-- Резюме подбираются по соответствию категории
-- =====================
INSERT INTO responded_applicants (resume_id, vacancy_id, status)
VALUES
-- Вакансии Adilet (IT)
((SELECT id FROM resumes WHERE name = 'Ainura — Java Developer'),
 (SELECT id FROM vacancies WHERE name = 'Java Backend Developer'), 'PENDING'),

((SELECT id FROM resumes WHERE name = 'Ainura — Python Developer'),
 (SELECT id FROM vacancies WHERE name = 'React Frontend Developer'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Bekzat — React Developer'),
 (SELECT id FROM vacancies WHERE name = 'React Frontend Developer'), 'PENDING'),

((SELECT id FROM resumes WHERE name = 'Bekzat — Frontend Engineer'),
 (SELECT id FROM vacancies WHERE name = 'DevOps Engineer'), 'REJECTED'),

-- QA Engineer (5-я вакансия) — пропускаем

-- Вакансии Bakyt (Логистика)
((SELECT id FROM resumes WHERE name = 'Cholponai — Водитель CE'),
 (SELECT id FROM vacancies WHERE name = 'Водитель-дальнобойщик'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Dastan — Логист'),
 (SELECT id FROM vacancies WHERE name = 'Логист-диспетчер'), 'PENDING'),

((SELECT id FROM resumes WHERE name = 'Cholponai — Водитель B'),
 (SELECT id FROM vacancies WHERE name = 'Водитель категории B'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Dastan — Старший диспетчер'),
 (SELECT id FROM vacancies WHERE name = 'Старший диспетчер'), 'PENDING'),

-- Менеджер по логистике (10-я вакансия) — пропускаем

-- Вакансии Cholpon (Образование)
((SELECT id FROM resumes WHERE name = 'Eliza — Учитель математики'),
 (SELECT id FROM vacancies WHERE name = 'Учитель математики'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Farida — Учитель английского'),
 (SELECT id FROM vacancies WHERE name = 'Учитель английского языка'), 'PENDING'),

((SELECT id FROM resumes WHERE name = 'Eliza — Репетитор по физике'),
 (SELECT id FROM vacancies WHERE name = 'Репетитор по физике'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Farida — Учитель нач. классов'),
 (SELECT id FROM vacancies WHERE name = 'Учитель начальных классов'), 'PENDING'),

-- Методист (15-я вакансия) — пропускаем

-- Вакансии Daniyar (Медицина)
((SELECT id FROM resumes WHERE name = 'Gulnara — Врач-терапевт'),
 (SELECT id FROM vacancies WHERE name = 'Врач-терапевт'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Hamid — Медбрат'),
 (SELECT id FROM vacancies WHERE name = 'Медсестра / Медбрат'), 'PENDING'),

((SELECT id FROM resumes WHERE name = 'Gulnara — Врач-педиатр'),
 (SELECT id FROM vacancies WHERE name = 'Врач-педиатр'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Hamid — Старший медбрат'),
 (SELECT id FROM vacancies WHERE name = 'Старшая медсестра'), 'REJECTED'),

-- Врач-невролог (20-я вакансия) — пропускаем

-- Вакансии Elmira (Строительство)
((SELECT id FROM resumes WHERE name = 'Iskender — Прораб'),
 (SELECT id FROM vacancies WHERE name = 'Прораб строительных работ'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Iskender — Инженер-сметчик'),
 (SELECT id FROM vacancies WHERE name = 'Инженер-сметчик'), 'PENDING'),

((SELECT id FROM resumes WHERE name = 'Iskender — Инженер по ОТ'),
 (SELECT id FROM vacancies WHERE name = 'Архитектор'), 'REJECTED'),

((SELECT id FROM resumes WHERE name = 'Ruslan — Механик'),
 (SELECT id FROM vacancies WHERE name = 'Мастер отделочных работ'), 'PENDING'),

-- Инженер по охране труда (25-я вакансия) — пропускаем

-- Вакансии Farukh (Финансы)
((SELECT id FROM resumes WHERE name = 'Janara — Бухгалтер'),
 (SELECT id FROM vacancies WHERE name = 'Бухгалтер'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Janara — Финансовый аналитик'),
 (SELECT id FROM vacancies WHERE name = 'Финансовый аналитик'), 'PENDING'),

((SELECT id FROM resumes WHERE name = 'Perizat — Бизнес-аналитик'),
 (SELECT id FROM vacancies WHERE name = 'Главный бухгалтер'), 'REJECTED'),

((SELECT id FROM resumes WHERE name = 'Janara — Кредитный специалист'),
 (SELECT id FROM vacancies WHERE name = 'Кредитный специалист'), 'ACCEPTED'),

-- Налоговый консультант (30-я вакансия) — пропускаем

-- Вакансии Gulzat (Маркетинг)
((SELECT id FROM resumes WHERE name = 'Kuban — SMM-специалист'),
 (SELECT id FROM vacancies WHERE name = 'SMM-специалист'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Kuban — Маркетолог'),
 (SELECT id FROM vacancies WHERE name = 'Маркетолог'), 'PENDING'),

((SELECT id FROM resumes WHERE name = 'Kuban — Контент-менеджер'),
 (SELECT id FROM vacancies WHERE name = 'Контент-менеджер'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Omurbek — Графический дизайнер'),
 (SELECT id FROM vacancies WHERE name = 'Бренд-менеджер'), 'PENDING'),

-- Специалист по рекламе (35-я вакансия) — пропускаем

-- Вакансии Hamza (Агро)
((SELECT id FROM resumes WHERE name = 'Saltanat — Повар'),
 (SELECT id FROM vacancies WHERE name = 'Агроном'), 'REJECTED'),

((SELECT id FROM resumes WHERE name = 'Cholponai — Водитель CE'),
 (SELECT id FROM vacancies WHERE name = 'Водитель сельхозтехники'), 'PENDING'),

((SELECT id FROM resumes WHERE name = 'Gulnara — Врач-терапевт'),
 (SELECT id FROM vacancies WHERE name = 'Ветеринарный врач'), 'REJECTED'),

((SELECT id FROM resumes WHERE name = 'Ulanbek — Риелтор'),
 (SELECT id FROM vacancies WHERE name = 'Менеджер по продажам агропродукции'), 'PENDING'),

-- Зоотехник (40-я вакансия) — пропускаем

-- Вакансии Irina (Юриспруденция)
((SELECT id FROM resumes WHERE name = 'Lira — Юрист'),
 (SELECT id FROM vacancies WHERE name = 'Юрист'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Lira — Корпоративный юрист'),
 (SELECT id FROM vacancies WHERE name = 'Помощник юриста'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Lira — Юрист по трудовым спорам'),
 (SELECT id FROM vacancies WHERE name = 'Корпоративный юрист'), 'PENDING'),

((SELECT id FROM resumes WHERE name = 'Ulanbek — Менеджер по аренде'),
 (SELECT id FROM vacancies WHERE name = 'Юрист по трудовым спорам'), 'REJECTED'),

-- Нотариус (45-я вакансия) — пропускаем

-- Вакансии Jyldyz (Туризм)
((SELECT id FROM resumes WHERE name = 'Manas — Гид-переводчик'),
 (SELECT id FROM vacancies WHERE name = 'Гид-переводчик'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Manas — Менеджер по туризму'),
 (SELECT id FROM vacancies WHERE name = 'Менеджер по туризму'), 'PENDING'),

((SELECT id FROM resumes WHERE name = 'Manas — Горный гид'),
 (SELECT id FROM vacancies WHERE name = 'Горный гид'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Ulanbek — Риелтор'),
 (SELECT id FROM vacancies WHERE name = 'Администратор гостиницы'), 'REJECTED'),

-- Специалист по въездному туризму (50-я вакансия) — пропускаем

-- Вакансии Kanat (Горнодобывающая)
((SELECT id FROM resumes WHERE name = 'Iskender — Прораб'),
 (SELECT id FROM vacancies WHERE name = 'Горный инженер'), 'PENDING'),

((SELECT id FROM resumes WHERE name = 'Ruslan — Механик'),
 (SELECT id FROM vacancies WHERE name = 'Взрывник'), 'REJECTED'),

((SELECT id FROM resumes WHERE name = 'Iskender — Инженер по ОТ'),
 (SELECT id FROM vacancies WHERE name = 'Геолог'), 'PENDING'),

((SELECT id FROM resumes WHERE name = 'Ruslan — Диспетчер автопарка'),
 (SELECT id FROM vacancies WHERE name = 'Оператор горной техники'), 'ACCEPTED'),

-- Инженер по безопасности (55-я вакансия) — пропускаем

-- Вакансии Larisa (Медиа)
((SELECT id FROM resumes WHERE name = 'Kuban — Контент-менеджер'),
 (SELECT id FROM vacancies WHERE name = 'Журналист'), 'PENDING'),

((SELECT id FROM resumes WHERE name = 'Omurbek — Графический дизайнер'),
 (SELECT id FROM vacancies WHERE name = 'Видеооператор'), 'REJECTED'),

((SELECT id FROM resumes WHERE name = 'Kuban — Маркетолог'),
 (SELECT id FROM vacancies WHERE name = 'Редактор'), 'PENDING'),

((SELECT id FROM resumes WHERE name = 'Omurbek — UX/UI Designer'),
 (SELECT id FROM vacancies WHERE name = 'Фотограф'), 'ACCEPTED'),

-- Главный редактор (60-я вакансия) — пропускаем

-- Вакансии Marat (Энергетика)
((SELECT id FROM resumes WHERE name = 'Ruslan — Механик'),
 (SELECT id FROM vacancies WHERE name = 'Электрик'), 'PENDING'),

((SELECT id FROM resumes WHERE name = 'Iskender — Инженер по ОТ'),
 (SELECT id FROM vacancies WHERE name = 'Инженер-энергетик'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Ruslan — Водитель автобуса'),
 (SELECT id FROM vacancies WHERE name = 'Оператор котельной'), 'REJECTED'),

((SELECT id FROM resumes WHERE name = 'Ruslan — Диспетчер автопарка'),
 (SELECT id FROM vacancies WHERE name = 'Монтажник электрооборудования'), 'PENDING'),

-- Главный энергетик (65-я вакансия) — пропускаем

-- Вакансии Nurgul (Фармацевтика)
((SELECT id FROM resumes WHERE name = 'Hamid — Фармацевт'),
 (SELECT id FROM vacancies WHERE name = 'Фармацевт'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Gulnara — Семейный врач'),
 (SELECT id FROM vacancies WHERE name = 'Провизор'), 'PENDING'),

((SELECT id FROM resumes WHERE name = 'Hamid — Медбрат'),
 (SELECT id FROM vacancies WHERE name = 'Медицинский представитель'), 'REJECTED'),

((SELECT id FROM resumes WHERE name = 'Gulnara — Врач-педиатр'),
 (SELECT id FROM vacancies WHERE name = 'Лаборант'), 'PENDING'),

-- Заведующий аптекой (70-я вакансия) — пропускаем

-- Вакансии Osmon (Безопасность)
((SELECT id FROM resumes WHERE name = 'Ruslan — Водитель автобуса'),
 (SELECT id FROM vacancies WHERE name = 'Охранник'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Iskender — Инженер по ОТ'),
 (SELECT id FROM vacancies WHERE name = 'Начальник охраны'), 'PENDING'),

((SELECT id FROM resumes WHERE name = 'Nurzat — Специалист по ИБ'),
 (SELECT id FROM vacancies WHERE name = 'Специалист по информационной безопасности'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Iskender — Прораб'),
 (SELECT id FROM vacancies WHERE name = 'Инспектор по безопасности'), 'REJECTED'),

-- Кинолог (75-я вакансия) — пропускаем

-- Вакансии Perizat (Дизайн)
((SELECT id FROM resumes WHERE name = 'Omurbek — Графический дизайнер'),
 (SELECT id FROM vacancies WHERE name = 'Графический дизайнер'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Omurbek — UX/UI Designer'),
 (SELECT id FROM vacancies WHERE name = 'UX/UI дизайнер'), 'PENDING'),

((SELECT id FROM resumes WHERE name = 'Bekzat — UX/UI Designer'),
 (SELECT id FROM vacancies WHERE name = 'Веб-дизайнер'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Omurbek — Веб-дизайнер'),
 (SELECT id FROM vacancies WHERE name = 'Арт-директор'), 'REJECTED'),

-- Иллюстратор (80-я вакансия) — пропускаем

-- Вакансии Ruslan (Транспорт)
((SELECT id FROM resumes WHERE name = 'Ruslan — Водитель автобуса'),
 (SELECT id FROM vacancies WHERE name = 'Водитель автобуса'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Ruslan — Механик'),
 (SELECT id FROM vacancies WHERE name = 'Механик'), 'PENDING'),

((SELECT id FROM resumes WHERE name = 'Ruslan — Диспетчер автопарка'),
 (SELECT id FROM vacancies WHERE name = 'Диспетчер автопарка'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Cholponai — Водитель B'),
 (SELECT id FROM vacancies WHERE name = 'Водитель такси'), 'PENDING'),

-- Начальник автоколонны (85-я вакансия) — пропускаем

-- Вакансии Saltanat (Общепит)
((SELECT id FROM resumes WHERE name = 'Saltanat — Повар'),
 (SELECT id FROM vacancies WHERE name = 'Повар'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Saltanat — Кондитер'),
 (SELECT id FROM vacancies WHERE name = 'Шеф-повар'), 'REJECTED'),

((SELECT id FROM resumes WHERE name = 'Ulanbek — Риелтор'),
 (SELECT id FROM vacancies WHERE name = 'Официант'), 'REJECTED'),

((SELECT id FROM resumes WHERE name = 'Saltanat — Администратор'),
 (SELECT id FROM vacancies WHERE name = 'Администратор ресторана'), 'ACCEPTED'),

-- Кондитер (90-я вакансия) — пропускаем

-- Вакансии Talant (Консалтинг)
((SELECT id FROM resumes WHERE name = 'Perizat — Бизнес-аналитик'),
 (SELECT id FROM vacancies WHERE name = 'Бизнес-аналитик'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Talant — Консультант'),
 (SELECT id FROM vacancies WHERE name = 'Консультант по управлению'), 'PENDING'),

((SELECT id FROM resumes WHERE name = 'Perizat — HR-менеджер'),
 (SELECT id FROM vacancies WHERE name = 'HR-менеджер'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Talant — Тренер по продажам'),
 (SELECT id FROM vacancies WHERE name = 'Тренер по продажам'), 'PENDING'),

-- Проектный менеджер (95-я вакансия) — пропускаем

-- Вакансии Ulanbek (Недвижимость)
((SELECT id FROM resumes WHERE name = 'Ulanbek — Риелтор'),
 (SELECT id FROM vacancies WHERE name = 'Риелтор'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Ulanbek — Оценщик недвижимости'),
 (SELECT id FROM vacancies WHERE name = 'Оценщик недвижимости'), 'PENDING'),

((SELECT id FROM resumes WHERE name = 'Ulanbek — Менеджер по аренде'),
 (SELECT id FROM vacancies WHERE name = 'Менеджер по аренде'), 'ACCEPTED'),

((SELECT id FROM resumes WHERE name = 'Lira — Юрист'),
 (SELECT id FROM vacancies WHERE name = 'Юрист по недвижимости'), 'PENDING');

-- Директор агентства недвижимости (100-я вакансия) — пропускаем


-- =====================
-- 10. MESSAGES (2 сообщения на каждый отклик = 160 сообщений)
-- =====================
INSERT INTO messages (responded_applicants_id, content, sent_at)
SELECT
    ra.id,
    'Здравствуйте! Меня заинтересовала ваша вакансия. Готов(а) к собеседованию в удобное для вас время.',
    DATEADD('DAY', -1, CURRENT_DATE)
FROM responded_applicants ra;

INSERT INTO messages (responded_applicants_id, content, sent_at)
SELECT
    ra.id,
    CASE ra.status
        WHEN 'ACCEPTED' THEN 'Добрый день! Ваша кандидатура нас заинтересовала. Приглашаем на собеседование. Свяжитесь с нами для уточнения времени.'
        WHEN 'REJECTED' THEN 'Добрый день! Благодарим за интерес к нашей вакансии. К сожалению, на данный момент мы выбрали другого кандидата. Желаем удачи!'
        ELSE 'Добрый день! Мы получили ваш отклик и рассматриваем вашу кандидатуру. Ответим в течение 2–3 рабочих дней.'
        END,
    CURRENT_TIMESTAMP
FROM responded_applicants ra;

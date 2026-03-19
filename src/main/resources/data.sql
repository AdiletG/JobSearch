create table if not exists users
(
    id int auto_increment primary key,
    name varchar(100),
    surname varchar(100),
    age int,
    email varchar(255) unique,
    password varchar(255),
    phone_number varchar(55),
    avatar text,
    account_type varchar(50) check (account_type in ('EMPLOYER', 'APPLICANT'))
    );

insert into users(name, surname, age, email, password, phone_number, avatar, account_type)
values
    ('Adilet', 'Janybek', 24, 'adilet@mail.ru', 'qwerty',
     '996775878765', 'avatar', 'EMPLOYER'),

    ('Asan', 'Uson', 32, 'asan@mail.ru', 'ytrewq',
     '996555987867', 'avatar', 'APPLICANT');

create table if not exists categories
(
    id int auto_increment primary key,
    name varchar(100),
    parent_id int,
    foreign key (parent_id) references categories(id)
    );

insert into categories(name, parent_id)
values
    ('IT', null),
    ('Driver', null),
    ('Teacher', null);

create table if not exists vacancies
(
    id int auto_increment primary key,
    name varchar(100),
    description text,
    category_id int,
    salary numeric(10,2),
    exp_from int,
    exp_to int,
    is_active boolean,
    author_id int,
    created_date timestamp,
    update_date timestamp,
    foreign key (category_id) references categories(id),
    foreign key (author_id) references users(id)
    );

insert into vacancies(name, description, category_id, salary, exp_from, exp_to, is_active, author_id, created_date, update_date)
values
    ('Teacher', 'You will be teaching elementary school students', 3, 10000,
     5, 10, true, 1, '2026-03-13 18:30:00', null),

    ('Driver', 'You drive a cargo truck', 2, 15000,
     3, 10, true, 1, '2026-02-12 12:09:00', null);

create table if not exists resumes
(
    id int auto_increment primary key,
    applicant_id int,
    name varchar(100),
    category_id int,
    salary numeric(10,2),
    is_active boolean,
    created_date timestamp,
    update_date timestamp,
    foreign key (applicant_id) references users(id),
    foreign key (category_id) references categories(id)
    );

insert into resumes(applicant_id, name, category_id, salary, is_active, created_date, update_date)
values
    (1, 'Adilet Driver Resume', 2, 13000, true,
     '2026-03-03 17:00:00', null),

    (2, 'Asan Teacher Resume', 3, 10000, true,
     '2026-02-12 18:40:00', null);

create table if not exists contact_types
(
    id int auto_increment primary key,
    type varchar(100)
    );

insert into contact_types(type)
values
    ('Phone-number'),
    ('Telegram'),
    ('Email');

create table if not exists contacts_info
(
    id int auto_increment primary key,
    type_id int,
    resume_id int,
    contact_value text,
    foreign key (type_id) references contact_types(id),
    foreign key (resume_id) references resumes(id)
    );

insert into contacts_info(type_id, resume_id, contact_value)
values
    (1, 1, '+996500123213'),
    (2, 1, '@Asan'),
    (3, 1, 'asan@mail.ru'),
    (1, 2, '+996503423213'),
    (2, 2, '@AsanAsan'),
    (3, 2, 'asanasan@mail.ru');

create table if not exists responded_applicant
(
    id int auto_increment primary key,
    resume_id int,
    vacancy_id int,
    confirmation boolean,
    foreign key (resume_id) references resumes(id),
    foreign key (vacancy_id) references vacancies(id)
    );

insert into responded_applicant(resume_id, vacancy_id, confirmation)
values
    (1, 1, null),
    (2, 2, null);

create table if not exists education_info
(
    id int auto_increment primary key,
    resume_id int,
    institution varchar(255),
    program varchar(255),
    start_date int,
    end_date int,
    degree varchar(255),
    foreign key (resume_id) references resumes(id)
    );

insert into education_info(resume_id, institution, program, start_date, end_date, degree)
values
    (1, 'Kyrgyz State Technical University', 'Logistics and Transport',
     2015, 2019, 'Bachelor'),

    (2, 'Kyrgyz National University', 'Pedagogy',
     2014, 2018, 'Bachelor');

create table if not exists work_experience_info
(
    id int auto_increment primary key,
    resume_id int,
    years int,
    company_name varchar(255),
    position_in_company varchar(255),
    responsibilities text,
    foreign key (resume_id) references resumes(id)
    );

insert into work_experience_info(resume_id, years, company_name, position_in_company, responsibilities)
values
    (1, 4, 'Truck Logistic LLC', 'Driver',
     'Cargo transportation across regions, vehicle inspection, and delivery reporting'),

    (2, 6, 'School #12', 'Teacher',
     'Teaching students, preparing lesson plans, and evaluating assignments');

create table if not exists messages
(
    id int auto_increment primary key,
    responded_applicant_id int,
    content text,
    times timestamp,
    foreign key (responded_applicant_id) references responded_applicant(id)
    );

insert into messages(responded_applicant_id, content, times)
values
    (1, 'Hello, I am interested in this vacancy and ready for an interview.', '2026-03-15 10:00:00'),
    (2, 'Your resume has been reviewed. Please wait for further response.', '2026-03-16 14:30:00');
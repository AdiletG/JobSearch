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
    account_type varchar(50)
    );

create table if not exists categories
(
    id int auto_increment primary key,
    name varchar(100),
    parent_id int,
    foreign key (parent_id) references categories(id)
    );

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

create table if not exists contact_types
(
    id int auto_increment primary key,
    type varchar(100)
    );

create table if not exists contacts_info
(
    id int auto_increment primary key,
    type_id int,
    resume_id int,
    value text,
    foreign key (type_id) references contact_types(id),
    foreign key (resume_id) references resumes(id)
    );

create table if not exists responded_applicant
(
    id int auto_increment primary key,
    resume_id int,
    vacancy_id int,
    confirmation boolean,
    foreign key (resume_id) references resumes(id),
    foreign key (vacancy_id) references vacancies(id)
    );

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

create table if not exists messages
(
    id int auto_increment primary key,
    responded_applicant_id int,
    content text,
    times timestamp,
    foreign key (responded_applicant_id) references responded_applicant(id)
    );
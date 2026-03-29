-- AUTHORITIES
insert into authorities (authority)
values ('VACANCY_VIEW'),
       ('RESUME_VIEW'),
       ('VACANCY_CREATE'),
       ('VACANCY_UPDATE'),
       ('VACANCY_DELETE'),
       ('RESUME_CREATE'),
       ('RESUME_UPDATE'),
       ('RESUME_DELETE'),
       ('RESPOND_TO_VACANCY'),
       ('RESPONDED_APPLICANTS_VIEW'),
       ('PROFILE_EDIT'),
       ('USER_MANAGE');

-- ROLES
insert into roles (role)
values ('ROLE_APPLICANT'),
       ('ROLE_EMPLOYER'),
       ('ROLE_ADMIN');


-- APPLICANT
insert into role_auth (auth_id, role_id)
values
    ((select id from authorities where authority = 'VACANCY_VIEW'),
     (select id from roles where role = 'ROLE_APPLICANT')),

    ((select id from authorities where authority = 'RESUME_VIEW'),
     (select id from roles where role = 'ROLE_APPLICANT')),

    ((select id from authorities where authority = 'RESUME_CREATE'),
     (select id from roles where role = 'ROLE_APPLICANT')),

    ((select id from authorities where authority = 'RESUME_UPDATE'),
     (select id from roles where role = 'ROLE_APPLICANT')),

    ((select id from authorities where authority = 'RESUME_DELETE'),
     (select id from roles where role = 'ROLE_APPLICANT')),

    ((select id from authorities where authority = 'RESPOND_TO_VACANCY'),
     (select id from roles where role = 'ROLE_APPLICANT')),

    ((select id from authorities where authority = 'PROFILE_EDIT'),
     (select id from roles where role = 'ROLE_APPLICANT'));

-- EMPLOYER
insert into role_auth (auth_id, role_id)
values
    ((select id from authorities where authority = 'VACANCY_VIEW'),
     (select id from roles where role = 'ROLE_EMPLOYER')),

    ((select id from authorities where authority = 'RESUME_VIEW'),
     (select id from roles where role = 'ROLE_EMPLOYER')),

    ((select id from authorities where authority = 'VACANCY_CREATE'),
     (select id from roles where role = 'ROLE_EMPLOYER')),

    ((select id from authorities where authority = 'VACANCY_UPDATE'),
     (select id from roles where role = 'ROLE_EMPLOYER')),

    ((select id from authorities where authority = 'VACANCY_DELETE'),
     (select id from roles where role = 'ROLE_EMPLOYER')),

    ((select id from authorities where authority = 'RESPONDED_APPLICANTS_VIEW'),
     (select id from roles where role = 'ROLE_EMPLOYER')),

    ((select id from authorities where authority = 'PROFILE_EDIT'),
     (select id from roles where role = 'ROLE_EMPLOYER'));

insert into role_auth (auth_id, role_id)
values
    ((select id from authorities where authority = 'VACANCY_VIEW'),
     (select id from roles where role = 'ROLE_ADMIN')),

    ((select id from authorities where authority = 'RESUME_VIEW'),
     (select id from roles where role = 'ROLE_ADMIN')),

    ((select id from authorities where authority = 'VACANCY_CREATE'),
     (select id from roles where role = 'ROLE_ADMIN')),

    ((select id from authorities where authority = 'VACANCY_UPDATE'),
     (select id from roles where role = 'ROLE_ADMIN')),

    ((select id from authorities where authority = 'VACANCY_DELETE'),
     (select id from roles where role = 'ROLE_ADMIN')),

    ((select id from authorities where authority = 'RESUME_CREATE'),
     (select id from roles where role = 'ROLE_ADMIN')),

    ((select id from authorities where authority = 'RESUME_UPDATE'),
     (select id from roles where role = 'ROLE_ADMIN')),

    ((select id from authorities where authority = 'RESUME_DELETE'),
     (select id from roles where role = 'ROLE_ADMIN')),

    ((select id from authorities where authority = 'RESPOND_TO_VACANCY'),
     (select id from roles where role = 'ROLE_ADMIN')),

    ((select id from authorities where authority = 'RESPONDED_APPLICANTS_VIEW'),
     (select id from roles where role = 'ROLE_ADMIN')),

    ((select id from authorities where authority = 'PROFILE_EDIT'),
     (select id from roles where role = 'ROLE_ADMIN')),

    ((select id from authorities where authority = 'USER_MANAGE'),
     (select id from roles where role = 'ROLE_ADMIN'));


-- APPLICANT
insert into user_role (user_id, role_id)
select id,
       (select id from roles where role = 'ROLE_APPLICANT')
from users
where account_type = 'APPLICANT';

-- EMPLOYER
insert into user_role (user_id, role_id)
select id,
       (select id from roles where role = 'ROLE_EMPLOYER')
from users
where account_type = 'EMPLOYER';

DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS roles;
create table roles (
   id integer not null,
   name varchar(20),
   primary key (id)
);
create table user_roles (
    user_id integer not null,
    role_id integer not null,
    primary key (user_id)
);
INSERT INTO roles (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_MODERATOR');
INSERT INTO roles (id, name) VALUES (3, 'ROLE_ADMIN');

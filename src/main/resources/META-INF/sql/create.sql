CREATE TABLE doctors (id bigint NOT NULL AUTO_INCREMENT, room int NOT NULL, PRIMARY KEY (`id`));
CREATE TABLE doctors_specializations (doctor_id bigint NOT NULL, specialization_id bigint NOT NULL);
CREATE TABLE specializations (id bigint NOT NULL AUTO_INCREMENT, specialization varchar(20) NOT NULL, PRIMARY KEY (`id`));
CREATE TABLE doctors_users (doctor_id bigint NOT NULL,user_id bigint NOT NULL);
CREATE TABLE users (id bigint NOT NULL AUTO_INCREMENT, login varchar(20) NOT NULL, email varchar(50) NOT NULL, password varchar(255) NOT NULL, first_name varchar(20) NOT NULL, last_name varchar(20) NOT NULL, birth_date date NOT NULL, active boolean NOT NULL, PRIMARY KEY (`id`));
CREATE TABLE users_visits (user_id bigint NOT NULL, visit_id bigint NOT NULL);
CREATE TABLE visits (id bigint NOT NULL AUTO_INCREMENT, date date NOT NULL, PRIMARY KEY (`id`));
CREATE TABLE users_roles (login varchar(20), role varchar(20));

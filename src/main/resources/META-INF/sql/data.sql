INSERT INTO specializations(specialization) values ('Stomatolog');

INSERT INTO users(login, email, password, first_name, last_name, birth_date, active) values ('TestUser1', 'testUser1@mail.com', '{bcrypt}$2a$10$290AupiVJR.vUlFGd5Wh/OlVCmevB0wmNv2UU5Tbac3jQ1z8iDPmi', 'Test1', 'User1', '2000-02-01', '1');
INSERT INTO users_roles(login, role) values ('testUser1', 'ROLE_USER');
INSERT INTO users(login, email, password, first_name, last_name, birth_date, active) values ('TestUser2', 'testUser2@mail.com', '{bcrypt}$2a$10$290AupiVJR.vUlFGd5Wh/OlVCmevB0wmNv2UU5Tbac3jQ1z8iDPmi', 'Test2', 'User2', '1999-04-05', '1');
INSERT INTO users_roles(login, role) values ('testUser2', 'ROLE_USER');
INSERT INTO users(login, email, password, first_name, last_name, birth_date, active) values ('TestDoctor1', 'testDoctor1@mail.com', '{bcrypt}$2a$10$290AupiVJR.vUlFGd5Wh/OlVCmevB0wmNv2UU5Tbac3jQ1z8iDPmi', 'Test1', 'Doctor1', '1998-06-07', '1');
INSERT INTO users_roles(login, role) values ('admin', 'ROLE_DOCTOR');
INSERT INTO users(login, email, password, first_name, last_name, birth_date, active) values ('TestDoctor2', 'testDoctor2@mail.com', '{bcrypt}$2a$10$290AupiVJR.vUlFGd5Wh/OlVCmevB0wmNv2UU5Tbac3jQ1z8iDPmi', 'Test2', 'Doctor2', '1997-08-09', '1');
INSERT INTO users_roles(login, role) values ('admin', 'ROLE_DOCTOR');
INSERT INTO users(login, email, password, first_name, last_name, birth_date, active) values ('Admin', 'admin@mail.com', '{bcrypt}$2a$10$290AupiVJR.vUlFGd5Wh/OlVCmevB0wmNv2UU5Tbac3jQ1z8iDPmi', 'Admin', 'Admin', '1995-03-12', '1');
INSERT INTO users_roles(login, role) values ('admin', 'ROLE_ADMIN');

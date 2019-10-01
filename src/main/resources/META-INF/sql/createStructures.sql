create table `users` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `login` varchar(20) NOT NULL,
    `email` varchar(50) NOT NULL,
    `password` varchar(255) NOT NULL,
    `first_name` varchar(20) NOT NULL,
    `last_name` varchar(20) NOT NULL,
    `birth_date` date NOT NULL,
    `active` boolean NOT NULL,
    PRIMARY KEY (`id`)
);

create table `doctors` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `specialization` varchar(20) NOT NULL,
    `room` bigint NOT NULL,
    PRIMARY KEY (`id`)
);

create table `visits` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `doctor_id` bigint NOT NULL,
    `date` date NOT NULL,
    PRIMARY KEY (`id`)
);

create table `users_visits` (
    `user_id` bigint NOT NULL,
    `visit_id` bigint NOT NULL
);

create table `users_roles` (
    `login` varchar(20),
    `role` varchar(20)
);

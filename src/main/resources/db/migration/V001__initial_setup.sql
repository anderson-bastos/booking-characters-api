-- Script inicial apenas para inicializar o Flyway

-- Role
CREATE TABLE IF NOT EXISTS roles (
	id varchar(50) NOT NULL,
	CONSTRAINT roles_pkey PRIMARY KEY (id)
);

-- Users
CREATE TABLE IF NOT EXISTS users (
	id varchar(36) NOT NULL,
	created_at timestamp NULL,
	"name" varchar(150) NULL,
	"password" varchar(50) NULL,
	CONSTRAINT users_pkey PRIMARY KEY (id)
);

-- Users_Roles
CREATE TABLE IF NOT EXISTS users_roles (
	user_id varchar(36) NOT NULL,
	roles_id varchar(50) NOT NULL,
	CONSTRAINT users_roles_pkey PRIMARY KEY (user_id, roles_id),
	CONSTRAINT fk2o0jvgh89lemvvo17cbqvdxaa FOREIGN KEY (user_id) REFERENCES users(id),
	CONSTRAINT fka62j07k5mhgifpp955h37ponj FOREIGN KEY (roles_id) REFERENCES roles(id)
);

-- ROLES
insert into roles values ('ROLE_ADM');

-- USERS
insert into users (id, name, password, created_at)
values('e14a721d-2a1f-430e-9b40-356e7b857433', 'admin', '123456', now());

-- USERS ROLES
insert into users_roles (user_id, roles_id)
values('e14a721d-2a1f-430e-9b40-356e7b857433', 'ROLE_ADM');


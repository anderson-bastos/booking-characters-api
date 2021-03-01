-- Script inicial apenas para inicializar o Flyway

-- Tables
CREATE TABLE IF NOT EXISTS users (
	id varchar(36) NOT NULL,
	created_at timestamp NULL,
	"name" varchar(150) NULL,
    "email" varchar(150) NULL,
	"password" varchar(150) NULL,
    "role" varchar(150) NULL,
	CONSTRAINT users_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS client (
   id uuid NOT NULL,
   created_at timestamp NULL,
   "name" varchar(150) NULL,
   "password" varchar(50) NULL,
   CONSTRAINT client_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS address (
    id uuid NOT NULL,
    created_at timestamp NULL,
    city varchar(100) NULL,
    complement varchar(100) NULL,
    district varchar(100) NULL,
    "number" varchar(5) NULL,
    state varchar(100) NULL,
    street varchar(150) NULL,
    CONSTRAINT address_pkey PRIMARY KEY (id)
);

CREATE TABLE public.client_addresses (
     client_id uuid NOT NULL,
     addresses_id uuid NOT NULL,
     CONSTRAINT client_addresses_pkey PRIMARY KEY (client_id, addresses_id),
     CONSTRAINT fkcdcc7e7dhugwkogl9xlscdwga FOREIGN KEY (client_id) REFERENCES client(id),
     CONSTRAINT fkoy14xnjqcqjr1le5apetau358 FOREIGN KEY (addresses_id) REFERENCES address(id)
);

CREATE TABLE IF NOT EXISTS "character" (
    id uuid NOT NULL,
    created_at timestamp NULL,
    price float4 NOT NULL,
    CONSTRAINT character_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS character_group (
    id uuid NOT NULL,
    created_at timestamp NULL,
    price float4 NOT NULL,
    CONSTRAINT character_group_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS booking (
    id uuid NOT NULL,
    created_at timestamp NULL,
    booking_at timestamp NULL,
    character_group_id uuid NULL,
    client_id uuid NULL,
    CONSTRAINT booking_pkey PRIMARY KEY (id),
    CONSTRAINT fkhs7eej4m2orrmr5cfbcrqs8yw FOREIGN KEY (client_id) REFERENCES client(id),
    CONSTRAINT fkiph8fpqqbwdpauvshbl20fkw0 FOREIGN KEY (character_group_id) REFERENCES character_group(id)
);

CREATE TABLE IF NOT EXISTS character_group_characters (
   character_group_id uuid NOT NULL,
   characters_id uuid NOT NULL,
   CONSTRAINT character_group_characters_pkey PRIMARY KEY (character_group_id, characters_id),
   CONSTRAINT uk_dcy0ygsl0hnjqdly55q4jmn6s UNIQUE (characters_id),
   CONSTRAINT fk83o9483f09g702s7qio9m2h6i FOREIGN KEY (character_group_id) REFERENCES character_group(id),
   CONSTRAINT fkr6x4q1h715kns7hj6wtsbh8ck FOREIGN KEY (characters_id) REFERENCES "character"(id)
);


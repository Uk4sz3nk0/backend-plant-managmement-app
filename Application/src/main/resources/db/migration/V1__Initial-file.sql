CREATE TABLE IF NOT EXISTS plantations (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name varchar(256) NOT NULL,
    nip varchar(120) NOT NULL,
    regon varchar(120) NOT NULL,
    city varchar(75) NOT NULL,
    street varchar(75) NOT NULL,
    house_number integer NOT NULL,
    flat_number integer,
    post_code varchar(20) NOT NULL,
    owner_id BIGINT,
    FOREIGN KEY(owner_id) REFERENCES users(id);
);

CREATE TABLE IF NOT EXISTS tokens (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    token varchar(256) NOT NULL,
    token_type varchar(120) NOT NULL,
    revoked boolean,
    expired boolean,
    user_id BIGINT
);

CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    first_name varchar(65) NOT NULL,
    last_name varchar(75) NOT NULL,
    email varchar(120) NOT NULL UNIQUE,
    password varchar(256) NOT NULL,
    role varchar(65)
);

CREATE TABLE IF NOT EXISTS  user_plantation
(
    user_id BIGINT NOT NULL REFERENCES users,
    plantation_id BIGINT NOT NULL REFERENCES plantations,
    PRIMARY KEY (user_id, plantation_id)
);

CREATE TABLE IF NOT EXISTS permissions (
  id BIGSERIAL NOT NULL PRIMARY KEY,
  permission varchar(256) NOT NULL
);



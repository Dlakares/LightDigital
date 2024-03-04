CREATE TABLE users (
    id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE,
    username varchar(256) UNIQUE NOT NULL,
    password varchar NOT NULL
);

CREATE TABLE roles (
    id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE,
    name varchar NOT NULL
);

CREATE TABLE users_roles (
    user_id bigint NOT NULL,
    role_id bigint NOT NULL,

    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES roles (id)
);

INSERT INTO roles (name) VALUES ('USER'), ('ADMIN'), ('OPERATOR');
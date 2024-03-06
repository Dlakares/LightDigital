CREATE TABLE users (
    id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE,
    username varchar(256) UNIQUE NOT NULL,
    password varchar NOT NULL,
    created_at timestamptz DEFAULT current_timestamp,
    updated_at timestamptz DEFAULT current_timestamp
);

CREATE TABLE roles (
    id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE,
    name varchar NOT NULL,
    created_at timestamptz DEFAULT current_timestamp,
    updated_at timestamptz DEFAULT current_timestamp
);

CREATE TABLE phones (
    id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE,
    country_code integer NOT NULL,
    city_code integer NOT NULL,
    number integer NOT NULL,
    full_number varchar(11),
    user_id bigint NOT NULL,
    created_at timestamptz DEFAULT current_timestamp,
    updated_at timestamptz DEFAULT current_timestamp,

    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE requests (
    id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE,
    status varchar(8) NOT NULL,
    message text NOT NULL,
    phone_id bigint NOT NULL,
    name varchar(256) NOT NULL,
    user_id bigint NOT NULL,
    created_at timestamptz DEFAULT current_timestamp,
    updated_at timestamptz DEFAULT current_timestamp,

    CONSTRAINT fk_phone_id FOREIGN KEY (phone_id) REFERENCES phones(id),
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE users_roles (
    user_id bigint NOT NULL,
    role_id bigint NOT NULL,

    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES roles (id)
);

INSERT INTO roles (name) VALUES ('USER'), ('ADMIN'), ('OPERATOR');
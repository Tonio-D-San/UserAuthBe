CREATE table person
(
    id          SERIAL PRIMARY KEY,
    uuid        UUID         NOT NULL UNIQUE,
    name        VARCHAR(100) NOT NULL,
    surname     VARCHAR(50)  NOT NULL,
    biography   TEXT,
    email       VARCHAR(100) NOT NULL UNIQUE,
    is_active   BOOLEAN      NOT NULL,
    img_profile BYTEA
);

CREATE TABLE topic
(
    id                   BIGSERIAL PRIMARY KEY,
    uuid                 UUID         NOT NULL UNIQUE,
    title                VARCHAR(255) NOT NULL,
    date_creation        BIGINT       NOT NULL,
    date_last_update     BIGINT,
    description_problem  TEXT         NOT NULL,
    description_solution TEXT,
    person_id            INT          NOT NULL REFERENCES "person" (id),
    is_active            BOOLEAN      NOT NULL,
    is_open              BOOLEAN      NOT NULL,
    best_comment         BIGINT UNIQUE
);

CREATE TABLE comment
(
    id               BIGSERIAL PRIMARY KEY,
    uuid             UUID      NOT NULL UNIQUE,
    date_creation    BIGINT    NOT NULL,
    date_last_update BIGINT,
    description      TEXT,
    person_id        INT       NOT NULL REFERENCES person (id),
    topic_id         BIGSERIAL NOT NULL REFERENCES topic (id),
    parent           BIGINT REFERENCES comment (id),
    is_active        BOOLEAN   NOT NULL
);

ALTER TABLE topic
    ADD CONSTRAINT fk_best_comment FOREIGN KEY (best_comment) REFERENCES comment (id);

CREATE TABLE category
(
    id   SERIAL PRIMARY KEY,
    uuid UUID        NOT NULL UNIQUE,
    name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE category_topic
(
    category_id SERIAL REFERENCES category (id),
    topic_id    BIGSERIAL REFERENCES topic (id),
    PRIMARY KEY (category_id, topic_id)
);

CREATE TABLE attachment
(
    id               BIGSERIAL PRIMARY KEY,
    uuid             UUID         NOT NULL UNIQUE,
    name             VARCHAR(255) NOT NULL,
    path             VARCHAR(255),
    date_upload      BIGINT       NOT NULL,
    date_last_update BIGINT,
    topic_id         BIGSERIAL    NOT NULL REFERENCES topic (id)
);

CREATE TABLE usergroup
(
    id          SERIAL PRIMARY KEY,
    uuid        UUID        NOT NULL UNIQUE,
    name        VARCHAR(50) NOT NULL,
    path        VARCHAR(50) NOT NULL,
    description VARCHAR(255)
);

CREATE TABLE person_group
(
    person_id SERIAL REFERENCES person (id),
    group_id  SERIAL REFERENCES usergroup (id),
    PRIMARY KEY (person_id, group_id)
);

INSERT INTO person (uuid, name, surname, biography, email, is_active, img_profile)
VALUES ('167fc152-213f-4c2d-b2f9-03a3ddce4a4c', 'Lucio Maria', 'Bisci', 'Username: lbisci, Role: admin, user',
        'lbisci@cybsec.it', TRUE, NULL);

INSERT INTO usergroup (uuid, name, path, description)
VALUES ('7de6d481-9da9-4bcc-aca2-30073030ae9d',
        'cyber-users',
        '/cyber-users',
        'Role for admin'),
       ('f70783d9-b64b-46b9-81c2-e4af0e5f9889',
        'admin-service-administrators',
        '/cyber-users/admin-service-administrators',
        'Role for admin'),
       ('e246270c-acaa-4aed-8d9f-4b7bbe95f2cb',
        'user-service-administrators',
        '/cyber-users/user-service-administrators',
        'Role for users');

INSERT INTO person_group(person_id, group_id)
VALUES (1, 2),
       (1, 3)
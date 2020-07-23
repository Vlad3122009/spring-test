DROP TABLE IF EXISTS usera_roles;
DROP TABLE IF EXISTS usersA;
DROP SEQUENCE IF EXISTS global_seqa;

CREATE SEQUENCE global_seqa START WITH 100000;

CREATE TABLE usersA
(
    id               INTEGER PRIMARY KEY DEFAULT nextval('global_seqa'),
    name             VARCHAR                           NOT NULL,
    email            VARCHAR                           NOT NULL,
    password         VARCHAR                           NOT NULL,
    registered       TIMESTAMP           DEFAULT now() NOT NULL,
    enabled          BOOL                DEFAULT TRUE  NOT NULL
);
CREATE UNIQUE INDEX usersA_unique_email_idx ON usersA (email);

CREATE TABLE userA_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR,
    CONSTRAINT userA_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES usersA (id) ON DELETE CASCADE
);

DROP SEQUENCE IF EXISTS mot_bal_sequence;

DROP TABLE IF EXISTS estimation_pairs;
DROP TABLE IF EXISTS results;
DROP TABLE IF EXISTS factors;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS employees;


CREATE TABLE employees
(
    id bigint NOT NULL,
    manager_id bigint,
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    emp_role varchar(10) NOT NULL,
    CONSTRAINT employees_pkey PRIMARY KEY (id),
    CONSTRAINT fk_from_emp_to_emp FOREIGN KEY (manager_id)
        REFERENCES employees (id)
);

CREATE TABLE users
(
    id bigint NOT NULL,
    emp_id bigint UNIQUE,
    email varchar(100) UNIQUE NOT NULL,
    password varchar(255) NOT NULL,
    role varchar(10) NOT NULL,
    status varchar(6) NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT fk_from_user_to_emp FOREIGN KEY (emp_id)
        REFERENCES employees (id)
        ON DELETE CASCADE
);

CREATE TABLE factors
(
    id bigint NOT NULL,
    name varchar(50) UNIQUE NOT NULL,
    status varchar(7) NOT NULL,
    CONSTRAINT factors_pkey PRIMARY KEY (id)
);

CREATE TABLE results
(
    id bigint NOT NULL,
    is_relevant boolean NOT NULL,
    pass_datetime timestamp NOT NULL,
    emp_id bigint NOT NULL,
    CONSTRAINT results_pkey PRIMARY KEY (id),
    CONSTRAINT fk_from_result_to_emp FOREIGN KEY (emp_id)
        REFERENCES employees (id)
        ON DELETE CASCADE
);

CREATE TABLE estimation_pairs
(
    id bigint NOT NULL,
    estim varchar(8) NOT NULL,
    factor_id bigint NOT NULL,
    result_id bigint NOT NULL,
    CONSTRAINT estimation_pairs_pkey PRIMARY KEY (id),
    CONSTRAINT fk_from_est_pair_to_factor FOREIGN KEY (factor_id)
        REFERENCES factors (id)
        ON DELETE CASCADE,
    CONSTRAINT fk_from_est_pair_to_result FOREIGN KEY (result_id)
        REFERENCES results (id)
        ON DELETE CASCADE
);


CREATE INDEX idx_factor_to_factor_status ON factors(status);
CREATE INDEX idx_factor_to_factor_name ON factors(name);
CREATE INDEX idx_results_to_is_relevant ON results(is_relevant);

CREATE SEQUENCE mot_bal_sequence START 1000;


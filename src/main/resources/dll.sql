CREATE TABLE user_obj
(
    id BIGINT PRIMARY KEY NOT NULL,
    password VARCHAR(255),
    user_name VARCHAR(255)
);
CREATE TABLE user_obj_skills
(
    user_obj_id BIGINT NOT NULL,
    skills_id BIGINT NOT NULL,
    CONSTRAINT user_obj_skills_pkey PRIMARY KEY (user_obj_id, skills_id),
    CONSTRAINT fkkqcial5ggeigo35h8h6kenbcd FOREIGN KEY (user_obj_id) REFERENCES user_obj (id),
    CONSTRAINT fk41l2cq7qo9v3p1cgwwjyfew7v FOREIGN KEY (skills_id) REFERENCES skills (id)
);
CREATE TABLE user_obj_spells
(
    user_obj_id BIGINT NOT NULL,
    spells_id BIGINT NOT NULL,
    CONSTRAINT user_obj_spells_pkey PRIMARY KEY (user_obj_id, spells_id),
    CONSTRAINT fkfkhkoor9aqbgolhkt63st50uo FOREIGN KEY (user_obj_id) REFERENCES user_obj (id),
    CONSTRAINT fk9c7dii8dx972l2adh2b1u23w3 FOREIGN KEY (spells_id) REFERENCES spells (id)
);
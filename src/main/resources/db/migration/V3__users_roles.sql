CREATE TABLE IF NOT EXISTS users (
                id bigserial PRIMARY KEY,
                login varchar(255),
                password varchar(255),
                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO users(login,password) VALUES
                ('TonyStark','$2a$10$e5RDEdFwOaF74m2Qp3paC.V2OfGoL7VjQ4HaWGgMS2er4ECRDgUdu'),
                ('MichaelM','$2a$10$kMsbs732fv473ey3UIyOduWiBkkiQ9I.Y5JBGXYQpA2W1ucSRpbT2'),
                ('RedFox','$2a$10$wbLqXQgL7baL3V6bpDtDd.jeGhnLqqtPK.HdL5fVT.eeXddz68DPq'),
                ('FredPerry','$2a$10$vDy1Kc1UULqoG.7hTB2dlOtoKZPk48VDv6KFf.bbSF8cQw2FnJzy6');

CREATE TABLE IF NOT EXISTS roles (
                id bigserial PRIMARY KEY,
                type varchar(255),
                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO roles(type) VALUES
                ('ROLE_ADMIN'),
                ('ROLE_MANAGER'),
                ('ROLE_USER');

CREATE TABLE IF NOT EXISTS users_roles (
            id bigserial PRIMARY KEY,
            user_id bigserial REFERENCES users(id),
            role_id bigserial,
            FOREIGN KEY (user_id) REFERENCES users(id),
            FOREIGN KEY (role_id) REFERENCES roles(id)
);
INSERT INTO users_roles(user_id,role_id) VALUES
                (1,1),
                (2,2),
                (3,3),
                (4,3);
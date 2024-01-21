CREATE TABLE IF NOT EXISTS harvests (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    season INTEGER NOT NULL,
    date DATE NOT NULL,
    plantation_id BIGINT NOT NULL,
    FOREIGN KEY (plantation_id) REFERENCES plantations(id)
);

CREATE TABLE IF NOT EXISTS user_harvests(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    plant_name varchar(60) NOT NULL,
    row INTEGER NOT NULL,
    harvest_start TIMESTAMPTZ,
    harvest_end TIMESTAMPTZ,
    harvest_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    sector_id BIGINT NOT NULL,
    FOREIGN KEY (harvest_id) REFERENCES harvests(id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (sector_id) REFERENCES areas(id)
);
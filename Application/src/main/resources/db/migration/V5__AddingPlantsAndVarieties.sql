CREATE TABLE plants (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name varchar(45) NOT NULL,
    type INTEGER NOT NULL
);

CREATE TABLE plant_varieties (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name varchar(45) NOT NULL,
    price_for_unit DOUBLE PRECISION NOT NULL,
    plant_id BIGINT NOT NULL,
    FOREIGN KEY (plant_id) REFERENCES plants(id)
);

ALTER TABLE user_harvests ADD COLUMN plant_id BIGINT NOT NULL;

ALTER TABLE user_harvests ADD CONSTRAINT fk_plant_id FOREIGN KEY (plant_id) REFERENCES plants(id);

ALTER TABLE user_harvests DROP COLUMN plant_name;
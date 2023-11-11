CREATE TABLE IF NOT EXISTS plants (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name varchar(60) NOT NULL,
    type varchar(35) NOT NULL
);

CREATE TABLE IF NOT EXISTS varieties (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name varchar(120) NOT NULL,
    plant_id BIGINT NOT NULL,
    FOREIGN KEY (plant_id) REFERENCES plants(id)
);

CREATE TABLE IF NOT EXISTS containers (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name varchar(120) NOT NULL,
    current_capacity BIGINT,
    max_capacity BIGINT NOT NULL,
    current_unit varchar(30) NOT NULL,
    predefined boolean NOT NULL,
    plantation_id BIGINT,
    owner_id BIGINT,
    plant_id BIGINT,
    FOREIGN KEY (plantation_id) REFERENCES plantations(id),
    FOREIGN KEY (owner_id) REFERENCES users(id),
    FOREIGN KEY (plant_id) REFERENCES plants(id)
);

INSERT INTO plants VALUES (nextval('plants_id_seq'), 'Jabłka', 'FRUIT');
INSERT INTO varieties VALUES (nextval('varieties_id_seq'), 'Papierówka', 1);
INSERT INTO varieties VALUES (nextval('varieties_id_seq'), 'Szampion', 1);
INSERT INTO varieties VALUES (nextval('varieties_id_seq'), 'Idared', 1);
INSERT INTO varieties VALUES (nextval('varieties_id_seq'), 'Gala', 1);

INSERT INTO plants VALUES (nextval('plants_id_seq'), 'Borówki Amerykańskie',  'FRUIT');
INSERT INTO varieties VALUES (nextval('varieties_id_seq'), 'Patriot', 2);
INSERT INTO varieties VALUES (nextval('varieties_id_seq'), 'Blue Gold', 2);
INSERT INTO varieties VALUES (nextval('varieties_id_seq'), 'Bluecrop', 2);
INSERT INTO varieties VALUES (nextval('varieties_id_seq'), 'Duke', 2);

INSERT INTO plants VALUES (nextval('plants_id_seq'), 'Pomidory',  'VEGETABLE');
INSERT INTO varieties VALUES (nextval('varieties_id_seq'), 'San Marzano', 3);
INSERT INTO varieties VALUES (nextval('varieties_id_seq'), 'Beefsteak', 3);
INSERT INTO varieties VALUES (nextval('varieties_id_seq'), 'Cherry', 3);
INSERT INTO varieties VALUES (nextval('varieties_id_seq'), 'Roma', 3);

INSERT INTO plants VALUES (nextval('plants_id_seq'), 'Marchew',  'VEGETABLE');
INSERT INTO varieties VALUES (nextval('varieties_id_seq'), 'Nantes', 4);
INSERT INTO varieties VALUES (nextval('varieties_id_seq'), 'Chantenay', 4);
INSERT INTO varieties VALUES (nextval('varieties_id_seq'), 'Danvers', 4);
INSERT INTO varieties VALUES (nextval('varieties_id_seq'), 'Imperator', 4);

INSERT INTO plants VALUES (nextval('plants_id_seq'), 'Truskawki',  'FRUIT');
INSERT INTO varieties VALUES (nextval('varieties_id_seq'), 'Albion', 5);
INSERT INTO varieties VALUES (nextval('varieties_id_seq'), 'Chandler', 5);
INSERT INTO varieties VALUES (nextval('varieties_id_seq'), 'Elsanta', 5);
INSERT INTO varieties VALUES (nextval('varieties_id_seq'), 'Honeoye', 5);

INSERT INTO containers
VALUES (nextval('containers_id_seq'), 'Skrzynka na Jabłka', 0, 20, 'KILOGRAMS', true, null, null, null);
VALUES (nextval('containers_id_seq'), 'Skrzynka na Borówki', 0, 13, 'KILOGRAMS', true, null, null, null);
VALUES (nextval('containers_id_seq'), 'Kobiałka', 0, 5, 'KILOGRAMS', true, null, null, null);
VALUES (nextval('containers_id_seq'), 'Pudełko na Pomidory', 0, 8, 'KILOGRAMS', true, null, null, null);
VALUES (nextval('containers_id_seq'), 'Taca na Warzywa liściaste', 0, 15, 'KILOGRAMS', true, null, null, null);
VALUES (nextval('containers_id_seq'), 'Skrzynia drewniana', 0, 250, 'KILOGRAMS', true, null, null, null);
VALUES (nextval('containers_id_seq'), 'Kosz plastikowy', 0, 20, 'KILOGRAMS', true, null, null, null);
VALUES (nextval('containers_id_seq'), 'BigBag', 0, 1000, 'KILOGRAMS', true, null, null, null);
CREATE TABLE IF NOT EXISTS coordinates (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    latitude DOUBLE PRECISION,
    longitude DOUBLE PRECISION
);

CREATE TABLE IF NOT EXISTS areas (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name varchar(120) NOT NULL,
    polygon_color varchar(30),
    is_main_area boolean NOT NULL
);

CREATE TABLE IF NOT EXISTS area_coordinates (
    area_id BIGINT,
    coordinate_id BIGINT,
    PRIMARY KEY (area_id, coordinate_id),
    FOREIGN KEY (area_id) REFERENCES areas(id) ON DELETE CASCADE,
    FOREIGN KEY (coordinate_id) REFERENCES coordinates(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS plantation_area (
    plantation_id BIGINT,
    area_id BIGINT,
    PRIMARY KEY (plantation_id, area_id),
    FOREIGN KEY (plantation_id) REFERENCES plantations(id) ON DELETE CASCADE,
    FOREIGN KEY (area_id) REFERENCES areas(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS plantation_sector (
    plantation_id BIGINT,
    sector_area_id BIGINT,
    PRIMARY KEY (plantation_id, sector_area_id),
    FOREIGN KEY (plantation_id) REFERENCES plantations(id) ON DELETE CASCADE,
    FOREIGN KEY (sector_area_id) REFERENCES areas(id) ON DELETE CASCADE
);
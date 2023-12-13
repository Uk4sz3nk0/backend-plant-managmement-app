ALTER TABLE harvests ADD COLUMN price_for_full_container DOUBLE PRECISION NOT NULL;

CREATE TABLE users_stats (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    collected_containers BIGINT NOT NULL DEFAULT 0,
    harvest_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (harvest_id) REFERENCES harvests(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);
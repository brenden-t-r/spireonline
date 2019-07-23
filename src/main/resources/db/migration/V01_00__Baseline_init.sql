CREATE TABLE LOGIN_HISTORY
(
    id            BIGSERIAL PRIMARY KEY,
    history_date  date NOT NULL,
    count         BIGINT
);
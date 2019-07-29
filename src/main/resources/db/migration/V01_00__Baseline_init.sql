CREATE TABLE LOGIN_HISTORY
(
    id            BIGSERIAL PRIMARY KEY,
    history_date  date NOT NULL,
    count         BIGINT,
    create_date   date NOT NULL,
    change_date   date
);
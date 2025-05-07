CREATE TABLE IF NOT EXISTS events
(
    id                  serial PRIMARY KEY,
    title               varchar(150) NOT NULL,
    description         varchar(255),
    location            varchar(255),
    start_date          timestamp  NOT NULL,
    end_date            timestamp  NOT NULL
    );
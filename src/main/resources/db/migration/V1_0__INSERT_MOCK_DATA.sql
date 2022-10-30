create table if not exists airports
(
    id                varchar(255) not null
        primary key,
    iata_code         varchar(255),
    iata_country_code varchar(255),
    name              varchar(255),
    latitude          double precision,
    longitude         double precision,
    flight_id         varchar(255)
        constraint fk_flight_id
            references flights
);

create table if not exists flights_operators
(
    id        varchar(255) not null
        primary key,
    full_name varchar(255),
    name      varchar(255)
);

create table if not exists flights
(
    id              varchar(255) not null
        primary key,
    delay           time,
    arrive_hour     time,
    date            date,
    flight_hour     time,
    arrive_location varchar(255),
    flight_location varchar(255),
    number          integer,
    price           numeric(19, 2),
    operator_id     varchar(255)
        constraint fk_operator_id
            references flights_operators
);

alter table flights_operators
    owner to "user";

alter table airports
    owner to "user";

alter table flights
    owner to "user";

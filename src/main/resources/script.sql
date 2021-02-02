create schema if not exists dops ;

create table if not exists city
(
    id   bigserial not null
        constraint city_pk
            primary key,
    name varchar(100)
);

alter table city
    owner to postgres;
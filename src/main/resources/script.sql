create schema if not exists dops;

create table if not exists dops.city
(
    id   bigserial not null
        constraint city_pk
            primary key,
    name varchar(100)
);

alter table dops.city
    owner to postgres;

create sequence if not exists
    city_column_1_seq start with 1 increment by 1;
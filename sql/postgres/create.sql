drop table if exists users cascade;
create table users (
        id  bigserial not null,
        name varchar(255),
        primary key (id)
);
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name);

--liquibase formatted sql

--changeset louise:1
create table commits (
                         id int AUTO_INCREMENT primary key,
                         description varchar(255)
);
--rollback drop table commits;

--changeset louise:2
insert into commits (id, description) values (1, 'description1');
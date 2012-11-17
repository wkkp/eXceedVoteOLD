# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table criteria (
  id                        integer auto_increment not null,
  name                      varchar(255),
  constraint pk_criteria primary key (id))
;

create table project (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  description               varchar(255),
  constraint pk_project primary key (id))
;

create table user (
  id                        bigint auto_increment not null,
  type_id                   integer,
  username                  varchar(255),
  password                  varchar(255),
  constraint pk_user primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table criteria;

drop table project;

drop table user;

SET FOREIGN_KEY_CHECKS=1;


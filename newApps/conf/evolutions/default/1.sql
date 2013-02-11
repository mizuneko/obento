# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table r_calendar (
  day                       varchar(255) not null,
  holiday_flg               boolean,
  constraint pk_r_calendar primary key (day))
;

create table e_charge (
  history_no                bigint not null,
  user_id                   varchar(255),
  charge_date               timestamp,
  amount                    bigint,
  balance                   bigint,
  charge_flg                boolean,
  constraint pk_e_charge primary key (history_no))
;

create table r_lunch (
  shop_id                   varchar(255) not null,
  lunch_no                  bigint not null,
  name                      varchar(255),
  unit_cost                 bigint)
;

create table e_order (
  order_no                  bigint not null,
  order_month               varchar(255) not null,
  user_user_id              varchar(255),
  constraint pk_e_order primary key (order_no))
;

create table e_order_detail (
  order_detail_no           bigint not null,
  orderNo                   bigint,
  lunch_no                  bigint,
  shop_id                   varchar(255),
  begin_date                timestamp,
  num                       bigint,
  order_date                timestamp,
  unit_cost                 bigint,
  constraint pk_e_order_detail primary key (order_detail_no))
;

create table r_shop (
  shop_id                   varchar(255) not null,
  name                      varchar(255),
  address                   varchar(255),
  tel                       varchar(255),
  payday                    varchar(255),
  non_work_date_start       timestamp,
  non_work_date_end         timestamp,
  constraint pk_r_shop primary key (shop_id))
;

create table r_user (
  user_id                   varchar(255) not null,
  password                  varchar(255),
  name                      varchar(255),
  charge_fix                bigint,
  charge_tmp                bigint,
  mail_address              varchar(255),
  phone_no                  varchar(255),
  admin_flg                 boolean,
  constraint pk_r_user primary key (user_id))
;

create sequence r_calendar_seq;

create sequence e_charge_seq;

create sequence r_lunch_seq;

create sequence e_order_seq;

create sequence e_order_detail_seq;

create sequence r_shop_seq;

create sequence r_user_seq;

alter table e_order add constraint fk_e_order_user_1 foreign key (user_user_id) references r_user (user_id) on delete restrict on update restrict;
create index ix_e_order_user_1 on e_order (user_user_id);
alter table e_order_detail add constraint fk_e_order_detail_order_2 foreign key (orderNo) references e_order (order_no) on delete restrict on update restrict;
create index ix_e_order_detail_order_2 on e_order_detail (orderNo);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists r_calendar;

drop table if exists e_charge;

drop table if exists r_lunch;

drop table if exists e_order;

drop table if exists e_order_detail;

drop table if exists r_shop;

drop table if exists r_user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists r_calendar_seq;

drop sequence if exists e_charge_seq;

drop sequence if exists r_lunch_seq;

drop sequence if exists e_order_seq;

drop sequence if exists e_order_detail_seq;

drop sequence if exists r_shop_seq;

drop sequence if exists r_user_seq;


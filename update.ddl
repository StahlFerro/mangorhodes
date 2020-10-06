create table operator (id varchar(36) not null, access_level integer not null, code varchar(255), code_name varchar(255), primary key (id)) engine=InnoDB

create table department (id varchar(36) not null, name varchar(50), primary key (id)) engine=InnoDB
create table keycard (id varchar(36) not null, number bigint not null, category_id varchar(36), keycards_id varchar(36), key_cards_id varchar(36), primary key (id)) engine=InnoDB
create table keycard_category (id varchar(36) not null, access_level integer not null, department_id varchar(36), primary key (id)) engine=InnoDB
alter table operator add column blood_originium_count decimal(19,2)
alter table operator add column creation_time_stamp datetime(6)
alter table operator add column hire_date datetime(6)
alter table operator add column modification_time_stamp datetime(6)
create table room (id varchar(36) not null, access_level integer not null, name varchar(255), department_id varchar(36), primary key (id)) engine=InnoDB
alter table keycard add constraint FKlhli9f1sljd4qisph9gfwwrxm foreign key (category_id) references keycard_category (id)
alter table keycard add constraint FKb7un2vjkwamvwb6nktkvlgqjb foreign key (keycards_id) references operator (id)
alter table keycard add constraint FK2yh3ervh4mto5ueaxhn53w5ds foreign key (key_cards_id) references keycard_category (id)
alter table keycard_category add constraint FKfqo0isv1xvy3gcmgxugdpqpw0 foreign key (department_id) references department (id)
alter table room add constraint FKfbxs68qt7hfp6rkqan2eqbtyq foreign key (department_id) references department (id)
create table department (id varchar(36) not null, name varchar(50), primary key (id)) engine=InnoDB
create table keycard (id varchar(36) not null, number bigint not null, category_id varchar(36), keycards_id varchar(36), key_cards_id varchar(36), primary key (id)) engine=InnoDB
create table keycard_category (id varchar(36) not null, access_level integer not null, department_id varchar(36), primary key (id)) engine=InnoDB
alter table operator add column blood_originium_count decimal(19,2)
alter table operator add column creation_time_stamp datetime(6)
alter table operator add column hire_date datetime(6)
alter table operator add column modification_time_stamp datetime(6)
create table room (id varchar(36) not null, access_level integer not null, name varchar(255), department_id varchar(36), primary key (id)) engine=InnoDB
alter table keycard add constraint FKlhli9f1sljd4qisph9gfwwrxm foreign key (category_id) references keycard_category (id)
alter table keycard add constraint FKb7un2vjkwamvwb6nktkvlgqjb foreign key (keycards_id) references operator (id)
alter table keycard add constraint FK2yh3ervh4mto5ueaxhn53w5ds foreign key (key_cards_id) references keycard_category (id)
alter table keycard_category add constraint FKfqo0isv1xvy3gcmgxugdpqpw0 foreign key (department_id) references department (id)
alter table room add constraint FKfbxs68qt7hfp6rkqan2eqbtyq foreign key (department_id) references department (id)

alter table department add column code varchar(25)

alter table department add column creation_timestamp datetime(6)
alter table department add column modification_timestamp datetime(6)

create table department (id varchar(36) not null, creation_timestamp timestamp, modification_timestamp timestamp, code varchar(25), name varchar(50), primary key (id));
create table keycard (id varchar(36) not null, creation_timestamp timestamp, modification_timestamp timestamp, number int8 not null, category_id varchar(36), keycards_id varchar(36), key_cards_id varchar(36), primary key (id));
create table keycard_category (id varchar(36) not null, creation_timestamp timestamp, modification_timestamp timestamp, access_level int4 not null, department_id varchar(36), primary key (id));
create table operator (id varchar(36) not null, creation_timestamp timestamp, modification_timestamp timestamp, access_level int4 not null, blood_originium_count numeric(19, 2), code varchar(255), code_name varchar(255), hire_date timestamp, primary key (id));
create table room (id varchar(36) not null, creation_timestamp timestamp, modification_timestamp timestamp, access_level int4 not null, name varchar(255), department_id varchar(36), primary key (id));
alter table if exists keycard add constraint FKlhli9f1sljd4qisph9gfwwrxm foreign key (category_id) references keycard_category;
alter table if exists keycard add constraint FKb7un2vjkwamvwb6nktkvlgqjb foreign key (keycards_id) references operator;
alter table if exists keycard add constraint FK2yh3ervh4mto5ueaxhn53w5ds foreign key (key_cards_id) references keycard_category;
alter table if exists keycard_category add constraint FKfqo0isv1xvy3gcmgxugdpqpw0 foreign key (department_id) references department;
alter table if exists room add constraint FKfbxs68qt7hfp6rkqan2eqbtyq foreign key (department_id) references department;
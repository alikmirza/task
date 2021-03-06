drop table if exists customers cascade;
drop table if exists payments cascade;

create table bank_worker (
                             id int4 generated by default as identity,
                             email varchar(255),
                             user_name varchar(255),
                             primary key (id)
);
create table customers (
                           id int4 not null,
                           fin varchar(255),
                           name varchar(255),
                           surname varchar(255),
                           primary key (id)
);

create table payments (
                          id int4 not null,
                          date varchar(255),
                          delay int4 not null,
                          max_amount_to_pay float8 not null,
                          monthly_amount float8 not null,
                          paid_amount float8 not null,
                          customer_id int4,
                          primary key (id)
);
alter table if exists bank_worker
    add constraint UK_rq55n01xv4g3iy2sqb4u21eg6 unique (email);

alter table if exists payments
    add constraint FK45dp0030s8e3myd8n6ky4e79g
        foreign key (customer_id)
            references customers
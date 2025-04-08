create table if not exists app_users(
    user_id bigint primary key auto_increment,
    first_name varchar(200) not null,
    last_name varchar(200) not null,
    email varchar(200) not null unique,
    password varchar(200) not null
);

insert into app_users(first_name, last_name, email, password)
values ('Ricardo','Modino','ricmod@coffeeshop.com','1234'),
       ('José María', 'Concha','jomcon@coffeeshop.com','1234');
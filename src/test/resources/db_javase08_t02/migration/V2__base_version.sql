create table author(
id serial primary key,
name varchar(40));

create table book(
id serial primary key,
name varchar(40),
author_id integer,
foreign key (author_id) references author(id));

insert into author (name)
values ('O. Henry'),
('Stanislaw Lem'),
('Bertolt Brecht'),
('Karel Capek');

insert into book (name,author_id)
values ('The third ingredient',1),
('The romance of a busy broker',1),
('Summa technologiae', 2),
('The mother',3),
('The mother',4);



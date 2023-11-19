create table if not exists book(
    id serial primary key,
    bookName varchar not null,
    author integer references author(id),
    pageNumbers integer ,
    topic TOPIC ,
    releaseDate date,
    available boolean not null
);

-- ajout de 3 lignes de données:
insert into book (bookName, author, pageNumbers, topic, releaseDate, available)
values
('Titre du Livre 1', 5, 200, 'COMEDY', '2022-01-01', true),
('Titre du Livre 2', 6, 150, 'ROMANCE', '2022-02-15', false),
('Titre du Livre 3', 7, 300, 'OTHER', '2022-03-30', true);
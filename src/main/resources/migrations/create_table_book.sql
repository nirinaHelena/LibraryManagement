create table if not exists book(
    id serial primary key,
    bookName varchar not null,
    author integer references author(id),
    pageNumbers integer ,
    topic TOPIC ,
    realeaseDate date,
    is_available boolean not null
);

-- ajout de 3 lignes de données:
insert into book (bookName, author_id, pageNumbers, topic, releaseDate, is_available)
values
('Titre du Livre 1', 1, 200, 'COMEDY', '2022-01-01', true),
('Titre du Livre 2', 2, 150, 'ROMANCE', '2022-02-15', false),
('Titre du Livre 3', 3, 300, 'OTHER', '2022-03-30', true);
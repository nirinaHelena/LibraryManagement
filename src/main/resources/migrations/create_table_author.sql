-- création de la table
create table if not exists author(
    id serial primary key,
    authorName varchar not null,
    sex char not null,
    check(
        sex='M' or 'F'
    )
);

-- ajout de 3 lignes de données:
insert into book (authorName, sex)
values
("Author 1", 'F'),
("Author 2", 'M');
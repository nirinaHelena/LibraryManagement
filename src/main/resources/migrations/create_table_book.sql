create table if not exists book(
    id serial primary key,
    bookName varchar not null,
    author integer references author(id),
    pageNumbers integer ,
    topic TOPIC ,
    realeaseDate date,
    is_available boolean not null
)
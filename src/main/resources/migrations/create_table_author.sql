create table if not exists author(
    id serial primary key,
    authorName varchar not null,
    sex char not null,
    check(
        sex='M' or 'F'
    )
);
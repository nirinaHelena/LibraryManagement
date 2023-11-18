create table if not exists subscribers(
    subscriberId serial primary key,
    subscriberName varchar not null,
    subscriberReference varchar  not null unique
);

-- ajout de 3 lignes de données:
insert into book (subscriberName)
values
('Titre du Livre 1'),
('Titre du Livre 2'),
('Titre du Livre 3');
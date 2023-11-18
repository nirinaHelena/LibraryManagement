create table if not exists subscribers(
    subscriberId serial primary key,
    subscriberName varchar not null,
    subscriberReference varchar not null
);
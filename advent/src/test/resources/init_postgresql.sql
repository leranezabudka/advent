create table if not exists public.day
(
    id serial primary key,
    date numeric(38) not null,
    activity varchar(200)
);



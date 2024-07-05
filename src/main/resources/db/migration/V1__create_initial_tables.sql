create table authors (
    id uuid not null primary key unique,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    bio varchar(255)
);

create table books (
  id uuid not null primary key unique,
  title varchar(255) not null ,
  description varchar(255) not null ,
  isbn varchar(17) not null ,
  author_id uuid not null,
  constraint fk_author foreign key(author_id) references authors(id)
);

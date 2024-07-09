alter table authors
  add column created_at timestamp not null;

alter table authors
  add column updated_at timestamp not null;

alter table books
  add column created_at timestamp not null;

alter table books
  add column updated_at timestamp not null;

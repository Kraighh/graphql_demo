insert into public.author (id, first_name, last_name)
values (1, 'Joanne', 'Rowling'),
       (2, 'Herman', 'Melville'),
       (3, 'Anne', 'Rice');

insert into public.book (id, name, page_count, author_id)
values (1, 'Harry Potter and the Philosopher''s Stone', 223, 1),
       (2, 'Moby Dick', 635, 2),
       (3, 'Interview with the vampire', 371, 3);

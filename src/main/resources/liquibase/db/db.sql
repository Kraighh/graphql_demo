CREATE TABLE book
(
    id         int NOT NULL,
    name       varchar(255) NOT NULL,
    page_count int          NOT NULL,
    author_id  int NOT NULL
);

ALTER TABLE book ADD CONSTRAINT book_pk PRIMARY KEY (id);

CREATE TABLE author
(
    id   int NOT NULL,
    first_name varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL
);

ALTER TABLE author ADD CONSTRAINT author_pk PRIMARY KEY (id);

ALTER TABLE book ADD CONSTRAINT book_author_fk FOREIGN KEY (author_id) REFERENCES author (id);

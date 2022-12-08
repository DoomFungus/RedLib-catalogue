CREATE TABLE IF NOT EXISTS rl_book   (
    id      INTEGER PRIMARY KEY,
    name    VARCHAR(1024),
    summary TEXT
);

CREATE TABLE IF NOT EXISTS rl_author  (
                                         id      INTEGER PRIMARY KEY,
                                         name    VARCHAR(1024)
);

CREATE TABLE IF NOT EXISTS rl_book_author  (
                                          id      INTEGER PRIMARY KEY,
                                          book_id INTEGER,
                                          author_id INTEGER
);

ALTER TABLE rl_book_author
    DROP CONSTRAINT IF EXISTS rl_book_author_book,
    ADD CONSTRAINT rl_book_author_book FOREIGN KEY (book_id) REFERENCES rl_book,
    DROP CONSTRAINT IF EXISTS rl_book_author_author,
    ADD CONSTRAINT rl_book_author_author FOREIGN KEY (author_id) REFERENCES rl_author;
CREATE TABLE posts(
  id BIGSERIAL PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  date_created DATE DEFAULT NOW(),
  description TEXT NOT NULL,
  body TEXT NOT NULL
);
ALTER TABLE posts OWNER TO easyblog;

INSERT INTO posts (title, description, body) VALUES ('Yeaaah, I like this SQL', 'This post just for test ok?', 'So, what do you want');
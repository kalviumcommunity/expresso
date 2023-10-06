-- Creates a new database called expresso_local.
CREATE database expresso_server;

-- Uses the expresso_local database.
USE expresso_server;

-- Creates a table to store user information.
CREATE TABLE users (
  -- The unique identifier for the user.
  user_id INT NOT NULL AUTO_INCREMENT,
  -- The username of the user.
  username VARCHAR(255) NOT NULL,
  -- The email address of the user.
  email VARCHAR(255) NOT NULL UNIQUE,
  -- The password of the user.
  password VARCHAR(255) NOT NULL,
  -- The date and time when the user was created.
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (user_id)
);

-- Creates a table to store the categories of blog posts.
CREATE TABLE category (
  -- The unique identifier for the category.
  category_id INT NOT NULL AUTO_INCREMENT,
  -- The name of the category.
  category TEXT NOT NULL,
  PRIMARY KEY (category_id)
);
-- Creates a table to store blog posts.
CREATE TABLE blogs (
  -- The unique identifier for the blog post.
  blog_id INT NOT NULL AUTO_INCREMENT UNIQUE,
  -- The title of the blog post.
  blog_title VARCHAR(255) NOT NULL,
  -- The content of the blog post.
  blog_content TEXT NOT NULL,
  -- The user ID of the user who created the blog post.
  user_id INT NOT NULL,
  -- The date and time when the blog post was created.
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  -- The ID of the category that the blog post belongs to.
  category_id INT NOT NULL,
  PRIMARY KEY (blog_id),
  FOREIGN KEY (user_id) REFERENCES users(user_id),
  FOREIGN KEY (category_id) REFERENCES category(category_id)
);

-- Creates a table to store likes on blog posts.
CREATE TABLE likes (
  -- The unique identifier for the blog post.
  blog_id INT NOT NULL,
  -- The user ID of the user who liked the blog post.
  user_id INT NOT NULL,
  -- The primary key for the table.
  PRIMARY KEY (blog_id, user_id),
  -- A foreign key constraint that references the blog_id column in the blogs table.
  FOREIGN KEY (blog_id) REFERENCES blogs(blog_id),
  -- A foreign key constraint that references the user_id column in the users table.
  FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- Creates a table to store comments on blog posts.
CREATE TABLE comments (
  -- The unique identifier for the comment.
  comment_id INT NOT NULL AUTO_INCREMENT,
  -- The text of the comment.
  comment_ TEXT NOT NULL,
  -- The date and time when the comment was created.
  commented_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  -- The user ID of the user who created the comment.
  user_id INT NOT NULL,
  -- The ID of the blog post that the comment is associated with.
  blog_id INT NOT NULL,
  PRIMARY KEY (comment_id),
  FOREIGN KEY (user_id) REFERENCES users(user_id),
  FOREIGN KEY (blog_id) REFERENCES blogs(blog_id)
);

-- Adds a new column to the blogs table to store the number of likes that each blog post has received.
ALTER TABLE blogs ADD COLUMN likes INT NOT NULL DEFAULT 0;

-- Drops the likes table.
DROP TABLE likes;

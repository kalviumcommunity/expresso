const mysql = require("mysql2");

const db = mysql
  .createPool({
    host: process.env.MYSQL_HOST,
    user: process.env.MYSQL_USER,
    password: process.env.MYSQL_PASSWORD,
    database: process.env.MYSQL_DATABASE,
  })
  .promise();

// User database function
async function getUsers() {
  try {
    const [users] = await db.query("SELECT * FROM users");
    return users;
  } catch (e) {
    return e;
  }
}

//Getting a user by id
async function getUserById(id) {
  try {
    const [user] = await db.query("SELECT * FROM users WHERE user_id = ?", [
      id,
    ]);
    return user;
  } catch (e) {
    return e;
  }
}

//signing up a new user
async function postUser(username, email, password) {
  try {
    const user = await db.query(
      "INSERT INTO users (username, email, password) VALUES (?, ?, ?)",
      [username, email, password]
    );
    return user;
  } catch (e) {
    console.error(e.code);
    return e;
  }
}

//getting a new user by email
async function getUserByEmail(email) {
  try {
    const [user] = await db.query("SELECT * FROM users WHERE email = ?", [
      email,
    ]);
    return user;
  } catch (e) {
    console.error(e.code);
    return e;
  }
}

//deleting an existing user
async function deleteUser(id) {
  try {
    const deletedUser = await db.query("DELETE FROM users WHERE user_id = ?", [
      id,
    ]);
    return deletedUser;
  } catch (e) {
    return e;
  }
}

//get all categories in the table
async function getAllCategories() {
  try {
    const [categories] = await db.query("SELECT * FROM category");
    return categories;
  } catch (e) {
    return e;
  }
}

//post a new category
async function postNewCategory(category) {
  try {
    const newCategory = await db.query(
      "INSERT INTO category (category) VALUE (?)",
      [category]
    );
    return newCategory;
  } catch (e) {
    return e;
  }
}

//getting all blogs from the database
async function getBlogs() {
  try {
    const [blogs] = await db.query("SELECT * FROM blogs");
    return blogs;
  } catch (e) {
    return e;
  }
}

//posting a new blog
async function postBlog(blog_title, blog_content, user_id, category_id) {
  try {
    const newBlog = await db.query(
      "INSERT INTO blogs (blog_title, blog_content, user_id, category_id) VALUE (?, ?, ?, ?)",
      [blog_title, blog_content, user_id, category_id]
    );
    return newBlog;
  } catch (e) {
    return e;
  }
}

//getting a blog from database by blog_id
async function getBlogById(blog_id) {
  try {
    const [blog] = await db.query("SELECT * FROM blogs WHERE blog_id  = ?", [
      blog_id,
    ]);
    return blog;
  } catch (e) {
    return e;
  }
}

//deleting a blog from the database
async function deleteBlog(id) {
  try {
    const [deletedBlog] = await db.query(
      "DELETE FROM blogs WHERE blog_id = ?",
      [id]
    );
    return deletedBlog;
  } catch (e) {
    return e;
  }
}

//Comment adding to the backend server
async function postComment(comment_, user_id, blog_id) {
  try {
    const [newComment] = await db.query(
      "INSERT INTO comments (comment_, user_id, blog_id) VALUE (?, ?, ?)",
      [comment_, user_id, blog_id]
    );
    return newComment;
  } catch (e) {
    return e;
  }
}

module.exports = {
  getUsers,
  postUser,
  deleteUser,
  getUserById,
  getUserByEmail,
  getAllCategories,
  postNewCategory,
  getBlogs,
  postBlog,
  getBlogById,
  deleteBlog,
  postComment,
};

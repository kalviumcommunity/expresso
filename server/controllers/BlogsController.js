const express = require("express");
const router = express.Router();
const {
  getBlogs,
  postBlog,
  getBlogById,
  deleteBlog,
} = require("../db/connection");
const { authenticateToken } = require("../middlewares/Authorization");

//getting all blogs
router.get("/", async (req, resp) => {
  try {
    const blogs = await getBlogs();
    if (blogs.length == 0) {
      resp.status(201).json({ message: "No blogs" });
    } else {
      resp.status(201).json(blogs);
    }
  } catch (e) {
    resp.status(500).json({ error: "Internal server error" });
  }
});

//posting a new blog
router.post("/post", authenticateToken, async (req, resp) => {
  const { blog_title, blog_content, user_id, category_id } = req.body;
  try {
    const newBlog = await postBlog(
      blog_title,
      blog_content,
      user_id,
      category_id
    );
    if (newBlog != null && newBlog.code == "ER_BAD_NULL_ERROR") {
      const empty = newBlog.message.split(" ")[1].slice(1, -1);
      resp.status(201).json({ error: `Please provide ${empty}` });
    } else {
      resp.status(201).json(newBlog);
    }
  } catch (e) {
    resp.status(500).json({ error: "Internal server error" });
  }
});

//getting a blog by id
router.get("/:id", authenticateToken, async (req, resp) => {
  const { id } = req.params;
  try {
    const blog = await getBlogById(id);
    if (blog.length == 0) {
      resp.status(401).json({ error: `No blog(s) with blog_id ${id}` });
    } else {
      resp.status(201).json(blog);
    }
  } catch (e) {
    resp.status(500).json({ error: "Internal server error" });
  }
});

//deleting a blog
router.delete("/:id", authenticateToken, async (req, resp) => {
  const { id } = req.params;
  try {
    const deletedBlog = await deleteBlog(id);
    if (deletedBlog && deletedBlog.affectedRows == 0) {
      resp.status(401).json({ error: "No such blog to delete." });
    } else {
      resp.status(201).json(deletedBlog);
    }
  } catch (e) {
    resp.status(500).json({ error: e.message });
  }
});

module.exports = router;

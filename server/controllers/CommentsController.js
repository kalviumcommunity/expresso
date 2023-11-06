const express = require("express");
const router = express.Router();
const { authenticateToken } = require("../middlewares/Authorization");
const { postComment } = require("../db/connection");

router.post("/post", authenticateToken, async (req, resp) => {
  const { comment, user_id, blog_id } = req.body;
  try {
    const newComment = await postComment(comment, user_id, blog_id);
    resp.status(201).json(newComment);
  } catch (e) {
    resp.status(500).json({ error: e.message });
  }
});

module.exports = router;

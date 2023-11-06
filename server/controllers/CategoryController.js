const express = require("express");
const router = express.Router();
const { getAllCategories, postNewCategory } = require("../db/connection");
const { authenticateToken } = require("../middlewares/Authorization");

router.get("/", async (res, resp) => {
  try {
    const category = await getAllCategories();
    if (category.length == 0) {
      resp.status(203).json({ message: "No categories." });
    } else {
      resp.status(201).json(category);
    }
  } catch (e) {
    resp.status(500).json({ error: "Internal server error" });
  }
});

router.post("/new", authenticateToken, async (req, resp) => {
  const { category } = req.body;
  try {
    const newCategory = await postNewCategory(category);
    resp.status(201).json({ message: `${category} added succesfully.` });
  } catch (e) {
    resp.status(500).json({ error: "Internal server error" });
  }
});

module.exports = router;

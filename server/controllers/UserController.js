const express = require("express");
const router = express.Router();
const bcrypt = require("bcrypt");
const jwt = require("jsonwebtoken");
const {
  getUsers,
  postUser,
  deleteUser,
  getUserById,
  getUserByEmail,
} = require("../db/connection");

const { authenticateToken } = require("../middlewares/Authorization");

router.get("/", async (req, resp) => {
  try {
    const users = await getUsers();
    resp.status(201).json(users);
  } catch (e) {
    resp.status(500).json({ error: e.message });
  }
});

//getting an existing user
router.get("/:id", async (req, resp) => {
  const { id } = req.params;
  try {
    const [user] = await getUserById(id);
    if (!user) {
      resp.status(401).json({ error: "No such user exists." });
    } else {
      resp.status(200).json(user);
    }
  } catch (e) {
    resp.status(500).json({ error: e.message });
  }
});

//deleting an existing user.
router.delete("/delete/:id", authenticateToken, async (req, resp) => {
  const { id } = req.params;
  try {
    const deleteUserById = await deleteUser(id);
    if (deleteUserById[0].affectedRows == 0) {
      resp.status(401).json({ error: "Error Deleting user, No such user exists." });
    } else if (deleteUserById[0].affectedRows == 1) {
      resp.status(201).json({ message: "Deleted user successfully." });
    }
  } catch (e) {
    console.error(e); // Log the error for debugging purposes
    resp.status(500).json({ error: e.message });
  }
});

//signing up new user
router.post("/sign_up", async (req, resp) => {
  const { username, email, password } = req.body;
  const hashedPassword = await bcrypt.hash(password, 10);
  try {
    const newUser = await postUser(username, email, hashedPassword);
    if (newUser.code !== null && newUser.code === "ER_DUP_ENTRY") {
      resp.status(403).json({ error: "Email already in use." });
    } else {
      const token = jwt.sign({ email }, process.env.SECRET_KEY, {
        expiresIn: "1h",
      });
      resp.status(201).json({ newUser, token });
    }
  } catch (e) {
    resp.status(500).send({ error: e.message });
  }
});

//logging a user in
router.post("/login", async (req, resp) => {
  const { email, password } = req.body;
  try {
    const getUser = await getUserByEmail(email);
    if (getUser.length == 0) {
      resp.status(401).json({ error: "No such user exists." });
    } else {
      const login = await bcrypt.compare(password, getUser[0].password);
      if (login) {
        const accessToken = jwt.sign({ email }, process.env.SECRET_KEY, {
          expiresIn: "1d",
        });
        const refreshToken = jwt.sign(
          { email },
          process.env.REFRESH_SECRET_KEY,
          { expiresIn: "7d" }
        );
        resp.status(201).json({ getUser, accessToken, refreshToken });
      } else {
        resp.status(401).json({ error: "Email or password is incorrect" });
      }
    }
  } catch (e) {
    resp.status(500).json({ error: e.message });
  }
});

module.exports = router;

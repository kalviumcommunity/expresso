const express = require("express");
const router = express.Router();
const jwt = require("jsonwebtoken");

//generating refresh token flow.
router.post("/refresh", async (req, resp) => {
  const { refresh_token, email } = req.body;

  jwt.verify(refresh_token, process.env.REFRESH_SECRET_KEY, (err, user) => {
    if (err) {
      return resp.status(403).json({ message: "Invalid token." });
    }

    const accessToken = jwt.sign({ email }, process.env.SECRET_KEY, {
      expiresIn: "1d",
    });
    resp.status(201).json({ accessToken });
  });
});

module.exports = router;

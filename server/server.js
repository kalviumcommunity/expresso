require("dotenv").config();
const express = require("express");
const app = express();
const cors = require("cors");
app.use(cors());

const PORT = process.env.PORT;

app.get("/", (req, resp) => {
  console.log(req.path);
  resp.json({ greeting: "Hello User" });
});

app.listen(PORT, () => {
  console.log(`Listening on Port:${PORT}`);
});

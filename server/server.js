require("dotenv").config();
const express = require("express");
const app = express();
const cors = require("cors");
const userRouter = require("./controllers/UserController");
const categoryRouter = require("./controllers/CategoryController");
const blogsController = require("./controllers/BlogsController");
const bodyParser = require("body-parser");
app.use(cors());
app.use(express.json());
app.use(bodyParser.json());
const PORT = process.env.PORT;

app.use("/api/v1/users", userRouter);
app.use("/api/v1/category", categoryRouter);
app.use("/api/v1/blogs", blogsController);

app.listen(PORT, () => {
  console.log(`Listening on Port:${PORT}`);
});

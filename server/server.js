require("dotenv").config();
const express = require("express");
const app = express();
const cors = require("cors");
const userRouter = require("./controllers/UserController");
const categoryRouter = require("./controllers/CategoryController");
const blogsController = require("./controllers/BlogsController");
const commentsController = require("./controllers/CommentsController");
const tokenController = require("./controllers/TokenController");
const bodyParser = require("body-parser");
app.use(cors());
app.use(express.json());
app.use(bodyParser.json());
const PORT = process.env.PORT;

app.use("/api/v1/users", userRouter);
app.use("/api/v1/category", categoryRouter);
app.use("/api/v1/blogs", blogsController);
app.use("/api/v1/comments", commentsController);
app.use("/api/v1/token", tokenController);

app.listen(PORT, () => {
  console.log(`Listening on Port:${PORT}`);
});

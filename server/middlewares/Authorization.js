const jwt = require("jsonwebtoken");

function authenticateToken(req, res, next) {
  const authHeader = req.header("Authorization");
  if (!authHeader) {
    return res.status(401).json({ error: "Unauthorized Access." });
  }
  const token = authHeader.split(" ")[1];
  if (!token) {
    return res.status(401).json({ error: "Unauthorized Access." });
  }

  jwt.verify(token, process.env.SECRET_KEY, (err, user) => {
    if (err) {
      console.log(token === req.header("Authorization"));
      return res.status(403).json({ error: "Access Denied." });
    }
    req.user = user;
    next();
  });
}

module.exports = { authenticateToken };

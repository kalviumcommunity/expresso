export const getBlogs = `
SELECT blogs.blog_id, blogs.blog_title, blogs.blog_content, users.username, category.category
FROM blogs
INNER JOIN users ON blogs.user_id = users.user_id
INNER JOIN category ON blogs.category_id = category.category_id`;

export const getCommentsCount = `SELECT blogs.blog_id, blogs.blog_title, COUNT(comments.comment_id) AS comment_count
FROM blogs
LEFT JOIN comments ON blogs.blog_id = comments.blog_id
GROUP BY blogs.blog_id, blogs.blog_title;`;

export const getBlogsWithMoreLikesThanComments = `SELECT blogs.blog_id, blogs.blog_title, blogs.likes, COUNT(comments.comment_id) AS comment_count
FROM blogs
LEFT JOIN comments ON blogs.blog_id = comments.blog_id
GROUP BY blogs.blog_id, blogs.blog_title, blogs.likes
HAVING blogs.likes > comment_count;
`;

export const getUserWhoLikedSpecificBlog = `SELECT users.username
FROM likes
INNER JOIN users ON likes.user_id = users.user_id
WHERE likes.blog_id = 123; -- Replace 123 with the specific blog_id
`;

export const getBlogWithLatestComment = `SELECT blogs.blog_id, blogs.blog_title, MAX(comments.commented_at) AS latest_comment_time
FROM blogs
LEFT JOIN comments ON blogs.blog_id = comments.blog_id
GROUP BY blogs.blog_id, blogs.blog_title;
`;

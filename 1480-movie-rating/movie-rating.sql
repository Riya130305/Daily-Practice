-- FIRST QUESTION SOLUTION INDIVIDUALLY

-- SELECT u.name as results
-- FROM Users u
-- JOIN MovieRating m
-- ON u.user_id = m.user_id
-- GROUP BY u.user_id, u.name
-- HAVING COUNT(*) = (
--     SELECT MAX(cnt)
--     FROM (
--         SELECT COUNT(*) AS cnt
--         FROM MovieRating
--         GROUP BY user_id
--     ) t
-- )
-- ORDER BY u.name
-- LIMIT 1;

(
    SELECT u.name AS results
    FROM Users u
    JOIN MovieRating mr
    ON u.user_id = mr.user_id
    GROUP BY u.user_id, u.name
    ORDER BY COUNT(*) DESC, u.name ASC
    LIMIT 1
)

UNION ALL

(
    SELECT m.title AS results
    FROM Movies m
    JOIN MovieRating mr
    ON m.movie_id = mr.movie_id
    WHERE mr.created_at >= '2020-02-01'
      AND mr.created_at < '2020-03-01'
    GROUP BY m.movie_id, m.title
    ORDER BY AVG(mr.rating) DESC, m.title ASC
    LIMIT 1
);
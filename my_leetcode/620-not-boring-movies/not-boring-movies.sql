# Write your MySQL query statement below
-- SELECT id, movie, description, rating
-- FROM Cinema c
-- WHERE c.id%2 != 0 AND c.description != 'boring'
-- ORDER BY rating DESC;

SELECT *
FROM Cinema
WHERE id % 2 = 1
  AND description <> 'boring'
ORDER BY rating DESC;
# Write your MySQL query statement below
SELECT w1.id
FROM Weather as w1
JOIN Weather as w2
ON DATEDIFF(w1.recordDate, w2.recordDate) = 1
WHERE w1.temperature > w2.temperature;

-- SELECT id
-- FROM (
--     SELECT id,
--            recordDate,
--            temperature,
--            LAG(recordDate) OVER (ORDER BY recordDate) AS prevDate,
--            LAG(temperature) OVER (ORDER BY recordDate) AS prevTemp
--     FROM Weather
-- ) t
-- WHERE DATEDIFF(recordDate, prevDate) = 1
--   AND temperature > prevTemp;
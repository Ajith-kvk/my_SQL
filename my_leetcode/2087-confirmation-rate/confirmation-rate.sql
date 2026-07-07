# Write your MySQL query statement below
SELECT s.user_id,
    ROUND(
        IFNULL(
            AVG(
                CASE 
                    WHEN c.action = 'confirmed' THEN 1
                    WHEN c.action = 'timeout' THEN 0
                END
            ),0    
        ),
    2) AS confirmation_rate
FROM Signups s
LEFT JOIN Confirmations c
ON s.user_id = c.user_id
GROUP BY s.user_id;
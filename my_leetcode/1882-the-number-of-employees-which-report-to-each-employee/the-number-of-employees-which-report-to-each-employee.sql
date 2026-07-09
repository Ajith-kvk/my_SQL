# Write your MySQL query statement below
SELECT e.employee_id, 
    e.name, 
    COUNT(*) AS reports_count, 
    ROUND(AVG(r.age)) AS average_age
FROM Employees AS e
JOIN Employees AS r
ON e.employee_id = r.reports_to
GROUP BY e.employee_id
ORDER BY e.employee_id;
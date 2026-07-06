# Write your MySQL query statement below
SELECT unique_id, name
FROM Employees as e
LEFT JOIN EmployeeUNI as uni
ON e.id = uni.id;


-- SELECT eu.unique_id, e.name
-- FROM Employees e
-- LEFT JOIN EmployeeUNI eu
-- ON e.id = eu.id;
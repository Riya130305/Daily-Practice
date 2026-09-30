# Write your MySQL query statement below
-- select e.employee_id
-- from Employees e
-- left join Employees m
-- on e.manager_id = m.employee_id
-- where e.salary < 30000
-- and m.employee_id is null
-- order by e.employee_id;


SELECT e.employee_id
FROM Employees e
LEFT JOIN Employees m
    ON e.manager_id = m.employee_id
WHERE (e.salary < 30000 and e.manager_id is not null)
AND m.employee_id IS NULL
ORDER BY e.employee_id;
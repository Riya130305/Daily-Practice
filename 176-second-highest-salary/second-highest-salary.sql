-- SELECT coalesce(salary,null) as SecondHighestSalary
--  FROM (
--  	SELECT salary,
--         	DENSE_RANK() OVER (ORDER BY salary DESC) AS rnk
--  	FROM Employee
--  ) x
--  WHERE rnk = 2;

select (
    SELECT Distinct salary
    from Employee
    order by salary desc
    limit 1 offset 1
) as SecondHighestSalary;

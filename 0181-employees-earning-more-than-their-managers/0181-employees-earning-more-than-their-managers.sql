# Write your MySQL query statement below
Select e1.name as "Employee" from Employee e1
INNER JOIN Employee e2 
ON e2.id=e1.managerID
WHERE e1.salary > e2.salary
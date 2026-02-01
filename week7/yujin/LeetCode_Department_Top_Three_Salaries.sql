
with E as (
SELECT
    name
    , salary
    , departmentId
    , dense_rank() over (partition by departmentId order by salary desc) rn
From
    Employee
)
SELECT 
    D.name as Department
    , E.name as Employee
    , E.salary as Salary
FROM E
INNER JOIN Department as D on d.id = E.departmentId
WHERE rn <= 3
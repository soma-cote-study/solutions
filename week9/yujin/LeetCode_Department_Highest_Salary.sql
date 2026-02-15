-- 각 부서에서 가장 높은 급여를 받는 직원을 찾는 솔루션을 작성하세요.
-- 결과 테이블을 어떤 순서 로든 반환합니다 .
-- 결과 형식은 다음 예시와 같습니다.

select d.Department, d.Employee, d.Salary
from (select d.name as Department, e.name as Employee, e.salary as Salary,  
    dense_rank() over (partition by d.name order by e.salary desc) as rnk
from Employee as e
join Department as d on d.id = e.departmentId) as d
where rnk = 1

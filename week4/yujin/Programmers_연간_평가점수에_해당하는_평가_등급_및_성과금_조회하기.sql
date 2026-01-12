select k.emp_no, k.emp_name, k.grade, 
        case 
          when k.grade = 'S' then k.sal *0.2
          when k.grade = 'A' then k.sal *0.15
          when k.grade = 'B' then k.sal *0.1
          else k.sal *0
          end as bonus
from (select e.emp_no, e.emp_name, e.position, e.email, e.sal,
        case 
          when g.score >= 96 then 'S'
          when g.score >= 90 then 'A'
          when g.score >= 80 then 'B'
          else 'C'
          end as grade
    from hr_grade as g, HR_EMPLOYEES as e
    where g.emp_no = e.emp_no) as k
order by k.emp_no
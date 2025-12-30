select e.id, ifnull(ec.cnt,0) as child_count
from ecoli_data as e
left join  (select parent_id, count(parent_id) as cnt
     from ecoli_data
     where parent_id is not null
     group by parent_id ) as ec
on e.id = ec.parent_id
order by e.id asc
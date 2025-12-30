select t.id
from ecoli_data as f
join ecoli_data as s on f.id = s.parent_id
join ecoli_data as t on s.id = t.parent_id
where f.parent_id is null 
order by t.id
select id
from ecoli_data
where parent_id in (select ed.id
from (select id from ecoli_data where parent_id is null ) as k
join ecoli_data as ed on ed.parent_id = k.id)
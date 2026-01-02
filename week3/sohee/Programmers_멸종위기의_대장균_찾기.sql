with recursive ecoli_data_hierarchy as (
    select id, parent_id, 1 as generation
    from ecoli_data
    where parent_id is null

    union all

    select ed.id, ed.parent_id, edh.generation + 1 as generation
    from ecoli_data ed
    join ecoli_data_hierarchy edh on ed.parent_id = edh.id
)

select count(*) as count, generation
from ecoli_data_hierarchy edh
left join ecoli_data ed on edh.id = ed.parent_id
where ed.id is null
group by generation
order by generation;

select f.id, n.fish_name, f.length
from fish_info as f
join fish_name_info as n on n.fish_type = f.fish_type
where (f.fish_type, f.length) in(
    select fish_type, max(length)
    from fish_info
    group by fish_type
)
order by f.id;

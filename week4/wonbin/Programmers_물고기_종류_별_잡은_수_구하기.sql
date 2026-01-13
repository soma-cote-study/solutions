select count(I.fish_type) as fish_count, f.fish_name
from fish_info as i
join fish_name_info as f on f.fish_type = i.fish_type
group by f.fish_name
order by fish_count desc;
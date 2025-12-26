select count(*) as 'FISH_COUNT'
from fish_info as i
join fish_name_info as n on n.fish_type = i.fish_type
where n.fish_name in ('BASS', 'SNAPPER');
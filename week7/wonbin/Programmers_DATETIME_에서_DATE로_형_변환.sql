SELECT animal_id, name, substring(datetime, 1, 10) as '날짜'
from animal_ins
order by animal_id;
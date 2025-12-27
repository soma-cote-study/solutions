select c.item_id, c.item_name, c.rarity
from item_tree as t
join item_info as p on p.item_id = t.parent_item_id and p.rarity = 'RARE'
join item_info as c on c.item_id = t.item_id
order by c.item_id desc;
select c.item_id, c.item_name, c.rarity
from item_info as i
join item_tree as t on i.item_id = t.parent_item_id
join item_info as c on t.item_id = c.item_id
where i.rarity = 'RARE'
order by c.item_id desc;

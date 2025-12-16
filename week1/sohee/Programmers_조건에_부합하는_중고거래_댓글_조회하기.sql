select b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, date_format(r.CREATED_DATE, "%Y-%m-%d") as CREATED_DATE
from USED_GOODS_BOARD as b
join USED_GOODS_REPLY as r on b.BOARD_ID = r.BOARD_ID
where b.CREATED_DATE like '2022-10-%'
order by r.CREATED_DATE asc, b.TITLE asc;
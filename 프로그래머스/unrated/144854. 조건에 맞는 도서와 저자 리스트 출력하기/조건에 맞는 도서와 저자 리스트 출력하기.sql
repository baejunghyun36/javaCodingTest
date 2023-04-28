-- 코드를 입력하세요
SELECT b.book_id, a.author_name, date_format(published_date, '%Y-%m-%d')
from book b join author a on b.author_id = a.author_id
where b.category in ('경제')
order by published_date;


# SELECT 
# b.BOOK_ID AS BOOK_ID,
# a.AUTHOR_NAME AS AUTHOR_NAME,
# TO_CHAR(b.PUBLISHED_DATE, 'yyyy-mm-dd') AS PUBLISHED_DATE
# FROM BOOK b
# JOIN AUTHOR a
# ON b.AUTHOR_ID = a.AUTHOR_ID
# WHERE b.CATEGORY = '경제'
# ORDER BY PUBLISHED_DATE
# ;
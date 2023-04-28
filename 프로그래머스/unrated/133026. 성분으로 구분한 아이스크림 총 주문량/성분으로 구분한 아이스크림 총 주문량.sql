-- 코드를 입력하세요
SELECT ingredient_type, sum(total_order)
from first_half f
left join icecream_info i
on f.flavor = i.flavor
group by i.ingredient_type


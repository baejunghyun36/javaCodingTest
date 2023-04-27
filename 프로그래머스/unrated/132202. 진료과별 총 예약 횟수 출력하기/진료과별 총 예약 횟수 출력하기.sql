select mcdp_cd as "진료과코드", count(mcdp_cd)
from appointment
WHERE APNT_YMD LIKE '2022-05%'
group by mcdp_cd
order by count(mcdp_cd), mcdp_cd
SELECT a.name, a.datetime
FROM animal_ins a
LEFT JOIN animal_outs b ON a.animal_id = b.animal_id
WHERE b.SEX_UPON_OUTCOME IS NULL
order by a.datetime
limit 3


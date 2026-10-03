# Write your MySQL query statement below
select person_id as id, count(*) as num
from(
    select requester_id as person_id
    from RequestAccepted

    Union all

    select accepter_id  as person_id
    from RequestAccepted
) as l
group by person_id
order by num desc
limit 1;
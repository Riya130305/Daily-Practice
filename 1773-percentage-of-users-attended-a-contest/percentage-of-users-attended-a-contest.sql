# Write your MySQL query statement below
with ctc as (
    select count(*) as total_user 
    from Users
) 

select r.contest_id, round(count(r.contest_id)/c.total_user* 100,2) as percentage  
from Users u
join Register r
on u.user_id = r.user_id
cross join ctc c
group by r.contest_id,c.total_user
order by percentage DESC, contest_id asc;
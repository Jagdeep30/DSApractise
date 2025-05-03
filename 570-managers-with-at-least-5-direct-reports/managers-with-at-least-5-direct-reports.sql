# Write your MySQL query statement below
select r.name
from Employee e, Employee r
where e.managerId = r.id
group by r.id
having count(r.id)>=5
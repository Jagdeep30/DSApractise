# Write your MySQL query statement below
select a.machine_id, round(avg(b.timestamp - a.timestamp), 3) as processing_time
from Activity a, Activity b
where a.process_id = b.process_id and a.machine_id = b.machine_id and a.activity_type = "start" && b.activity_type = "end"
group by a.machine_id
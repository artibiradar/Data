

cust = Load '/home/hduser/custs' using PigStorage(',') as (custno:chararray, firstname, lastname, age:int, profession:chararray);

dump cust;




Lawyers, 100
Pilot, 95
Teachers 80

groupbyprofession = group cust by profession;


4000001,Kristina,Chung,55,Pilot
4000002,Paige,Chen,74,Teacher
4000003,Sherri,Melton,34,Firefighter
4000004,Gretchen,Hill,66,Computer hardware engineer
4000005,Karen,Puckett,74,Lawyer
4000006,Patrick,Song,42,Veterinarian
4000007,Elsie,Hamilton,43,Pilot


Pilot, {(4000001,Kristina,Chung,55,Pilot), (4000007,Elsie,Hamilton,43,Pilot)}

countbyprofession = foreach groupbyprofession generate group as profession, COUNT(cust) as headcount  ;

dump countbyprofession;

orderbycount = order countbyprofession by headcount desc;

store orderbycount into 'niit/pig/part2' using PigStorage(',');


/home/hduser/home/hduser/niit/pig/part1


















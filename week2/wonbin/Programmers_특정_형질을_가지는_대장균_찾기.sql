select count(*) as count
from ecoli_data
where (genotype & (1 | 4)) > 0 and (genotype & 2) = 0;
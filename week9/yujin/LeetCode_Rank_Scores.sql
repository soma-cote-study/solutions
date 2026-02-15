-- 점수 순위를 구하는 풀이를 작성하세요. 순위는 다음 규칙에 따라 계산해야 합니다.

-- 점수는 높은 점수부터 낮은 점수 순으로 순위를 매겨야 합니다.
-- 두 점수가 동점일 경우, 두 점수 모두 동일한 순위를 부여받아야 합니다.
-- 동점일 경우, 다음 순위는 바로 다음 연속된 정수 값이어야 합니다. 즉, 순위 사이에 공백이 없어야 합니다.
-- 결과 테이블을 score내림차순으로 정렬하여 반환합니다.

select score , dense_rank() over (order by score desc) as 'rank'
from Scores
order by score desc
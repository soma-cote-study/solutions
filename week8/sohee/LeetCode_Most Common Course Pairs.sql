-- 1) 우수 학생: 5개 이상 코스 완료 + 평균 평점 >= 4
WITH top_students AS (
    SELECT user_id
    FROM course_completions
    GROUP BY user_id
    HAVING COUNT(*) >= 5 AND AVG(course_rating) >= 4
),
-- 2) 우수 학생의 코스를 날짜순 정렬 후 LEAD로 다음 코스 가져오기
sequenced AS (
    SELECT
        cc.user_id,
        cc.course_name,
        LEAD(cc.course_name) OVER (
            PARTITION BY cc.user_id
            ORDER BY cc.completion_date
        ) AS next_course
    FROM course_completions cc
    JOIN top_students ts ON cc.user_id = ts.user_id
)
-- 3) 연속 쌍별 빈도 집계
SELECT
    course_name AS first_course,
    next_course AS second_course,
    COUNT(*) AS transition_count
FROM sequenced
WHERE next_course IS NOT NULL
GROUP BY course_name, next_course
ORDER BY transition_count DESC, first_course ASC, second_course ASC;
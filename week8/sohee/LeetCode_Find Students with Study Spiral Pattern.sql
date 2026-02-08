-- 1) 날짜순 정렬 후 이전 행과의 날짜 차이 계산
WITH ranked AS (
    SELECT
        ss.student_id,
        ss.subject,
        ss.session_date,
        ss.hours_studied,
        DATEDIFF(
            ss.session_date,
            LAG(ss.session_date) OVER (PARTITION BY ss.student_id ORDER BY ss.session_date)
        ) AS date_diff
    FROM study_sessions ss
),
-- 2) 날짜 gap > 2이면 새 그룹 시작 (연속 구간 분리)
grouped AS (
    SELECT *,
        SUM(CASE WHEN date_diff > 2 OR date_diff IS NULL THEN 1 ELSE 0 END)
            OVER (PARTITION BY student_id ORDER BY session_date) AS group_id
    FROM ranked
),
-- 3) 각 연속 구간에서 세션 수 >= 6인 것만 필터 + 과목 순서 문자열 생성
sequences AS (
    SELECT
        student_id,
        group_id,
        COUNT(*) AS session_count,
        GROUP_CONCAT(subject ORDER BY session_date) AS subject_seq,
        SUM(hours_studied) AS total_study_hours
    FROM grouped
    GROUP BY student_id, group_id
    HAVING session_count >= 6
),
-- 4) cycle_length 3~session_count/2 범위에서 반복 패턴 탐지
--    첫 cycle과 나머지 cycle이 동일하고, session_count % cycle_length == 0인지 확인
pattern AS (
    SELECT
        s.student_id,
        s.total_study_hours,
        n.cycle_len AS cycle_length
    FROM sequences s
    JOIN (
        SELECT 3 AS cycle_len UNION SELECT 4 UNION SELECT 5
        UNION SELECT 6 UNION SELECT 7 UNION SELECT 8
        UNION SELECT 9 UNION SELECT 10
    ) n ON n.cycle_len <= s.session_count / 2
        AND s.session_count % n.cycle_len = 0
    WHERE
        -- 첫 번째 cycle 추출
        SUBSTRING_INDEX(s.subject_seq, ',', n.cycle_len) =
        -- 두 번째 cycle 추출하여 비교
        SUBSTRING_INDEX(
            SUBSTRING_INDEX(s.subject_seq, ',', 2 * n.cycle_len),
            ',', -n.cycle_len
        )
        -- 전체가 첫 cycle의 반복인지 추가 확인 (3번째 cycle 이상)
        AND (
            s.session_count / n.cycle_len = 2
            OR SUBSTRING_INDEX(s.subject_seq, ',', n.cycle_len) =
               SUBSTRING_INDEX(
                   SUBSTRING_INDEX(s.subject_seq, ',', 3 * n.cycle_len),
                   ',', -n.cycle_len
               )
        )
),
-- 5) 각 학생별 가장 작은(첫 발견된) cycle_length만 선택
best_pattern AS (
    SELECT
        student_id,
        MIN(cycle_length) AS cycle_length,
        total_study_hours
    FROM pattern
    GROUP BY student_id, total_study_hours
)
SELECT
    s.student_id,
    s.student_name,
    s.major,
    bp.cycle_length,
    bp.total_study_hours
FROM best_pattern bp
JOIN students s ON s.student_id = bp.student_id
ORDER BY bp.cycle_length DESC, bp.total_study_hours DESC;
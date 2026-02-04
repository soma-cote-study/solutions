WITH reaction_stats AS (
    SELECT
        user_id,
        reaction_type,
        COUNT(*) AS type_count,
        SUM(COUNT(*)) OVER (PARTITION BY user_id) AS total_count
    FROM user_reactions
    GROUP BY user_id, reaction_type
),
dominant_reactions AS (
    SELECT
        user_id,
        reaction_type AS dominant_reaction,
        type_count,
        total_count,
        ROUND(type_count * 100.0 / total_count, 2) AS reaction_ratio,
        ROW_NUMBER() OVER (PARTITION BY user_id ORDER BY type_count DESC) AS rn
    FROM reaction_stats
)
SELECT
    user_id,
    dominant_reaction,
    reaction_ratio
FROM dominant_reactions
WHERE rn = 1 AND reaction_ratio >= 60
ORDER BY reaction_ratio DESC, user_id ASC;

SELECT 
    t1.user_id, 
    t1.reaction AS dominant_reaction,
    ROUND(t1.reaction_count / t2.total_count, 2) AS reaction_ratio
FROM (
    SELECT user_id, reaction, COUNT(*) AS reaction_count
    FROM reactions
    GROUP BY user_id, reaction
) t1
JOIN (
    SELECT 
        user_id, 
        COUNT(*) AS total_count,
        COUNT(DISTINCT content_id) AS distinct_content
    FROM reactions
    GROUP BY user_id
) t2 ON t1.user_id = t2.user_id
WHERE 
    t2.distinct_content >= 5 
    AND (t1.reaction_count / t2.total_count) >= 0.6
ORDER BY 
    reaction_ratio DESC, 
    user_id ASC;
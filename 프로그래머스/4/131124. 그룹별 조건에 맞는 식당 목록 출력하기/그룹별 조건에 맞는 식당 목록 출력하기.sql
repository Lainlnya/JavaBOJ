WITH MAX_REVIEW AS (
    SELECT RR.MEMBER_ID, MP.MEMBER_NAME
    FROM REST_REVIEW RR
    JOIN MEMBER_PROFILE MP
    ON RR.MEMBER_ID = MP.MEMBER_ID
    GROUP BY MEMBER_ID
    HAVING COUNT(RR.MEMBER_ID) = 
    (
        SELECT COUNT(MEMBER_ID) AS MAXNUM
        FROM REST_REVIEW
        GROUP BY MEMBER_ID
        ORDER BY MAXNUM DESC
        LIMIT 1
    )
)

SELECT MR.MEMBER_NAME, RR.REVIEW_TEXT,
DATE_FORMAT(RR.REVIEW_DATE, "%Y-%m-%d") as REVIEW_DATE
FROM REST_REVIEW RR
JOIN MAX_REVIEW MR
ON MR.MEMBER_ID = RR.MEMBER_ID
ORDER BY RR.REVIEW_DATE, RR.REVIEW_TEXT;
SELECT COUNT(IFNULL(LENGTH, 10)) AS FISH_COUNT, FISH_NAME
FROM FISH_INFO FI
JOIN FISH_NAME_INFO FN
ON FI.FISH_TYPE = FN.FISH_TYPE
GROUP BY FI.FISH_TYPE, FN.FISH_NAME
ORDER BY FISH_COUNT DESC;
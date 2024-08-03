SELECT II.INGREDIENT_TYPE, SUM(TOTAL_ORDER) as TOTAL_ORDER
FROM FIRST_HALF FH
JOIN ICECREAM_INFO II
ON FH.FLAVOR = II.FLAVOR
GROUP BY II.INGREDIENT_TYPE
ORDER BY TOTAL_ORDER;
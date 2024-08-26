SELECT GU.USER_ID, GU.NICKNAME, SUM(GB.PRICE) AS TOTAL_SALES
FROM USED_GOODS_USER GU
JOIN USED_GOODS_BOARD GB
ON GU.USER_ID = GB.WRITER_ID
WHERE GB.STATUS = 'DONE'
GROUP BY USER_ID
HAVING TOTAL_SALES >= 700000
ORDER BY TOTAL_SALES
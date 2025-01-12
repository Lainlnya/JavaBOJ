SELECT GU.USER_ID, NICKNAME, 
CONCAT(CITY, ' ', STREET_ADDRESS1, ' ', STREET_ADDRESS2) AS '전체주소',
CONCAT(SUBSTR(TLNO, 1, 3), '-', SUBSTR(TLNO, 4, 4), '-', SUBSTR(TLNO, 8, 4)) AS '전화번호'
FROM USED_GOODS_BOARD GB
JOIN USED_GOODS_USER GU
ON GB.WRITER_ID = GU.USER_ID
GROUP BY GB.WRITER_ID
HAVING COUNT(GB.BOARD_ID) >= 3
ORDER BY GU.USER_ID DESC;

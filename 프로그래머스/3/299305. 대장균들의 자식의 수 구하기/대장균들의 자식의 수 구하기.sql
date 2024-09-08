SELECT PARENT.ID, COUNT(CHILD.ID) AS CHILD_COUNT
FROM ECOLI_DATA AS PARENT 
LEFT OUTER JOIN 
    ECOLI_DATA AS CHILD 
    ON CHILD.PARENT_ID = PARENT.ID
GROUP BY PARENT.ID
ORDER BY PARENT.ID
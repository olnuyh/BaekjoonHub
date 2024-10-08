-- 코드를 작성해주세요
SELECT BEST.SCORE, HE.EMP_NO, EMP_NAME, POSITION, EMAIL
FROM HR_EMPLOYEES AS HE INNER JOIN (SELECT EMP_NO, SUM(SCORE) AS SCORE
                            FROM HR_GRADE
                            GROUP BY EMP_NO
                            ORDER BY SCORE DESC LIMIT 1) AS BEST
ON HE.EMP_NO = BEST.EMP_NO;
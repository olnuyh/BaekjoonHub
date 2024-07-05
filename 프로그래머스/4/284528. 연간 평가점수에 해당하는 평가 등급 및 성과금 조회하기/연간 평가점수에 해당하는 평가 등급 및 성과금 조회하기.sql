-- 코드를 작성해주세요
SELECT HE.EMP_NO AS EMP_NO, EMP_NAME, (CASE WHEN AVG(HG.SCORE) >= 96 THEN 'S'
                            WHEN AVG(HG.SCORE) >= 90 THEN 'A'
                            WHEN AVG(HG.SCORE) >= 80 THEN 'B'
                            ELSE 'C'
                            END) AS GRADE, 
                            ((CASE WHEN AVG(HG.SCORE) >= 96 THEN 20
                            WHEN AVG(HG.SCORE) >= 90 THEN 15
                            WHEN AVG(HG.SCORE) >= 80 THEN 10
                            ELSE 0
                            END) * 0.01 * HE.SAL) AS BONUS
FROM HR_EMPLOYEES AS HE INNER JOIN HR_GRADE AS HG ON HE.EMP_NO = HG.EMP_NO
GROUP BY HE.EMP_NO
ORDER BY HE.EMP_NO;
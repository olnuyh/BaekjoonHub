-- 코드를 작성해주세요
SELECT HG.EMP_NO, EMP_NAME, (CASE WHEN AVG(SCORE) >= 96 THEN 'S'
                WHEN AVG(SCORE) >= 90 THEN 'A'
                WHEN AVG(SCORE) >= 80 THEN 'B'
                ELSE 'C'
                END) GRADE,
                SAL * (CASE WHEN AVG(SCORE) >= 96 THEN 0.2
                WHEN AVG(SCORE) >= 90 THEN 0.15
                WHEN AVG(SCORE) >= 80 THEN 0.1
                ELSE 0
                END) BONUS
FROM HR_GRADE HG INNER JOIN HR_EMPLOYEES HE
ON HG.EMP_NO = HE.EMP_NO
GROUP BY HG.EMP_NO
ORDER BY HG.EMP_NO;
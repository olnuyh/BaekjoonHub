-- 코드를 입력하세요
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
FROM (
    SELECT *, ROW_NUMBER() OVER (PARTITION BY FOOD_TYPE ORDER BY FAVORITES DESC) RN
    FROM REST_INFO
) RI
WHERE RI.RN = 1
ORDER BY FOOD_TYPE DESC;
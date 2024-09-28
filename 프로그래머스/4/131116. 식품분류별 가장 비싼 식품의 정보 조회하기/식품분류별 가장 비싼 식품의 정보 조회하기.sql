-- 코드를 입력하세요
SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
FROM (
    SELECT *, ROW_NUMBER() OVER(PARTITION BY CATEGORY ORDER BY PRICE DESC) AS R
    FROM FOOD_PRODUCT
    WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
) AS FP
WHERE FP.R = 1
ORDER BY FP.PRICE DESC;
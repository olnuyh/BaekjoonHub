-- 코드를 입력하세요
SELECT DISTINCT CRCC.CAR_ID, CRCC.CAR_TYPE, ROUND(30 * DAILY_FEE * (1 - 0.01 * DISCOUNT_RATE)) FEE
FROM CAR_RENTAL_COMPANY_CAR CRCC LEFT JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY CRCRH
ON CRCC.CAR_ID = CRCRH.CAR_ID
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN CRCDP
ON CRCC.CAR_TYPE = CRCDP.CAR_TYPE
WHERE CRCC.CAR_TYPE IN ('세단', 'SUV') AND CRCC.CAR_ID NOT IN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE '2022-11' BETWEEN DATE_FORMAT(START_DATE, '%Y-%m') AND DATE_FORMAT(END_DATE, '%Y-%m')
) AND DURATION_TYPE = '30일 이상' AND ROUND(30 * DAILY_FEE * (1 - 0.01 * DISCOUNT_RATE)) BETWEEN 500000 AND 2000000
ORDER BY FEE DESC, CRCC.CAR_TYPE, CRCC.CAR_ID DESC;
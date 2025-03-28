-- 코드를 입력하세요
SELECT J.FLAVOR
FROM JULY J LEFT JOIN FIRST_HALF FH
ON J.SHIPMENT_ID = FH.SHIPMENT_ID
GROUP BY J.FLAVOR
ORDER BY SUM(J.TOTAL_ORDER) + SUM(FH.TOTAL_ORDER) DESC LIMIT 3;
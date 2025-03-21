-- 코드를 입력하세요
SELECT YEAR(SALES_DATE) YEAR, MONTH(SALES_DATE) MONTH, COUNT(DISTINCT UI.USER_ID) PURCHASED_USERS, ROUND(COUNT(DISTINCT UI.USER_ID) / (
    SELECT COUNT(*)
    FROM USER_INFO
    WHERE YEAR(JOINED) = 2021
), 1) PURCHASED_RATIO
FROM USER_INFO UI INNER JOIN ONLINE_SALE OS
ON UI.USER_ID = OS.USER_ID
WHERE YEAR(JOINED) = 2021
GROUP BY YEAR, MONTH
ORDER BY YEAR, MONTH;
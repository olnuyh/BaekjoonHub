-- 코드를 입력하세요
SELECT A.AUTHOR_ID, AUTHOR_NAME, CATEGORY, SUM(PRICE * SALES) TOTAL_SALES
FROM AUTHOR A INNER JOIN BOOK B ON A.AUTHOR_ID = B.AUTHOR_ID
INNER JOIN BOOK_SALES BS ON B.BOOK_ID = BS.BOOK_ID
WHERE SALES_DATE LIKE '2022-01%'
GROUP BY A.AUTHOR_ID, CATEGORY
ORDER BY A.AUTHOR_ID, CATEGORY DESC;
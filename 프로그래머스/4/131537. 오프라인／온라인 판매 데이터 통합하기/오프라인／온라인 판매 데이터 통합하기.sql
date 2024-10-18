-- 동일한 데이터 합쳐야 하므로 UNION ALL 사용하자!
SELECT DATE_FORMAT(SALES_DATE,'%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
FROM ONLINE_SALE
WHERE YEAR(SALES_DATE) = '2022' AND MONTH(SALES_DATE) = '3'

UNION ALL

SELECT DATE_FORMAT(SALES_DATE,'%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, NULL, SALES_AMOUNT
FROM OFFLINE_SALE
WHERE YEAR(SALES_DATE) = '2022' AND MONTH(SALES_DATE) = '3'

ORDER BY SALES_DATE, PRODUCT_ID, USER_ID
;
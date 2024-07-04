-- 코드를 입력하세요
SELECT USER_ID, PRODUCT_ID FROM (
	SELECT USER_ID, PRODUCT_ID, COUNT(*) AS PURCHASE_COUNT
    FROM ONLINE_SALE
    GROUP BY USER_ID, PRODUCT_ID
    HAVING COUNT(*) > 1
) AS REPEATED_PURCHASES
ORDER BY USER_ID ASC, PRODUCT_ID DESC;
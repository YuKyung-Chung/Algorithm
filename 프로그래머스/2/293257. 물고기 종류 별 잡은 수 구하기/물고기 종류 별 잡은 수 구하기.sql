-- 코드를 작성해주세요
SELECT COUNT(A.FISH_TYPE) AS FISH_COUNT, A.FISH_NAME
FROM FISH_NAME_INFO A
JOIN FISH_INFO B
ON A.FISH_TYPE = B.FISH_TYPE
GROUP BY A.FISH_NAME
ORDER BY FISH_COUNT DESC
;
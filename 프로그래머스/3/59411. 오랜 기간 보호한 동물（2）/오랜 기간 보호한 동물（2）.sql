-- 입양을 간 동물 중, 보호기간이 가장 길었던 동물 2마리
-- 보호기간 긴 순으로 조회
-- 보호기간 순 대로 정렬
SELECT A.ANIMAL_ID, A.NAME
FROM ANIMAL_INS A
JOIN ANIMAL_OUTS B
ON A.ANIMAL_ID = B.ANIMAL_ID
ORDER BY (B.DATETIME - A.DATETIME) DESC
LIMIT 2;

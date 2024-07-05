-- 1. 대여 가능한 자동차 찾기
WITH AvailableCars AS (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_CAR C
    WHERE C.CAR_TYPE IN ('세단', 'SUV')
    AND CAR_ID NOT IN (
        SELECT CAR_ID
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE ('2022-11-01' BETWEEN START_DATE AND END_DATE)
           OR ('2022-11-30' BETWEEN START_DATE AND END_DATE)
           OR (START_DATE BETWEEN '2022-11-01' AND '2022-11-30')
           OR (END_DATE BETWEEN '2022-11-01' AND '2022-11-30')
    )
)

-- 2. 30일 대여 금액 계산
SELECT 
    C.CAR_ID,
    C.CAR_TYPE,
    FLOOR(C.DAILY_FEE * 30 * (1 - DP.DISCOUNT_RATE / 100)) AS FEE
FROM 
    CAR_RENTAL_COMPANY_CAR C
JOIN 
    AvailableCars AC ON C.CAR_ID = AC.CAR_ID
JOIN 
    CAR_RENTAL_COMPANY_DISCOUNT_PLAN DP 
    ON C.CAR_TYPE = DP.CAR_TYPE AND DP.DURATION_TYPE = '30일 이상'
WHERE 
    FLOOR(C.DAILY_FEE * 30 * (1 - DP.DISCOUNT_RATE / 100)) BETWEEN 500000 AND 2000000
ORDER BY 
    FEE DESC,
    C.CAR_TYPE ASC,
    C.CAR_ID DESC;

# A : Front End 스킬과 Python 스킬을 함께 가지고 있는 개발자
# B : C# 스킬을 가진 개발자
# C : 그 외의 Front End 개발자
SELECT *
FROM (
SELECT
    CASE
        WHEN EXISTS(
            SELECT 1
            FROM SKILLCODES S
            WHERE S.CATEGORY = 'FRONT END'
            AND (D.SKILL_CODE & S.CODE) > 0
        )
        AND EXISTS (
            SELECT 1
            FROM SKILLCODES S
            WHERE S.NAME = 'PYTHON'
            AND (D.SKILL_CODE & S.CODE) > 0
        ) THEN 'A'
        
        WHEN EXISTS (
            SELECT 1
            FROM SKILLCODES S
            WHERE S.NAME = 'C#'
            AND (D.SKILL_CODE & S.CODE) > 0
        ) THEN 'B'
        
        WHEN EXISTS (
            SELECT 1
            FROM SKILLCODES S
            WHERE S.CATEGORY = 'FRONT END'
            AND (D.SKILL_CODE & S.CODE) > 0
        ) THEN 'C'
    END AS GRADE,
    ID, EMAIL
FROM DEVELOPERS D

) T
WHERE GRADE IS NOT NULL
ORDER BY GRADE, ID
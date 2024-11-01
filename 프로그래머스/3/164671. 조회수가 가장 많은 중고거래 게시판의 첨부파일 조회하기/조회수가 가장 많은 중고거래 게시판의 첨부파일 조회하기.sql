-- 조회수가 가장 높은 중고거래 게시물에 대한 첨부파일 경로를 조회
-- 파일이름은 파일 ID, 파일 이름, 파일 확장자로 구성되도록 출력
SELECT CONCAT("/home/grep/src/", A.BOARD_ID, "/", B.FILE_ID, B.FILE_NAME, B.FILE_EXT) AS FILE_PATH
FROM (
    SELECT BOARD_ID
    FROM USED_GOODS_BOARD
    ORDER BY VIEWS DESC
    LIMIT 1
)A
JOIN USED_GOODS_FILE B
ON A.BOARD_ID = B.BOARD_ID
ORDER BY B.FILE_ID DESC
;
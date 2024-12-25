-- 조건에 맞는 도서와 저자 리스트 출력하기 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/144854?language=oracle
SELECT A.BOOK_ID, B.AUTHOR_NAME, TO_CHAR(A.PUBLISHED_DATE, 'YYYY-MM-DD') AS PUBLISHED_DATE
    FROM BOOK A
    INNER JOIN AUTHOR B ON A.AUTHOR_ID = B.AUTHOR_ID
    WHERE A.CATEGORY LIKE '%경제%'
    ORDER BY TO_CHAR(A.PUBLISHED_DATE, 'YYYY-MM-DD') ASC;
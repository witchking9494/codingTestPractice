-- 조건에 맞는 도서와 저자 리스트 출력하기 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/144854?language=oracle
SELECT A.BOOK_ID, B.AUTHOR_NAME, TO_CHAR(A.PUBLISHED_DATE, 'YYYY-MM-DD') AS PUBLISHED_DATE
        FROM BOOK A
        INNER JOIN AUTHOR B ON A.AUTHOR_ID = B.AUTHOR_ID
    WHERE A.CATEGORY LIKE '%경제%'
    ORDER BY TO_CHAR(A.PUBLISHED_DATE, 'YYYY-MM-DD') ASC;



-- 상품 별 오프라인 매출 구하기 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/131533
SELECT A.PRODUCT_CODE, SUM(A.PRICE * B.SALES_AMOUNT) AS SALES
        FROM PRODUCT A
        INNER JOIN OFFLINE_SALE B ON A.PRODUCT_ID = B.PRODUCT_ID
    GROUP BY PRODUCT_CODE
    ORDER BY SALES DESC, PRODUCT_CODE;

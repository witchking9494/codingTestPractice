-- 평균 일일 대여 요금 구하기 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/151136
SELECT ROUND(AVG(DAILY_FEE), 0) AS AVERAGE_FEE 
    FROM CAR_RENTAL_COMPANY_CAR 
    WHERE CAR_TYPE LIKE 'SUV';



-- 과일로 만든 아이스크림 고르기 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/133025
SELECT A. FLAVOR FROM FIRST_HALF A
INNER JOIN ICECREAM_INFO B ON A.FLAVOR = B.FLAVOR
WHERE TOTAL_ORDER > 3000
AND B.INGREDIENT_TYPE LIKE 'fruit_based';
-- SELECT FLAVOR FROM FIRST_HALF 
--     WHERE TOTAL_ORDER > 3000
--     AND FLAVOR IN (SELECT FLAVOR FROM ICECREAM_INFO 
--                     WHERE INGREDIENT_TYPE LIKE 'fruit_based')



-- 3월에 태어난 여성 회원 목록 출력하기 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/131120
SELECT  MEMBER_ID, 
        MEMBER_NAME, 
        GENDER, 
        TO_CHAR(DATE_OF_BIRTH, 'YYYY-MM-DD') AS DATE_OF_BIRTH 
        FROM MEMBER_PROFILE 
            WHERE EXTRACT(MONTH FROM DATE_OF_BIRTH) = 3
            AND GENDER LIKE 'W'
            AND TLNO IS NOT NULL
            ORDER BY MEMBER_ID;



-- 흉부외과 또는 일반외과 의사 목록 출력하기 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/132203
SELECT DR_NAME, DR_ID, MCDP_CD, TO_CHAR(HIRE_YMD, 'YYYY-MM-DD') AS HIRE_YMD FROM DOCTOR 
    WHERE MCDP_CD IN ('CS', 'GS')
    ORDER BY HIRE_YMD DESC, DR_NAME



-- 인기있는 아이스크림 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/133024
SELECT FLAVOR FROM FIRST_HALF 
    ORDER BY TOTAL_ORDER DESC, SHIPMENT_ID ASC



-- 강원도에 위치한 생산공장 목록 출력하기 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/131112
SELECT FACTORY_ID, FACTORY_NAME, ADDRESS FROM FOOD_FACTORY 
    WHERE ADDRESS LIKE '강원도%'
    ORDER BY FACTORY_ID



-- 12세 이하인 여자 환자 목록 출력하기 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/132201
SELECT PT_NAME, PT_NO, GEND_CD, AGE, NVL(TLNO, 'NONE') FROM PATIENT 
    WHERE AGE <= 12
    AND GEND_CD = 'W'
    ORDER BY AGE DESC, PT_NAME ASC



-- 조건에 맞는 도서 리스트 출력하기 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/144853
SELECT BOOK_ID, TO_CHAR(PUBLISHED_DATE, 'YYYY-MM-DD') AS PUBLISHED_DATE FROM BOOK
    WHERE EXTRACT(YEAR FROM PUBLISHED_DATE) = 2021
    AND CATEGORY = '인문'
    ORDER BY PUBLISHED_DATE



-- 조건에 부합하는 중고거래 댓글 조회하기 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/164673
SELECT  A.TITLE, 
        A.BOARD_ID, 
        B.REPLY_ID, 
        B.WRITER_ID, 
        B.CONTENTS, 
        TO_CHAR(B.CREATED_DATE, 'YYYY-MM-DD') AS CREATED_DATE 
    FROM USED_GOODS_BOARD A
    JOIN USED_GOODS_REPLY B ON A.BOARD_ID = B.BOARD_ID
    WHERE TO_CHAR(A.CREATED_DATE, 'YYYY-MM') = '2022-10'
    ORDER BY B.CREATED_DATE, A.TITLE;



-- 재구매가 일어난 상품과 회원 리스트 구하기 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/131536
SELECT USER_ID, PRODUCT_ID FROM ONLINE_SALE 
    GROUP BY USER_ID, PRODUCT_ID
    HAVING COUNT(*) >= 2
    ORDER BY USER_ID, PRODUCT_ID DESC;



-- 상위 n개 레코드 / MySQL
-- https://school.programmers.co.kr/learn/courses/30/lessons/59405
SELECT NAME FROM ANIMAL_INS WHERE DATETIME = (
    SELECT MIN(DATETIME)
    FROM ANIMAL_INS
    )



-- Python 개발자 찾기 / MySQL
-- https://school.programmers.co.kr/learn/courses/30/lessons/276013
SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
    FROM DEVELOPER_INFOS
    WHERE 'Python' IN (SKILL_1, SKILL_2, SKILL_3)
    ORDER BY ID;
-- SELECT ID, EMAIL, FIRST_NAME, LAST_NAME FROM DEVELOPER_INFOS 
--     WHERE SKILL_1 = 'Python'
--     OR SKILL_2 = 'Python'
--     OR SKILL_3 = 'Python'
--     ORDER BY ID;



-- 특정 물고기를 잡은 총 수 구하기 / MySQL
-- https://school.programmers.co.kr/learn/courses/30/lessons/298518
SELECT COUNT(*) AS FISH_COUNT FROM FISH_INFO A
JOIN FISH_NAME_INFO B ON A.FISH_TYPE = B.FISH_TYPE
WHERE B.FISH_NAME IN ('BASS', 'SNAPPER')

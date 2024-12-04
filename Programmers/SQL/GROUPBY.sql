-- 조건에 맞는 사원 정보 조회하기 / MySQL
-- https://school.programmers.co.kr/learn/courses/30/lessons/284527
SELECT SUM(A.SCORE) AS SCORE, A.EMP_NO, B.EMP_NAME, B.POSITION, B.EMAIL
    FROM HR_GRADE A
    JOIN HR_EMPLOYEES B ON A.EMP_NO = B.EMP_NO
    WHERE YEAR = 2022
    GROUP BY A.EMP_NO
    ORDER BY SCORE DESC
    LIMIT 1;



-- 물고기 종류 별 잡은 수 구하기 / MySQL
-- https://school.programmers.co.kr/learn/courses/30/lessons/293257
SELECT COUNT(*) AS FISH_COUNT, A.FISH_NAME FROM FISH_NAME_INFO A
JOIN FISH_INFO B ON A.FISH_TYPE = B.FISH_TYPE
    GROUP BY A.FISH_NAME
    ORDER BY FISH_COUNT DESC



-- 월별 잡은 물고기 수 구하기 / MySQL
-- https://school.programmers.co.kr/learn/courses/30/lessons/293260
SELECT COUNT(*) AS FISH_COUNT, MONTH(TIME) AS MONTH FROM FISH_INFO 
    GROUP BY MONTH
    ORDER BY MONTH



-- 고양이와 개는 몇 마리 있을까 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/59040
SELECT ANIMAL_TYPE, COUNT(ANIMAL_TYPE) AS count FROM ANIMAL_INS 
    GROUP BY ANIMAL_TYPE
    ORDER BY ANIMAL_TYPE



-- 자동차 종류 별 특정 옵션이 포함된 자동차 수 구하기 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/151137
SELECT CAR_TYPE, COUNT(*) AS CARS FROM CAR_RENTAL_COMPANY_CAR
    WHERE OPTIONS LIKE '%통풍시트%'
    OR OPTIONS LIKE '%열선시트%'
    OR OPTIONS LIKE '%가죽시트%'
    GROUP BY CAR_TYPE
    ORDER BY CAR_TYPE;
-- SELECT CAR_TYPE, COUNT(*) AS CARS FROM CAR_RENTAL_COMPANY_CAR
--     WHERE REGEXP_LIKE(OPTIONS, '통풍시트|열선시트|가죽시트')
--     GROUP BY CAR_TYPE
--     ORDER BY CAR_TYPE;



-- 성분으로 구분한 아이스크림 총 주문량 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/133026
SELECT B.INGREDIENT_TYPE, SUM(A.TOTAL_ORDER) AS TOTAL_ORDER FROM FIRST_HALF A
JOIN ICECREAM_INFO B ON A.FLAVOR = B.FLAVOR
    GROUP BY B.INGREDIENT_TYPE
    ORDER BY TOTAL_ORDER



-- 진료과별 총 예약 횟수 출력하기 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/132202
SELECT MCDP_CD AS "진료과코드", COUNT(*) AS "5월예약건수" FROM APPOINTMENT 
    WHERE TO_CHAR(APNT_YMD, 'YYYY-MM') = '2022-05'
    GROUP BY MCDP_CD
    ORDER BY COUNT(*), MCDP_CD



-- 동명 동물 수 찾기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59041
SELECT NAME, COUNT(*) AS "COUNT" FROM ANIMAL_INS 
    WHERE NAME IS NOT NULL
    GROUP BY NAME 
    HAVING COUNT(*) > 1
    ORDER BY NAME

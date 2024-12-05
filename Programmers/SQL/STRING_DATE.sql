-- 자동차 대여 기록에서 장기/단기 대여 구분하기 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/151138
SELECT  HISTORY_ID, 
        CAR_ID, 
        TO_CHAR(START_DATE, 'YYYY-MM-DD') AS START_DATE, 
        TO_CHAR(END_DATE, 'YYYY-MM-DD') AS END_DATE, 
        CASE 
            WHEN (END_DATE - START_DATE + 1) >= 30 THEN '장기 대여'
            ELSE '단기 대여'
        END AS RENT_TYPE 
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE TO_CHAR(START_DATE, 'YYYY-MM') = '2022-09'
        ORDER BY HISTORY_ID DESC



-- 조건에 부합하는 중고거래 상태 조회하기 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/164672
SELECT  BOARD_ID, 
        WRITER_ID, 
        TITLE, 
        PRICE,
        CASE
            WHEN STATUS = 'SALE' THEN '판매중'
            WHEN STATUS = 'RESERVED' THEN '예약중'
            WHEN STATUS = 'DONE' THEN '거래완료'
        END AS STATUS 
        FROM USED_GOODS_BOARD 
    WHERE TO_CHAR(CREATED_DATE, 'YYYY-MM-DD') = '2022-10-05'
    ORDER BY BOARD_ID DESC;



-- 특정 옵션이 포함된 자동차 리스트 구하기 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/157343
SELECT CAR_ID, CAR_TYPE, DAILY_FEE, OPTIONS FROM CAR_RENTAL_COMPANY_CAR 
    WHERE OPTIONS LIKE '%네비게이션%'
    ORDER BY CAR_ID DESC



-- 루시와 엘라 찾기 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/59046
SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE FROM ANIMAL_INS 
    WHERE NAME IN ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')
    ORDER BY ANIMAL_ID



-- 이름에 el이 들어가는 동물 찾기 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/59047
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS 
    WHERE UPPER(NAME) LIKE UPPER('%el%')
    AND ANIMAL_TYPE = 'Dog'
    ORDER BY NAME



-- 중성화 여부 파악하기 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/59409
SELECT  ANIMAL_ID, 
        NAME, 
        CASE
            WHEN SEX_UPON_INTAKE LIKE '%Neutered%' THEN 'O'
            WHEN SEX_UPON_INTAKE LIKE '%Spayed%' THEN 'O'
            ELSE 'X'
        END AS "중성화" 
        FROM ANIMAL_INS 
        ORDER BY ANIMAL_ID



-- 카테고리 별 상품 개수 구하기 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/131529
SELECT  SUBSTR(PRODUCT_CODE, 1, 2) AS CATEGORY, 
        COUNT(*) AS PRODUCTS FROM PRODUCT 
    GROUP BY SUBSTR(PRODUCT_CODE, 1, 2)
    ORDER BY CATEGORY



-- DATETIME에서 DATE로 형 변환 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/59414
SELECT ANIMAL_ID, NAME, TO_CHAR(DATETIME, 'YYYY-MM-DD') AS "날짜" FROM ANIMAL_INS 
    ORDER BY ANIMAL_ID



-- 연도 별 평균 미세먼지 농도 조회하기 / MySQL
-- https://school.programmers.co.kr/learn/courses/30/lessons/284530
SELECT  CAST(DATE_FORMAT(YM, '%Y') AS UNSIGNED) AS YEAR, 
        ROUND(AVG(PM_VAL1), 2) AS "PM10", 
        ROUND(AVG(PM_VAL2), 2) AS "PM2.5" 
    FROM AIR_POLLUTION
    WHERE LOCATION2 = '수원'
    AND LOCATION1 = '경기도'
    GROUP BY CAST(DATE_FORMAT(YM, '%Y') AS UNSIGNED)
    ORDER BY YEAR



-- 한 해에 잡은 물고기 수 구하기 / MySQL
-- https://school.programmers.co.kr/learn/courses/30/lessons/298516
SELECT COUNT(*) AS FISH_COUNT FROM FISH_INFO
    WHERE DATE_FORMAT(TIME, '%Y') = 2021



-- 분기별 분화된 대장균의 개체 수 구하기 / MySQL
-- https://school.programmers.co.kr/learn/courses/30/lessons/299308
SELECT  CASE
            WHEN CAST(DATE_FORMAT(DIFFERENTIATION_DATE, '%m') AS UNSIGNED) BETWEEN 01 AND 03 THEN '1Q'
            WHEN CAST(DATE_FORMAT(DIFFERENTIATION_DATE, '%m') AS UNSIGNED) BETWEEN 04 AND 06 THEN '2Q'
            WHEN CAST(DATE_FORMAT(DIFFERENTIATION_DATE, '%m') AS UNSIGNED) BETWEEN 07 AND 09 THEN '3Q'
            WHEN CAST(DATE_FORMAT(DIFFERENTIATION_DATE, '%m') AS UNSIGNED) BETWEEN 10 AND 12 THEN '4Q'
        END AS QUARTER, 
        COUNT(*) AS ECOLI_COUNT 
    FROM ECOLI_DATA
    GROUP BY QUARTER
    ORDER BY QUARTER


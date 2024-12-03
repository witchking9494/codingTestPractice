-- 경기도에 위치한 식품창고 목록 출력하기 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/131114
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, NVL(FREEZER_YN, 'N') FROM FOOD_WAREHOUSE 
    WHERE ADDRESS LIKE '경기도%'
    ORDER BY WAREHOUSE_ID



-- 이름이 없는 동물의 아이디 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/59039
SELECT ANIMAL_ID FROM ANIMAL_INS WHERE NAME IS NULL ORDER BY ANIMAL_ID



-- 이름이 있는 동물의 아이디 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/59407
SELECT ANIMAL_ID FROM ANIMAL_INS 
    WHERE NAME IS NOT NULL
    ORDER BY ANIMAL_ID



-- NULL 처리하기 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/59410
SELECT ANIMAL_TYPE, NVL(NAME, 'No name'), SEX_UPON_INTAKE FROM ANIMAL_INS 
ORDER BY ANIMAL_ID



-- 나이 정보가 없는 회원 수 구하기 / MySQL
-- https://school.programmers.co.kr/learn/courses/30/lessons/131528
SELECT COUNT(*) AS USERS FROM USER_INFO WHERE AGE IS NULL;



-- 잡은 물고기의 평균 길이 구하기 / MySQL
-- https://school.programmers.co.kr/learn/courses/30/lessons/293259
SELECT ROUND(AVG(IFNULL(LENGTH, 10)), 2) AS AVERAGE_LENGTH FROM FISH_INFO

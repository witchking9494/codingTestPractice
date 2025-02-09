-- 가격이 제일 비싼 식품의 정보 출력하기 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/131115
SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_CD, CATEGORY, PRICE
FROM FOOD_PRODUCT 
WHERE PRICE IS NOT NULL 
AND PRICE = (SELECT MAX(PRICE) FROM FOOD_PRODUCT)



-- 최댓값 구하기 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/59415
SELECT DATETIME AS 시간 FROM ANIMAL_INS WHERE DATETIME = (
    SELECT MAX(DATETIME)
    FROM ANIMAL_INS)



-- 최솟값 구하기 / Oracle
-- https://school.programmers.co.kr/learn/courses/30/lessons/59038
SELECT DATETIME AS 시간 FROM ANIMAL_INS WHERE DATETIME = (
    SELECT MIN(DATETIME) 
    FROM ANIMAL_INS
    )



-- 조건에 맞는 아이템들의 가격의 총합 구하기 / MySQL
-- https://school.programmers.co.kr/learn/courses/30/lessons/273709
SELECT SUM(PRICE) AS TOTAL_PRICE FROM ITEM_INFO WHERE RARITY = 'LEGEND'



-- 잡은 물고기 중 가장 큰 물고기의 길이 구하기 / MySQL
-- https://school.programmers.co.kr/learn/courses/30/lessons/298515
SELECT CONCAT(MAX(LENGTH), 'cm') AS MAX_LENGTH FROM FISH_INFO



-- 연도별 대장균 크기의 편차 구하기 / MySQL
-- https://school.programmers.co.kr/learn/courses/30/lessons/299310
SELECT  YEAR(DIFFERENTIATION_DATE) AS YEAR, 
        MAX(SIZE_OF_COLONY) OVER (PARTITION BY YEAR(DIFFERENTIATION_DATE)) - SIZE_OF_COLONY AS YEAR_DEV,
        ID
FROM ECOLI_DATA
ORDER BY YEAR, YEAR_DEV



-- 물고기 종류 별 대어 찾기 / MySQL
-- https://school.programmers.co.kr/learn/courses/30/lessons/293261
SELECT A.ID, B.FISH_NAME, A.LENGTH AS LENGTH
        FROM FISH_INFO A
        JOIN FISH_NAME_INFO B ON A.FISH_TYPE = B.FISH_TYPE
    WHERE A.LENGTH = 
        (SELECT MAX(C.LENGTH) FROM FISH_INFO C
         WHERE C.FISH_TYPE = A.FISH_TYPE)
    ORDER BY A.ID
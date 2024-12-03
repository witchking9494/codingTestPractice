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
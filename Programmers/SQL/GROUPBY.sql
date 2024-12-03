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


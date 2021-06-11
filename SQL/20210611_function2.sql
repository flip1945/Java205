-- 2021.06.11

-- 그룹 함수
-- 여러 행을 묶어 처리하는 함수
-- sum, avg, count, max, min

-- 사원 테이블에서
-- 1. 사원의 수 
-- 2. 사원의 급여 총합
-- 3. 급여 평균
-- 4. 최대 급여
-- 5. 최소 급여
SELECT COUNT(*) AS "사원의 수",
       SUM(SAL) AS "급여의 총합",
       ROUND(AVG(SAL), 2) AS "급여 평균", 
       MAX(SAL) AS "최대 급여", 
       MIN(SAL) AS "최소 급여",
       SUM(COMM) AS "커미션의 총합",
       AVG(COMM) AS "커미션의 평균",
       COUNT(COMM) AS "커미션 받는 사원 수"
FROM EMP;

-- 직업의 개수
SELECT COUNT(DISTINCT JOB)
FROM EMP;

-- 마당서적 BOOK 테이블에 책을 납품하는 출판사
SELECT COUNT(DISTINCT PUBLISHER)
FROM BOOK
ORDER BY PUBLISHER;

-- 특정 컬럼을 이용해서 그룹핑하기 -> group by
-- select 그룹핑할 기준의 컬럼, 그룹함수
-- from 테이블
-- where
-- group by 그룹핑할 기준의 컬럼


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

-- 부서별 급여 평균을 구해보자
SELECT AVG(SAL) FROM EMP WHERE DEPTNO = 10;
SELECT AVG(SAL) FROM EMP WHERE DEPTNO = 20;
SELECT AVG(SAL) FROM EMP WHERE DEPTNO = 30;

SELECT DEPTNO, COUNT(*) AS "부서 인원", SUM(SAL) AS "부서의 급여 총합", ROUND(AVG(SAL)) AS "부서의 급여 평균", MAX(SAL) AS "부서의 최대 급여액", MIN(SAL) AS "부서의 최소 급여액"
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;

-- 직급별
SELECT DISTINCT JOB
FROM EMP
ORDER BY JOB;

SELECT JOB, COUNT(*)
FROM EMP
GROUP BY JOB
ORDER BY JOB;

-- 다음은 부서별로 사원 수와 커미션을 받는 사원들의 수를 계산해서 출력
SELECT COUNT(*), COUNT(COMM)
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;

-- GROUP BY의 그룹 함수의 결과를 비교할 시에는 HAVING 절을 사용

-- 부서별 평균 급여가 2000 이상인(HAVING)
-- 부서번호와 부서별 평균 급여를 출력
SELECT DEPTNO, AVG(SAL)
FROM EMP
GROUP BY DEPTNO
HAVING AVG(SAL) >= 2000;

-- 부서의 급여의 최대값과 최소값을 구하되 최대 급여가 2900이상인 부서만 출력합니다.
SELECT DEPTNO, MAX(SAL), MIN(SAL)
FROM EMP
GROUP BY DEPTNO
HAVING MAX(SAL) >= 2900
ORDER BY DEPTNO;
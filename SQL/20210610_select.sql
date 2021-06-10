-- 2021.06.21

-- 특정 데이터 검색 : 행 검색 -> 컬럼 선택


-- 10번 부서의 사원 리스트를 출력
SELECT *
FROM EMP
WHERE DEPTNO = 10;

-- 이름이 'SCOTT'인 사원을 출력
SELECT *
FROM EMP
WHERE ENAME = 'SCOTT';

-- 날짜타입의 데이터 비교시에도 작은 따움표를 이용해야 한다!!
SELECT *
FROM EMP
WHERE HIREDATE = '96/11/17';

-- 논리연산자 : AND, OR, NOT
-- 10번 부서의 관리자(MANAGER)를 찾아 출력
SELECT *
FROM EMP
WHERE DEPTNO = 10 AND JOB = 'MANAGER';

SELECT EMPNO, ENAME, JOB
FROM EMP
WHERE DEPTNO = 10 AND JOB = 'MANAGER';

-- 10번 부서의 직원을 제외한 나머지 직원들을 출력
SELECT *
FROM EMP
WHERE DEPTNO != 10;

-- 2000 이상 3000 이하의 급여를 받는 직원의 리스트
SELECT ENAME, JOB, SAL, SAL*1.2 AS UPSAL
FROM EMP
-- 2000 이상 3000 이하인 조건
WHERE SAL BETWEEN 2000 AND 3000;


-- BTWEEN 연산자는 날짜의 연산도 가능
-- 1997년에 입사한 사원들의 리스트를 출력
SELECT *
FROM EMP
-- WHERE HIREDATE BETWEEN '1981/01/01' AND '1981/12/31'
WHERE HIREDATE >= '1981/01/01' AND HIREDATE <= '1981/12/31'
ORDER BY HIREDATE;

-- 연산자 IN -> 여러개의 OR 연산자 사용시 대체할 수 있다.
-- 커미션이 300 또는 500 또는 1400
SELECT *
FROM EMP
--WHERE COMM = 300 OR COMM = 500 OR COMM = 1400;
WHERE COMM IN (300, 500, 1400);

-- 패턴 검색 : 키워드 검색 많이 사용 (게시판)
-- 컬럼 LIKE '%'
-- ENAME LIKE 'F%' -> F로 시작하는 문자열
-- ENAME LIKE '%F' -> F로 끝나는 문자열
-- ENAME LIKE '%F%' -> F를 포함하는 문자열
-- 'JAVA' 단어를 포함하는 지 -> TITLE LIKE '%JAVA%'

SELECT *
FROM EMP
WHERE ENAME LIKE 'F%';
-- 2021.06.09
-- SQL Basic

-- 계정 HR이 보유(권한)한 테이블 객체 리스트
SELECT * FROM tab;

-- 테이블의 정보를 검색 : 컬럼의 이름, null 유무, 타입, 사이즈
desc dept;
desc emp;

-- 데이터 조회를 위한 명령 : SELECT
-- SELECT {컬럼명, ...., *} FROM 테이블 이름;

SELECT * FROM EMP;

-- 필요한 컬럼을 출력
-- SELECT 컬럼명, 컬럼명 FROM 테이블 이름)
-- 사원 번호와 사원 이름을 출력

SELECT EMPNO, ENAME, SAL FROM EMP;

-- SELECT 컬럼의 산술연산이 가능 : 컬럼과 숫자의 연산, 컬럼과 컬럼 간의 연산기능
-- 사원이름, 월 급여, 연봉계산 결과값
SELECT ENAME, SAL, SAL * 12 AS ANNUAL_SAL
FROM EMP;

SELECT SAL, COMM, SAL * COMM, SAL*12, SAL/10, SAL-100, SAL+1000
FROM EMP;

-- 사원의 이름, 직급, 급여, 커미션, 연봉(급여 * 12), 연봉(급여 * 12 * 커미션)
SELECT ENAME, JOB, SAL, NVL(COMM, 0) AS COMM, SAL*12 AS ANNUAL_SAL, SAL*12 + NVL(SAL*(COMM/100), 0) AS TOTAL_SAL
FROM EMP;

-- 컬럼과 문자열을 붙이는 연산 || 이용
-- SQL에서 문자열 표현 -> ' 작은 따움표 이용
SELECT ENAME || ' is a ' || JOB
FROM EMP;

-- 결과 리스트에서 중복된 값을 제거 : DISTINCT
SELECT DISTINCT DEPTNO
FROM EMP
ORDER BY DEPTNO;

-- ORDER BY : 행의 정렬
SELECT DISTINCT DEPTNO, JOB
FROM EMP
ORDER BY DEPTNO, JOB;

SELECT DISTINCT DEPTNO, JOB
FROM EMP
ORDER BY JOB;

-- 특정 데이터를 검색하기 위해서는
-- SELECT ~ FROM ~ 구문에 WHERE 절을 이용
-- WHERE 뒤에는 조건식이 정의 -> WHERE 컬럼명 비교연산자 값
-- ex) WHERE SAL >= 3000

-- WHERE 절 : 행에서 특정 조건을 만족하는 행만 선택하는 구문
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL >= 3000;
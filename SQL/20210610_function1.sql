-- 2021.06.10
-- function : 단일행 함수, 집합(다중행) 함수
-- 단일행 함수 : 하나의 행이 포함하는 특정 컬럼의 값 하나를 처리하고 반환
-- 다중행(집합) 함수 : 여러행의 특정 컬럼값들을 대상으로 연산하고 반환


-- 숫자 함수
SELECT ABS(10), ABS(-10)
FROM DUAL;

SELECT ROUND(15.193, 1), ROUND(15.193, -1)
FROM DUAL;

SELECT TRUNC(15.79, 1), TRUNC(15.79)
FROM DUAL;

SELECT MOD(11,5)
FROM DUAL;

SELECT EMPNO, ENAME
FROM EMP
WHERE MOD(EMPNO, 2) = 1;

-- 문자 함수
-- CONCAT (문자, 문자) -> '' || ''
SELECT CONCAT('ABC', 'EFG'), 'ABC' || 'EFG'
FROM DUAL;

-- SUBSTR : 문자열 추출
-- SUBSTR(문자열, 시작 위치, 길이) 시작 인덱스 1(0이 아님에 주의)
SELECT SUBSTR('APPLE', 1, 3)
FROM DUAL;

SELECT SUBSTR('APPLE', -3)
FROM DUAL;

-- REPLACE : 특정 문자열(패턴)을 다른 문자열(패턴)으로 변경
SELECT REPLACE('JACK and JUE','J','BL')
FROM DUAL;

SELECT SYSDATE
FROM DUAL;




-- 2021.06.11
-- 형변환 함수


-- 날짜 -> 문자, 숫자 -> 문자
-- TO_CHAR(날짜 데이터, '패턴'), TO_CHAR(숫자, '패턴')

-- 날짜 -> 문자
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') AS "YYYY-MM-DD"
FROM DUAL;

SELECT ENAME, HIREDATE, TO_CHAR(HIREDATE, 'YYYY-MM-DD')
FROM EMP;

SELECT * FROM ORDERS;
SELECT ORDERID, ORDERDATE, TO_CHAR(ORDERDATE, 'YYYY-MM-DD')
FROM ORDERS;

-- 숫자 -> 문자
SELECT TO_CHAR(123456, '0,000,000,000'), TO_CHAR(123456, 'L9,999,999,999'), TO_CHAR(123456)
FROM DUAL;

SELECT EMPNO, ENAME, TO_CHAR(SAL * 1100, 'L999,999,999')
FROM EMP;


-- 문자 -> 숫자, 문자 -> 날짜
-- TO_NUMBER(문자열, '패턴'), TO_DATE(문자열, '패턴')

-- 문자 -> 숫자
SELECT TO_NUMBER('1,000,000', '9,999,999'),
       TO_NUMBER('1,000,000', '9,999,999') + 100000
FROM DUAL;

-- 문자 -> 날짜
SELECT TO_DATE('2012.05.17', 'YYYY.MM.DD'), FLOOR(SYSDATE - TO_DATE('2012-05-17', 'YYYY-MM-DD')) AS "DAYS"
FROM DUAL;



-- DECODE 함수 : 분기를 위해 사용 SWITCH-CASE와 유사
-- DECODE(컬럼, = 조건1 값, 조건1의 값이 참일 때 사용할 값
--             , 조건2 값, 조건2의 값이 참일 때 사용할 값
--             , ...

-- EMP 테이블에서 부서 번호에 맞는 부서 이름을 출력
SELECT *
FROM DEPT;

-- 10 ACCOUNTING
-- 20 RESEARCH
-- 30 SALES
-- 40 OPERATIONS
SELECT ENAME, DEPTNO, 
       DECODE(DEPTNO, 10, 'ACCOUNTING', 
                      20, 'RESEARCH',
                      30, 'SALES',
                      40, 'OPERATIONS'
        )
FROM EMP;

-- 8. 직급에 따라 급여를 인상하도록 하자.
-- 직급이 'ANALYST'인 사원은 5%,
--       'SALESMAN'인 사원은 10%,
--       'MANAGER'인 사원은 15%,
--       'CLERK'인 사원은 20% 인상한다.
SELECT ENAME, JOB, SAL,
       DECODE(JOB, 'ANALYST', SAL * 1.05,
                   'SALESMAN', SAL * 1.1,
                   'MANAGER', SAL * 1.15,
                   'CLERK', SAL * 1.2
             )
FROM EMP;

-- CASE 함수도 분기할 때 사용
-- CASE WHEN 조건식 THEN 참일 때 값
SELECT ENAME, DEPTNO,
       CASE WHEN DEPTNO = 10 THEN 'ACCOUNTING'
            WHEN DEPTNO = 20 THEN 'SALESMAN'
            WHEN DEPTNO = 30 THEN 'MANAGER'
            WHEN DEPTNO = 40 THEN 'OPERATIONS'
       END AS DEPTNAME
FROM EMP;
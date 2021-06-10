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
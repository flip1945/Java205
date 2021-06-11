-- 2021.06.11

-- JOIN

-- CROSS JOIN
-- 스키마의 합 : 집합의 곱 연산과 같다

SELECT *
FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO;

-- 이름이 SCOTT인 사람의 부서명을 출력해봅시다.
-- 출력해야하는 컬럼을 가지는 테이블을 확인해보자
-- 이름 : EMP, 부서명 : DEPT

SELECT E.ENAME, D.DNAME
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND E.ENAME = 'SCOTT';

-- SELF JOIN : 자기 자신을 조인(참조)
-- EMP -> MGR 컬럼이 EMP.EMPNO 참조
SELECT E.EMPNO, E.ENAME, E.MGR, M.ENAME
FROM EMP E, EMP M
WHERE E.MGR = M.EMPNO;
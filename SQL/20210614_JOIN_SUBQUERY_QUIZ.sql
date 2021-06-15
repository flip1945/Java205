--1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.
--(5) 박지성이구매한도서의출판사수

SELECT COUNT(PUBLISHER)
FROM ORDERS O INNER JOIN BOOK B
ON O.BOOKID = B.BOOKID
WHERE O.CUSTID = (SELECT CUSTID
                  FROM CUSTOMER
                  WHERE NAME = '박지성');

--(6) 박지성이구매한도서의이름, 가격, 정가와판매가격의차이

SELECT B.BOOKNAME, B.PRICE - O.SALEPRICE AS PRICEGAP
FROM ORDERS O INNER JOIN BOOK B
ON O.BOOKID = B.BOOKID
WHERE CUSTID = (SELECT CUSTID
                FROM CUSTOMER
                WHERE NAME = '박지성');

--(7) 박지성이구매하지않은도서의이름

SELECT DISTINCT BOOKNAME
FROM ORDERS O RIGHT OUTER JOIN BOOK B
ON O.BOOKID = B.BOOKID
WHERE CUSTID NOT IN (SELECT CUSTID
                     FROM CUSTOMER
                     WHERE NAME = '박지성')
      OR CUSTID IS NULL;

--2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.
--(8) 주문하지않은고객의이름(부속질의사용)

-- SubQuery 사용
SELECT NAME
FROM CUSTOMER
WHERE CUSTID NOT IN (SELECT DISTINCT CUSTID
                     FROM ORDERS);

-- OUTER JOIN 사용
SELECT NAME
FROM ORDERS O RIGHT OUTER JOIN CUSTOMER C
ON O.CUSTID = C.CUSTID
WHERE O.CUSTID IS NULL;

--(9) 주문금액의총액과주문의평균금액

SELECT SUM(SALEPRICE) AS TOTAL, AVG(SALEPRICE) AS AVGSALEPRICE
FROM ORDERS;

--(10) 고객의이름과고객별구매액

SELECT C.NAME, SUM(SALEPRICE)
FROM ORDERS O INNER JOIN CUSTOMER C
ON O.CUSTID = C.CUSTID
GROUP BY C.NAME;

--(11) 고객의이름과고객이구매한도서목록

SELECT C.NAME, B.BOOKNAME
FROM ORDERS O INNER JOIN CUSTOMER C 
ON O.CUSTID = C.CUSTID
INNER JOIN BOOK B
ON O.BOOKID = B.BOOKID
ORDER BY C.NAME, B.BOOKNAME;

--(12) 도서의가격(Book 테이블)과판매가격(Orders 테이블)의차이가가장많은주문

SELECT *
FROM ORDERS O INNER JOIN BOOK B
ON O.BOOKID = B.BOOKID
WHERE B.PRICE - O.SALEPRICE = (SELECT MAX(BOOK.PRICE - ORDERS.SALEPRICE)
                               FROM BOOK INNER JOIN ORDERS
                               ON BOOK.BOOKID = ORDERS.BOOKID);

--(13) 도서의판매액평균보다자신의구매액평균이더높은고객의이름

SELECT NAME
FROM ORDERS O INNER JOIN CUSTOMER C
ON O.CUSTID = C.CUSTID
GROUP BY NAME
HAVING AVG(SALEPRICE) > (SELECT AVG(SALEPRICE)
                         FROM ORDERS);

--3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.
--(1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름

SELECT C.NAME
FROM ORDERS O INNER JOIN CUSTOMER C
ON O.CUSTID = C.CUSTID
INNER JOIN BOOK B
ON B.BOOKID = O.BOOKID
WHERE B.PUBLISHER IN (SELECT PUBLISHER
                      FROM ORDERS O INNER JOIN CUSTOMER C
                      ON O.CUSTID = C.CUSTID
                      INNER JOIN BOOK B
                      ON B.BOOKID = O.BOOKID
                      WHERE C.NAME = '박지성')
      AND C.NAME != '박지성';

--(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름

SELECT NAME
FROM ORDERS O INNER JOIN CUSTOMER C
ON O.CUSTID = C.CUSTID
INNER JOIN BOOK B
ON B.BOOKID = O.BOOKID
GROUP BY C.NAME
HAVING COUNT(DISTINCT B.PUBLISHER) >= 2;
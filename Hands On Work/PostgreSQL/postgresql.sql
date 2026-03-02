DROP TABLE IF EXISTS emp;
CREATE TABLE emp
(
empno decimal(4,0) NOT NULL,
ename varchar(10) default NULL,
job varchar(9) default NULL,
mgr decimal(4,0) default NULL,
hiredate date default NULL,
sal decimal(7,2) default NULL,
comm decimal(7,2) default NULL,
deptno decimal(2,0) default NULL
);
DROP TABLE IF EXISTS dept;
CREATE TABLE dept (
deptno decimal(2,0) default NULL,
dname varchar(14) default NULL,
loc varchar(13) default NULL
);
INSERT INTO emp VALUES ('7369','SMITH','CLERK','7902','1980-12-17','800.00',NULL,'20');
INSERT INTO emp VALUES ('7499','ALLEN','SALESMAN','7698','1981-02-20','1600.00','300.00','30');
INSERT INTO emp VALUES ('7521','WARD','SALESMAN','7698','1981-02-22','1250.00','500.00','30');
INSERT INTO emp VALUES ('7566','JONES','MANAGER','7839','1981-04-02','2975.00',NULL,'20');
INSERT INTO emp VALUES ('7654','MARTIN','SALESMAN','7698','1981-09-28','1250.00','1400.00','30');
INSERT INTO emp VALUES ('7698','BLAKE','MANAGER','7839','1981-05-01','2850.00',NULL,'30');
INSERT INTO emp VALUES ('7782','CLARK','MANAGER','7839','1981-06-09','2450.00',NULL,'10');
INSERT INTO emp VALUES ('7788','SCOTT','ANALYST','7566','1982-12-09','3000.00',NULL,'20');
INSERT INTO emp VALUES ('7839','KING','PRESIDENT',NULL,'1981-11-17','5000.00',NULL,'10');
INSERT INTO emp VALUES ('7844','TURNER','SALESMAN','7698','1981-09-08','1500.00','0.00','30');
INSERT INTO emp VALUES ('7876','ADAMS','CLERK','7788','1983-01-12','1100.00',NULL,'20');
INSERT INTO emp VALUES ('7900','JAMES','CLERK','7698','1981-12-03','950.00',NULL,'30');
INSERT INTO emp VALUES ('7902','FORD','ANALYST','7566','1981-12-03','3000.00',NULL,'20');
INSERT INTO emp VALUES ('7934','MILLER','CLERK','7782','1982-01-23','1300.00',NULL,'10');
INSERT INTO dept VALUES ('10','ACCOUNTING','NEW YORK');
INSERT INTO dept VALUES ('20','RESEARCH','DALLAS');
INSERT INTO dept VALUES ('30','SALES','CHICAGO');
INSERT INTO dept VALUES ('40','OPERATIONS','BOSTON');
SELECT * FROM emp;
SELECT * FROM dept;
SELECT ename,sal*12 AS CTC FROM emp;

SELECT ename,sal*12 AS CTC, sal*6 AS App,sal FROM emp;

SELECT ename,(sal*6)*1.10 AS App,sal FROM emp;

SELECT ename,(sal*6)AS App,sal*1.10 FROM emp;

SELECT ename,0.70*sal AS DEC,1.70*sal AS INC FROM emp;

SELECT ename, sal*12 AS ANNSAL, 0.70*sal, sal+500 FROM emp;

SELECT *,sal*6 AS Half_Term,sal*12 AS Annual FROM emp;

SELECT DISTINCT sal, job FROM emp;

SELECT ename,sal FROM emp WHERE sal>3000;

SELECT ename,sal*12 AS AnnSal FROM emp WHERE sal*12>12000;

SELECT ename,hiredate FROM emp WHERE hiredate>'1980-12-31';

SELECT ename,hiredate FROM emp WHERE hiredate<'1987-01-01';

SELECT ename FROM emp WHERE deptno <> 30;

SELECT ename FROM emp WHERE deptno != 30;

SELECT * FROM emp WHERE job = 'SALESMAN' AND sal>2000;

SELECT ename FROM emp WHERE job = 'MANAGER' AND sal>2000 AND hiredate>'1980-12-31';

SELECT ename from emp WHERE hiredate>='1981-01-01' AND hiredate<='1981-12-31';

SELECT ename, sal*6 AS HALF_TERM FROM emp WHERE sal*12>8000 AND hiredate>'1981-12-31' 
AND hiredate<'1988-01-01';

SELECT * FROM emp WHERE job='CLERK' OR job='ANALYST';

SELECT * FROM emp WHERE sal>2000 AND (job='CLERK' OR job='ANALYST');

SELECT * FROM emp WHERE (hiredate>'1978-12-31' OR hiredate<'1987-01-01') AND sal>2000 
AND (deptno=10 OR deptno=30) AND (job='CLERK' OR job='MANAGER' OR job='SALESMAN');

SELECT * FROM emp WHERE NOT job='SALESMAN';

SELECT * FROM emp WHERE NOT (job='MANAGER' OR job='CLERK') 
AND hiredate>='1981-01-01' AND hiredate<='1981-12-31';

SELECT * FROM emp WHERE deptno IN (20,30) AND job IN ('MANAGER','PRESIDENT') AND sal>2000;

SELECT * FROM emp WHERE deptno IN (20,30) AND job NOT IN ('MANAGER','CLERK') AND hiredate>'1982-12-31';

SELECT * FROM emp WHERE sal BETWEEN 1000 AND 5000 AND job IN ('CLERK','MANAGER');

SELECT * FROM emp WHERE hiredate BETWEEN '1977-01-01' AND '1987-12-31' AND sal BETWEEN 2000.01 AND 4999.99;

SELECT * FROM emp WHERE job='MANAGER' AND sal NOT BETWEEN 1000 AND 3000;

SELECT * FROM emp WHERE comm IS NULL OR comm=0;

SELECT * FROM emp WHERE mgr IS NULL;

SELECT * FROM emp WHERE (comm IS NOT NULL) AND comm!=0;

SELECT * FROM emp WHERE mgr IS NOT NULL AND (comm IS NULL OR comm=0) AND job IN ('MANAGER','SALESMAN');

SELECT * FROM emp WHERE job LIKE '%MAN%';

SELECT * FROM emp WHERE (job LIKE '%A%' OR job LIKE '%S%') AND CAST (sal AS VARCHAR(10)) LIKE '50%';

SELECT * FROM emp WHERE CAST (sal AS VARCHAR(10)) LIKE '______' AND CAST (hiredate AS VARCHAR(10)) LIKE '1981%';

SELECT ename,hiredate FROM emp WHERE (comm IS NOT NULL AND comm!=0) AND job IN ('MANAGER','SALESMAN') 
AND ename LIKE '%LL%' AND sal>2000 AND CAST (hiredate AS VARCHAR(10)) LIKE '1981%'

SELECT job||ename||'@STRIVER.DE' FROM emp;

SELECT LENGTH(ename) FROM emp;

SELECT MAX(sal) FROM emp;

SELECT MAX(ename) FROM emp;

SELECT MAX(hiredate) FROM emp;

SELECT COUNT(*) FROM emp WHERE deptno = 20;

SELECT MAX(sal),SUM(sal) FROM emp WHERE hiredate>'1980-12-31';

SELECT COUNT(DISTINCT sal) FROM emp;

SELECT AVG(sal) FROM emp WHERE sal BETWEEN 1000 AND 3000 AND hiredate BETWEEN '1981-01-01' AND '1981-12-31';

SELECT deptno, COUNT(*) FROM emp WHERE job = 'SALESMAN' GROUP BY deptno;

SELECT deptno, COUNT(*) FROM emp GROUP BY deptno;

SELECT MAX(sal),job FROM emp WHERE sal>2000 AND job LIKE '%A%' GROUP BY job;

SELECT sal FROM emp GROUP BY sal;

SELECT COUNT(*),SUM(sal),deptno FROM emp WHERE mgr IS NOT NULL AND (comm IS NULL OR comm=0) 
AND hiredate BETWEEN '1982-01-01' AND '1982-12-31' GROUP BY deptno;

SELECT COUNT(*),deptno FROM emp GROUP BY deptno HAVING COUNT(*)>=2;

SELECT COUNT(*),deptno FROM emp WHERE job='SALESMAN' AND sal>1100 GROUP BY deptno HAVING MAX(sal) > 2000;

SELECT MAX(sal),deptno FROM emp WHERE (job='CLERK' OR job='MANAGER')GROUP BY deptno HAVING MAX(sal) > 2000
AND MAX(sal) < 5001;

SELECT sal FROM emp GROUP BY sal HAVING COUNT(*)>1;

SELECT AVG(sal),deptno FROM emp WHERE job = 'MANAGER' AND sal>2000 GROUP BY deptno HAVING SUM(sal) >3000;

SELECT * FROM emp WHERE sal>2000;

SELECT * FROM emp WHERE sal>(SELECT sal FROM emp WHERE ename='SMITH');

SELECT * FROM emp WHERE hiredate>'1980-12-31' AND sal<(SELECT sal FROM emp WHERE ename='JONES');

SELECT ename,hiredate FROM emp WHERE hiredate>(SELECT hiredate FROM emp where ename='ALLEN') 
AND sal>(SELECT sal FROm emp WHERE ename='JONES');

SELECT ename,hiredate FROM emp WHERE hiredate>(SELECT hiredate FROM emp where ename='JAMES') 
AND ename LIKE '%S';

SELECT ename FROM emp WHERE deptno=(SELECT deptno FROM emp WHERE ename='JAMES') AND
sal>(SELECT sal FROM emp WHERE ename='ADAMS') AND job=(SELECT job FROM emp WHERE ename='MILLER') 
AND hiredate>(SELECT hiredate FROM emp WHERE ename='MARTIN');

SELECT COUNT(*) FROM emp WHERE sal>(SELECT sal FROM emp WHERE ename='SMITH') 
AND sal<(SELECT sal FROM emp WHERE ename='MARTIN');

SELECT * FROM emp WHERE deptno=(SELECT deptno from dept where loc='NEW YORK');

SELECT loc FROM dept WHERE deptno=(SELECT deptno FROM emp WHERE ename='ALLEN');

SELECT * FROM emp WHERE hiredate>(SELECT hiredate FROM emp WHERE sal>3000) 
AND deptno=(SELECT deptno FROM dept WHERE loc='BOSTON');

SELECT * FROM emp WHERE job=(SELECT job FROM emp where ename='MILLER') 
AND deptno=(SELECT deptno FROM dept WHERE loc='NEW YORK');

SELECT COUNT(*) FROM emp WHERE job='CLERK' AND deptno=(SELECT deptno FROM emp WHERE ename='SMITH') 
AND sal>(SELECT sal FROM emp WHERE ename='KING') AND hiredate>(SELECT hiredate FROM emp where ename='MARTIN') 
AND deptno=(SELECT deptno FROM dept WHERE loc='BOSTON');

SELECT dname FROM dept WHERE deptno IN (SELECT deptno FROM emp WHERE job='CLERK');

SELECT * FROM emp WHERE sal=(SELECT MAX(sal) FROM emp);

SELECT * FROM emp WHERE sal=(SELECT MAX(sal) FROM emp WHERE sal<(SELECT MAX(sal) FROM emp));

SELECT * FROM emp WHERE sal=(SELECT MAX(sal) FROM emp WHERE sal<(SELECT MAX(sal) FROM emp 
WHERE sal<(SELECT MAX(sal) FROM emp)));

SELECT loc from dept WHERE deptno IN (SELECT deptno FROM emp WHERE sal=(SELECT MAX(sal) FROM emp 
WHERE sal<(SELECT MAX(sal) FROM emp)));

SELECT * FROM emp WHERE sal>(SELECT MAX(sal) FROM emp WHERE ename LIKE '%LL%') AND 
deptno IN (SELECT deptno FROM dept WHERE loc='NEW YORK');

SELECT * FROM emp WHERE sal > ALL(SELECT sal FROM emp WHERE job='CLERK');

SELECT * FROM emp WHERE sal > ANY(SELECT sal FROM emp WHERE job='CLERK');

SELECT * FROM emp WHERE sal > ALL(SELECT sal FROM emp WHERE job='SALESMAN')
AND sal < ANY(SELECT sal FROM emp WHERE job='PRESIDENT');

SELECT * FROM emp  WHERE hiredate>ALL(SELECT hiredate FROM emp WHERE deptno IN 
(SELECT deptno FROM dept WHERE loc='NEW YORK')) AND sal>(SELECT sal FROM emp WHERE ename='%A%' OR ename='%s%');

SELECT * FROM emp WHERE empno=(SELECT mgr FROM emp WHERE ename='SMITH');

SELECT * FROM emp WHERE empno=(SELECT mgr FROM emp WHERE ename='JONES');

SELECT dname FROM dept WHERE deptno=(SELECT deptno FROM emp 
WHERE empno=(SELECT mgr FROM emp WHERE ename='ALLEN'));

SELECT * FROM emp WHERE mgr=(SELECT empno FROM emp WHERE ename='KING');

SELECT * FROM emp WHERE mgr IN (SELECT empno FROM emp WHERE empno IN (SELECT mgr FROM emp WHERE ename='JONES'));
SELECT * FROM emp WHERE MGR IN (SELECT mgr FROM emp WHERE ename = 'JONES');

SELECT * FROM EMP WHERE MGR IN (SELECT empno FROM emp WHERE empno IN 
(SELECT mgr FROM emp WHERE empno IN (SELECT mgr FROM emp WHERE ename = 'WARD')));
SELECT * FROM emp WHERE MGR IN (SELECT mgr FROM emp WHERE empno IN(SELECT mgr FROM emp WHERE ename='WARD'));

--Keep the formula same--
SELECT E1.sal FROM emp E1 WHERE n-1 IN (SELECT COUNT(DISTINCT E2.sal) FROM emp E2 WHERE E1.sal<E2.sal);

--!0th min salary--
SELECT E1.sal FROM emp E1 WHERE 10-1 IN (SELECT COUNT(DISTINCT E2.sal) FROM emp E2 WHERE E1.sal>E2.sal);

SELECT loc FROM dept WHERE deptno=(SELECT E1.deptno FROM emp E1 WHERE sal=(SELECT E1.sal FROM emp E1
WHERE 8-1 IN (SELECT COUNT(DISTINCT E2.sal) FROM emp E2 WHERE E1.sal<E2.sal)));

SELECT E1.sal FROM emp E1 WHERE (SELECT COUNT(DISTINCT E2.sal) FROM emp E2 WHERE E1.sal>E2.sal) IN (3-,4);

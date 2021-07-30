package dept.dao;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

import dept.domain.Dept;
import jdbc.util.ConnectionProvider;

public class DeptDaoTest {
	
	Connection conn = null;
	DeptDao dao = null;

	@Before
	public void setUp() throws Exception {
		conn = ConnectionProvider.getConnection();
		dao = DeptDao.getInstance();
	}

	@Test
	public void testGetDeptList() {
		assertNotNull("deptList 확인", dao.getDeptList(conn));
	}

	@Test
	public void testInsertDept() {
		Dept dept = new Dept(50, "DEVELOPMENT", "SEOUL");
		assertEquals("deptno 50 삽입 확인", 1, dao.insertDept(conn, dept));
	}

	@Test
	public void testDeleteDept() {
		assertSame("deptno 50 삭제 확인",1, dao.deleteDept(conn, 50));
	}

	@Test
	public void testSelectByDeptno() {
		Dept dept = new Dept(10, "ACCOUNTING", "NEW YORK");
		assertEquals("deptno 10번 객체 확인", dept, dao.selectByDeptno(conn, 10));
	}

	@Test
	public void testUpdateDept() {
		Dept dept = new Dept(20, "RESEARCH", "DALLAS1");
		assertTrue("deptno 20번 수정 확인", dao.updateDept(conn, dept) > 0);
	}

}

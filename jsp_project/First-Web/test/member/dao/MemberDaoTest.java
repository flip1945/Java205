package member.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jdbc.util.ConnectionProvider;
import member.dto.Member;

public class MemberDaoTest {

	Connection conn = null;
	MemberDao dao = null;

	@Before
	public void setUp() throws Exception {
		conn = ConnectionProvider.getConnection();
		dao = MemberDao.getInstance();
	}

	@Test
	public void getMembersTest() {
		List<Member> members = dao.getMembers(conn);
		
		assertEquals(new Member("chy", "1111", "채호연", "2021-07-27"), members.get(0));
		assertEquals(new Member("asdf", "asdf", "asdf", "2021-07-30"), members.get(1));

	}

}

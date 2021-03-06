package com.bitcamp.op.member.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.SearchIdPw;

@Repository
public class MybatisMemberDao {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private final String NAME_SPACE = "com.bitcamp.op.member.dao.memberMapper";

	public int insertMember(Member member) throws SQLException {
		return template.update(NAME_SPACE + ".insertMember", member);
	}
	
	public int insertMember1(final Member member) throws SQLException {

		int resultCnt = 0;

//		String sql1 = "insert into member (memberid,password,membername) values (?, ?, ?)";
//		String sql2 = "insert into member (memberid,password,membername, memberphoto) values (?, ?, ?,?)";
//
//		KeyHolder holder = new GeneratedKeyHolder();
//		
//		resultCnt = template.update(new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				PreparedStatement pstmt = con.prepareStatement(sql2, new String[] {"idx"});
//				pstmt.setNString(1, member.getMemberid());
//				pstmt.setNString(2, member.getPassword());
//				pstmt.setNString(3, member.getMembername());
//				pstmt.setNString(4, member.getMemberphoto());
//				return pstmt;
//			}
//		}, holder);
//		
//		Number idx = holder.getKey();
//		member.setIdx(idx.intValue());

		return resultCnt;

	}

	public List<Member> selectList(Connection conn) {

		List<Member> list = null;

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();

			String sql = "select * from member";

			rs = stmt.executeQuery(sql);

			list = new ArrayList<Member>();

			while (rs.next()) {
				list.add(new Member(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4),
						rs.getString(5),
						rs.getTimestamp(6)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}

		return list;

	}
	
	
	public Member selectByIdPw(String id, String pw) {
		return template.selectOne(NAME_SPACE + ".selectByIdPw", new SearchIdPw(id, pw));
	}

	// ID ???????????? ????????? ?????? id ????????? ?????? -> ?????? ??????
	public int selectById(String memberId) throws SQLException {
		return template.selectOne(NAME_SPACE + ".selectById", memberId);
	}
}
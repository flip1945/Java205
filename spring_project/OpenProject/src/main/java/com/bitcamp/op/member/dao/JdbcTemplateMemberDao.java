package com.bitcamp.op.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.member.domain.Member;

@Repository
public class JdbcTemplateMemberDao {
	
	@Autowired
	private JdbcTemplate template;

	public int insertMember(Member member) throws SQLException {

		int resultCnt = 0;

		String sql1 = "insert into member (memberid,password,membername) values (?, ?, ?)";
		String sql2 = "insert into member (memberid,password,membername, memberphoto) values (?, ?, ?,?)";

		if (member.getMemberphoto() != null ) {
			resultCnt = template.update(sql2,
										member.getMemberid(),
										member.getPassword(),
										member.getMembername(),
										member.getMemberphoto());
		} else {
			resultCnt = template.update(sql1,
										member.getMemberid(),
										member.getPassword(),
										member.getMembername());
		}

		return resultCnt;

	}
	
	public int insertMember1(final Member member) throws SQLException {

		int resultCnt = 0;

//		String sql1 = "insert into member (memberid,password,membername) values (?, ?, ?)";
		String sql2 = "insert into member (memberid,password,membername, memberphoto) values (?, ?, ?,?)";

		KeyHolder holder = new GeneratedKeyHolder();
		
		resultCnt = template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql2, new String[] {"idx"});
				pstmt.setNString(1, member.getMemberid());
				pstmt.setNString(2, member.getPassword());
				pstmt.setNString(3, member.getMembername());
				pstmt.setNString(4, member.getMemberphoto());
				return pstmt;
			}
		}, holder);
		
		Number idx = holder.getKey();
		member.setIdx(idx.intValue());

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
		String sql = "select * from member where memberid=? and password=?";
		
		List<Member> members = template.query(sql, new MemberRowMapper(), id, pw);
		
		return (members.isEmpty()) ? null : members.get(0);
	}

	// ID ???????????? ????????? ?????? id ????????? ?????? -> ?????? ??????
	public int selectById(String memberId) throws SQLException {		
		String sql = "select count(*) from member where memberid=?";
		
		int cnt = template.queryForObject(sql, Integer.class, memberId);
		
		return cnt;
	}
}
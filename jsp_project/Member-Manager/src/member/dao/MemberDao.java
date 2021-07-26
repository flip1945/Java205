package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jdbc.util.JdbcUtil;
import member.dto.Member;

public class MemberDao {

	private MemberDao() {}
	
	private static MemberDao dao = new MemberDao();
	
	public static MemberDao getInstance() {
		return dao;
	}
	
	public List<Member> getMembers(Connection conn) {
		List<Member> members = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		String sql = "select * from member order by regdate";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			members = new ArrayList<Member>();
			
			while (rs.next()) {
				members.add(new Member(rs.getString("memberid"), rs.getString("password"), rs.getString("membername"), format.format(rs.getDate("regdate"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		
		return members;
	}
	
	public int insertMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "insert into member (memberid, password, membername) values(?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return result;
	}
	
	public int deleteMemberById(Connection conn, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "delete from member where memberid=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return result;
	}
	
	public int updateMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "update member set password=?, membername=? where memberid=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPw());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return result;
	}
	
	public Member getMemberByIdPw(Connection conn, String userId, String userPw) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		String sql = "select * from member where memberid=? and password=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				member = new Member();
				member.setId(rs.getString("memberid"));
				member.setPw(rs.getString("password"));
				member.setName(rs.getString("membername"));
				member.setRegDate(format.format(rs.getDate("regdate")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return member;
	}
}

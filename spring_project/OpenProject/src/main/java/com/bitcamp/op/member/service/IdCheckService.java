package com.bitcamp.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.member.dao.MemberDao;

@Service
public class IdCheckService {
	
	@Autowired
	private MemberDao dao;

	public String idCheck(String mid) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			result = dao.selectById(conn, mid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (result == 0) ? "Y" : "N";
	}
}

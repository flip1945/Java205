package com.bitcamp.op.member.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.member.dao.JdbcTemplateMemberDao;

@Service
public class IdCheckService {
	
	@Autowired
	private JdbcTemplateMemberDao dao;

	public String idCheck(String mid) {
		int result = 0;
		
		try {
			result = dao.selectById(mid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (result == 0) ? "Y" : "N";
	}
}

package com.bitcamp.op.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.member.dao.Dao;

@Service
public class IdCheckService {
	
	@Autowired
	private SqlSessionTemplate template;
	private Dao dao;
	
	public String idCheck(String mid) {
		int result = 0;
		
		dao = template.getMapper(Dao.class);
		result = dao.selectById(mid);
		
		return (result == 0) ? "Y" : "N";
	}
}

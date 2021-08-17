package com.bitcamp.op.member.dao;

import java.util.List;

import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.SearchType;

public interface Dao {

	public Member selectByIdPw(String id, String pw);
	public int selectById(String memberId);
	public int insertMember(Member member);
	public int updateMember(Member member);
	public int deleteMember(int idx);
	
	public List<Member> selectAll();
	public List<Member> selectList(int startRow, int count);
	public int selectTotalCount();
	public List<Member> selectMember(SearchType searchType);
	
	public Member selectByIdx(int idx);
}

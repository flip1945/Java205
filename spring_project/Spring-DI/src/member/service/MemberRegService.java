package member.service;

import java.util.Date;

import member.dao.Dao;
import member.domain.Member;
import member.domain.RegRequest;

public class MemberRegService {

//	Dao dao = new MemberDao();
	private Dao dao;
	
	// 프로퍼티 방식의 주입 : setter 메소드를 이용, 기본 생성자가 필요
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	// 기본 생성자
	public MemberRegService() {
	}
	
	public MemberRegService(Dao dao) {
		this.dao = dao;
		System.out.println("MemberRegService 인스턴스 생성");
	}
	
	public void regMember(RegRequest request) throws Exception {
		
		Member member = dao.selectByEmail(request.getEmail());
		
		if (member != null) {
			throw new Exception("중복 이메일");
		}
		
		Member newMember = new Member(0, request.getEmail(), request.getPassword(), request.getName(), new Date());
		
		dao.insert(newMember);
	}
}

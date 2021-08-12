package com.bitcamp.op.member.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.member.dao.Dao;
import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.MemberRegRequest;

@Service
public class MemberRegService {
	
	final String UPLOAD_URI = "uploadfile";
	
	@Autowired
	private SqlSessionTemplate template;
	private Dao dao;
	
	public int memberReg(
			MemberRegRequest regRequest,
			HttpServletRequest request) {
		
		int resultCnt = 0;
		File newFile = null;
		
		try {
			String path = request.getSession().getServletContext().getRealPath(UPLOAD_URI);
			File newDir = new File(path);
			
			if(!newDir.exists()) {
				newDir.mkdir();
				System.out.println("저장 폴더를 생성했습니다.");
			}
			String newFileName = regRequest.getMemberid()+System.currentTimeMillis(); 
			newFile = new File(newDir, newFileName);
			
			if(regRequest.getPhoto() != null && !regRequest.getPhoto().isEmpty()) {
				regRequest.getPhoto().transferTo(newFile);
			}
			
			Member member = regRequest.toMember();
			if (!regRequest.getPhoto().isEmpty()) {
				member.setMemberphoto(newFileName);				
			} else {
				member.setMemberphoto("photo.png");
			}
			
			dao = template.getMapper(Dao.class);
			resultCnt = dao.insertMember(member);
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
//		} catch (SQLException e) {
//			if(newFile != null && newFile.exists() ) {
//				newFile.delete();
//			}
//			e.printStackTrace();
		}
		
		return resultCnt;
	}

}
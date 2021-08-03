package member.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import member.dao.Dao;
import member.service.ChangePasswordService;
import member.service.MemberRegService;

public class SpringMain2 {
	
	static ApplicationContext ctx;

	public static void main(String[] args) {
		
		ctx = new GenericXmlApplicationContext("classpath:appCtx4.xml");
		
		// MemberRegService 객체를 컨테이너로부터 받아온다.
		Dao dao1 = ctx.getBean("memberDao", Dao.class); 
		Dao dao2 = ctx.getBean("memberDao", Dao.class);
		System.out.println("============================");
		System.out.println("dao1==dao2 : " + (dao1==dao2));
		
		MemberRegService reg1 = ctx.getBean("regService", MemberRegService.class);
		MemberRegService reg2 = ctx.getBean("regService", MemberRegService.class);
		
		System.out.println("reg1==reg2 : " + (reg1==reg2));
		
		ChangePasswordService pw1 = ctx.getBean("changePwService", ChangePasswordService.class);
		ChangePasswordService pw2 = ctx.getBean("changePwService", ChangePasswordService.class);
		
		System.out.println("pw1==pw2 : " + (pw1==pw2));
	}
	
}

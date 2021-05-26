package ch05;

public class MemberMain {

	public static void main(String[] args) {
		Member member1 = new Member("홍길동", "010-1234-5678", "경제학과", 1, "hong@naver.com", "2000-12-12", "한양");
		Member member2 = new Member("이순신", "010-4567-0123", "해양학과", 4, "Lee1234@naver.com");
		
		member1.setName("김철수");
		
		member1.printMemberInfo();
		member2.printMemberInfo();
		
	}

}

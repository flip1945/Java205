package ch04;

public class Member {
	
	private static int curYear = 2021;
	
	public void checkFluVaccine(int birthYear) {
		int age = curYear - birthYear + 1;
		if ((age < 15) && (age >= 65)) {
			System.out.println("무료예방접종이 가능합니다.");
		} else {
			System.out.println("무료접종 대상이 아닙니다.");
		}
	}
	
	public void checkMeicalCheck(int birthYear) {
		int age = curYear - birthYear + 1;
		if (age > 20) {
			if (curYear % 2 == birthYear % 2) {
				System.out.println("무료건강검진이 가능합니다.");
				if (age >= 40) {
					System.out.println("암 검사도 무료로 가능합니다.");
				}
			} else {
				System.out.println("무료건강검진 대상이 아닙니다.");
			}
		} else {
			System.out.println("20세 이상만 무료로 건강검진이 가능합니다.");
		}
	}

	public static void main(String[] args) {
		
		Member member = new Member();
		
		member.checkFluVaccine(2000);
		member.checkMeicalCheck(2002);
		
		member.checkMeicalCheck(1981);

	}

}

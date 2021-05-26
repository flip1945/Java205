package ch06;

public class StudentMain {
	
	public void printSubScore(String subName, int subSum, int length) {
		System.out.printf("%s 과목의 총점은 %d점입니다.\n", subName, subSum);
		System.out.printf("%s 과목의 평균은 %.1f점입니다.\n", subName, (double)subSum / length);
		System.out.println();
	}

	public static void main(String[] args) {
		Student[] students = new Student[10];
		String[] studentNames = {"김철수", "김영희", "홍길동", "이순신", "김수지", "한지영", "이재영", "최영화", "심인영", "백준영"};
		int korSum = 0;
		int engSum = 0;
		int mathSum = 0;
		
		StudentMain studentMain = new StudentMain();
		
		for (int i = 0; i < students.length; i++) {
			students[i] = new Student(studentNames[i], (int)(Math.random() * 101), (int)(Math.random() * 101), (int)(Math.random() * 101));
		}
		
		for (int i = 0; i < students.length; i++) {
			korSum += students[i].getKorScore();
			engSum += students[i].getEngScore();
			mathSum += students[i].getMathScore();
			
			students[i].printScore();
		}
		
		studentMain.printSubScore("국어", korSum, students.length);
		studentMain.printSubScore("영어", engSum, students.length);
		studentMain.printSubScore("수학", mathSum, students.length);
		
	}

}

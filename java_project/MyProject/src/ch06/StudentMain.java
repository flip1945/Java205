package ch06;

public class StudentMain {
	
	public void printSubScore(String subName, int subSum, int length) {
		System.out.printf("[%s 총점 : %d]\t[%s 평균 : %.1f]", subName, subSum, subName, (double)subSum / length);
		System.out.println();
	}

	public static void main(String[] args) {
		Student[] students = new Student[10];
		String[] studentNames = {"김철수", "김영희", "홍길동", "이순신", "김수지", "한지영", "이재영", "최영화", "심인영", "백준영"};
		int korSum = 0;
		int engSum = 0;
		int mathSum = 0;
		
		StudentMain studentMain = new StudentMain();
		
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("---------------------------------------------");
		
		for (int i = 0; i < students.length; i++) {
			students[i] = new Student(studentNames[i], (int)(Math.random() * 101), (int)(Math.random() * 101), (int)(Math.random() * 101));
		}
		
		for (int i = 0; i < students.length; i++) {
			korSum += students[i].getKorScore();
			engSum += students[i].getEngScore();
			mathSum += students[i].getMathScore();
			
			students[i].printScore();
		}
		
		System.out.println("---------------------------------------------");
		
		studentMain.printSubScore("국어", korSum, students.length);
		studentMain.printSubScore("영어", engSum, students.length);
		studentMain.printSubScore("수학", mathSum, students.length);
		
	}

}

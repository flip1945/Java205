package ch06;

public class StudentMain {

	public static void main(String[] args) {
		Student[] students = new Student[10];
		int korSum = 0;
		int engSum = 0;
		int mathSum = 0;
		
		students[0] = new Student("김철수", 80, 90, 50);
		students[1] = new Student("김영희", 100, 100, 90);
		students[2] = new Student("홍길동", 75, 82, 60);
		students[3] = new Student("이순신", 50, 56, 92);
		students[4] = new Student("김수지", 66, 82, 88);
		students[5] = new Student("한지영", 55, 75, 65);
		students[6] = new Student("이재영", 85, 95, 66);
		students[7] = new Student("최영화", 32, 52, 81);
		students[8] = new Student("심인영", 48, 38, 68);
		students[9] = new Student("백준영", 88, 92, 95);
		
		for (int i = 0; i < students.length; i++) {
			System.out.printf("%s 학생의 총점은 %d점입니다.\n", students[i].getName(), students[i].getScoreSum());
			System.out.printf("%s 학생의 평균은 %.2f점입니다.\n", students[i].getName(), students[i].getScoreAvg());
			System.out.println();
		}
		
		for (int i = 0; i < students.length; i++) {
			korSum += students[i].getKorScore();
			engSum += students[i].getEngScore();
			mathSum += students[i].getMathScore();
		}
		
		System.out.printf("국어 과목의 총점은 %d점입니다.\n", korSum);
		System.out.printf("국어 과목의 평균은 %.2f점입니다.\n", (double)korSum / students.length);
		System.out.println();
		
		System.out.printf("영어 과목의 총점은 %d점입니다.\n", engSum);
		System.out.printf("영어 과목의 평균은 %.2f점입니다.\n", (double)engSum / students.length);
		System.out.println();
		
		System.out.printf("수학 과목의 총점은 %d점입니다.\n", mathSum);
		System.out.printf("수학 과목의 평균은 %.2f점입니다.\n", (double)mathSum / students.length);
		System.out.println();

	}

}

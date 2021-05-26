package ch06;

public class Student {
	private String name;
	private int korScore;
	private int engScore;
	private int mathScore;
	
	public Student(String name, int korScore, int engScore, int mathScore) {
		this.name = name;
		this.korScore = korScore;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKorScore() {
		return this.korScore;
	}
	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}
	public int getEngScore() {
		return this.engScore;
	}
	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}
	public int getMathScore() {
		return this.mathScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	
	public int getScoreSum() {
		return this.korScore + this.engScore + this.mathScore;
	}
	
	public double getScoreAvg() {
		return getScoreSum() / 3;
	}
	
	public void printScore() {
		System.out.printf("%s 학생의 총점은 %d점입니다.\n", this.name, getScoreSum());
		System.out.printf("%s 학생의 평균은 %.2f점입니다.\n", this.name, getScoreAvg());
		System.out.println();
	}
}

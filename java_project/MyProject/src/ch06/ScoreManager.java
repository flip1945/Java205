package ch06;

public class ScoreManager {

	public static void main(String[] args) {
		int[] korScore = new int[10];
		int[] engScore = new int[10];
		int[] mathScore = new int[10];
		int korSum = 0;
		int engSum = 0;
		int mathSum = 0;
		
		for (int i = 0; i < 10; i++) {
			korScore[i] = (int)(Math.random() * 101);
			engScore[i] = (int)(Math.random() * 101);
			mathScore[i] = (int)(Math.random() * 101);
			
			System.out.printf("국어[%d] : %d   영어[%d] : %d   수학[%d] : %d\n", i, korScore[i], i, engScore[i], i, mathScore[i]);
		}
		
		for (int i = 0; i < 10; i++) {
			korSum += korScore[i];
			engSum += engScore[i];
			mathSum += mathScore[i];
		}
		
		System.out.println();
		System.out.printf("국어 합계 : %d   국어 평균 : %.2f\n", korSum, (double)korSum / korScore.length);
		System.out.printf("영어 합계 : %d   영어 평균 : %.2f\n", engSum, (double)engSum / engScore.length);
		System.out.printf("수학 합계 : %d   수학 평균 : %.2f\n", mathSum, (double)mathSum / mathScore.length);
	}
}

package ch09;

public class ExcuteTimeTest {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		long sum = 0;
		
		for (int i = 1; i <= 100000000; i++) {
			sum += i;
		}
		
		System.out.println("합계 : " + sum);
		long endTime = System.currentTimeMillis();
		System.out.println("실행 시간 : " + (endTime - startTime));
	}
}

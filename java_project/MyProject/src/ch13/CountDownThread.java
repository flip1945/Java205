package ch13;

public class CountDownThread extends Thread {

	@Override
	public void run() {
		for (int i = 10; i > 0; i--) {
			if (HighLowGame.check) {
				return;
			}
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println();
		System.out.println("시간초과입니다.");
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}
}

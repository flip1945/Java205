package ex;

public class ShowThreadMain {

	public static void main(String[] args) {
		
		// 쓰레드 인스턴스 생성
		ShowThread t1 = new ShowThread("쓰레드 1");
		ShowThread t2 = new ShowThread("      쓰레드 2");

		// 쓰레드의 실행
		t1.start();
		t2.start();
	}
}

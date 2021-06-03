package ex;

public class RunnableThread {

	public static void main(String[] args) {
		
		// Runnable 타입의 인스턴스 생성
		AdderThread at1 = new AdderThread(1, 50); 
		AdderThread at2 = new AdderThread(51, 100); 
		
		// Thread 인스턴스 생성 (Runnable Type)
		Thread t1 = new Thread(at1);
		Thread t2 = new Thread(at2);
		
		// Thread start() 실행
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("1~100 까지의 숫자 합 : " + (at1.getNum() + at2.getNum()));
	}
}

class AdderThread extends Sum implements Runnable {
	
	private int startNum;
	private int endNum;
	
	public AdderThread(int startNum, int endNum) {
		this.startNum = startNum;
		this.endNum = endNum;
	}

	@Override
	public void run() {
		for (int i = startNum; i <= endNum; i++) {
			System.out.println(i);
			addNum(i);
		}
	}
}

class Sum {
	private int num;
	
	public void addNum(int n) {
		this.num += n;
	}
	
	public int getNum() {
		return this.num;
	}
}
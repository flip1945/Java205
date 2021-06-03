package ex;

public class ThreadSyncTest {

	public static void main(String[] args) {
		
		Increment inc = new Increment();
		
		// 쓰레드 생성
		IncThread it1 = new IncThread(inc);
		IncThread it2 = new IncThread(inc);
		IncThread it3 = new IncThread(inc);
		
		// 쓰레드 실행
		it1.start();
		it2.start();
		it3.start();
		
		try {
			it1.join();
			it2.join();
			it3.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(inc.getNum());
	}
}


class IncThread extends Thread {
	
	Increment inc;
	
	public IncThread(Increment inc) {
		this.inc = inc;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			inc.increment();
		}
	}
}


class Increment {
	
	private int num;
	
	public synchronized void increment() {
		this.num++;
	}
	
	public int getNum() {
		return this.num;
	}
}

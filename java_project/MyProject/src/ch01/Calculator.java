package ch01;

public class Calculator {
	
	public int add(int x, int y) {
		return x + y;
	}
	
	public int sub(int x, int y) {
		return x - y;
	}
	
	public int mul(int x, int y) {
		return x * y;
	}
	
	public int div(int x, int y) {
		return x / y;
	}

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		System.out.println(cal.add(10, 2));
		System.out.println(cal.sub(10, 2));
		System.out.println(cal.mul(10, 2));
		System.out.println(cal.div(10, 2));

	}

}

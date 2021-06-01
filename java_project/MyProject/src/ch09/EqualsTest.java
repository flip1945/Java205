package ch09;

public class EqualsTest {

	public static void main(String[] args) {
		Person p1 = new Person("채호연", "941016-1234567");
		Person p2 = new Person("채호연", "981016-1234567");
		Person p3 = new Person("채호연", "021016-3234567");
		Person p4 = new Person("차호연", "941016-1234567");
		
		System.out.println("p1, p2 비교 : " + p1.equals(p2));
		System.out.println("p1, p3 비교 : " + p1.equals(p3));
		System.out.println("p1, p4 비교 : " + p1.equals(p4));
	}
}

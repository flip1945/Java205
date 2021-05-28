package ex;

public class FriendMain {
	
	public static void main(String[] args) {
		Friend f1 = new Friend("손흥민");
		Friend f2 = new Friend("이강인");
		Friend f3 = new Friend("손흥민");
		
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f3);
		
		System.out.println(f1.equals(f2));
		System.out.println(f1.equals(f3));
	}
	
}

class Friend {
	
	String myName;
	
	public Friend(String name) {
		this.myName = name;
	}
	
	@Override
	public String toString() {
		return "나의 이름은 " + this.myName + "입니다."; 
	}
	
	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Friend) {
			return this.myName.equals(((Friend)o).myName);
		}
		
		return false;
	}
}

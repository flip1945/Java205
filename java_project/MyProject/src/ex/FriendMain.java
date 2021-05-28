package ex;

public class FriendMain {
	
	public static void main(String[] args) {
		Friend f1 = new Friend("손흥민");
		Friend f2 = new Friend("이강인");
		
		System.out.println(f1);
		System.out.println(f2);
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
}

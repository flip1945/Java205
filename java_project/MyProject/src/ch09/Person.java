package ch09;

public class Person {
	private String name;
	private String personNumber;
	
	public Person(String name, String personNumber) {
		this.name = name;
		this.personNumber = personNumber;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPersonNumber() {
		return personNumber;
	}
	public void setPersonNumber(String personNumber) {
		this.personNumber = personNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person && obj != null) {
			return this.personNumber.equals(((Person)obj).getPersonNumber());
		}
		return false;
	}
}

package ch11;

public class FootballPlayer implements Comparable<FootballPlayer> {
	private String name;
	private int number;
	private String team;
	private int age;
	
	public FootballPlayer(String name, int number, String team, int age) {
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return this.age % 3;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj != null && obj instanceof FootballPlayer) {
			String objName = ((FootballPlayer)obj).getName();
			String objTeam = ((FootballPlayer)obj).getTeam();
			int objAge = ((FootballPlayer)obj).getAge();
			
			if (this.name.equals(objName) && this.team.equals(objTeam) && this.age == objAge) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public int compareTo(FootballPlayer f) {
		int comp = 0;
		// 팀으로 비교
		if (this.team.compareTo(f.getTeam()) > 0) {
			comp = 1;
		} else if (this.team.compareTo(f.getTeam()) < 0) {
			comp = -1;
		} else { // 팀이 같은 경우
			// 이름으로 비교
			if (this.name.compareTo(f.getName()) > 0) {
				comp = 1;
			} else if (this.name.compareTo(f.getName()) < 0) {
				comp = -1;
			} else { // 이름이 같은 경우
				// 번호순으로 비교
				if (this.number - f.getNumber() > 0) {
					comp = 1;
				} else if (this.number - f.getNumber() < 0) {
					comp = -1;
				}
			}
		}
		return comp;
	}

	@Override
	public String toString() {
		return "[" + team + ", " + name + ", " + number + "번, " + age + "]";
	}

}

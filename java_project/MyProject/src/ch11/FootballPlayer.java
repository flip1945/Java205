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
			FootballPlayer player = (FootballPlayer)obj;
			
			if (this.name.equals(player.getName()) && this.team.equals(player.getTeam()) && this.age == player.getAge()) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public int compareTo(FootballPlayer player) {
		// 팀으로 비교
		int result = this.team.compareTo(player.getTeam());
		// 팀이 같은 경우
		if (result == 0) {
			// 이름으로 비교
			result = this.name.compareTo(player.getName());
			// 이름이 같은 경우
			if (result == 0) {
				// 번호로 비교
				result = this.number - player.getNumber();
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "[" + team + ", " + name + ", " + number + "번, " + age + "]";
	}

}

package ch09;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalDate {	
	public static void main(String[] args) {
		LocalDate birthDate = LocalDate.of(1994, 10, 16);
		LocalDate curDate = LocalDate.now();
		
		long days = ChronoUnit.DAYS.between(birthDate, curDate);
		System.out.println(birthDate);
		System.out.println(curDate);
		System.out.println(days);
	}
}

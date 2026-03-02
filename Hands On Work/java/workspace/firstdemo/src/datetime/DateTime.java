package datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateTime {

	public DateTime() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		LocalDate futureDate = today.plusDays(10);
		if (futureDate.isAfter(today)) {
			System.out.println("Future date is valid");
		}
		System.out.println(today);
		System.out.println(futureDate);
		Period period = Period.between(today, futureDate);
		System.out.println("Days between dates "+period.getDays());
		LocalDateTime currentTimestamp = LocalDateTime.now();
		System.out.println("Current Timestamp"+currentTimestamp);
		DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
		System.out.println("Formatted Date: "+today.format(dateformatter));
		System.out.println("Formatted Date: "+currentTimestamp.format(datetimeformatter));
	}

}

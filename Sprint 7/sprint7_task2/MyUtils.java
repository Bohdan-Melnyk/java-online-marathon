package sprint7_task2;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class MyUtils {
	public static String getDateAfterToday(int years, int months, int days) {
		LocalDate date = LocalDate.now();
		Period period = Period.of(years, months, days);
		date = date.plus(period);
        String isoLocaldate = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        return isoLocaldate;
    }
}

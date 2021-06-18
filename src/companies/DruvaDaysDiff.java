package companies;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;

public class DruvaDaysDiff {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String d1 = "23-01-1997";
		String d2 = "27-01-1997";
		try {
			Date date1 = sdf.parse(d1);
			Date date2 = sdf.parse(d2);
			long diff = date2.getTime() - date1.getTime();
			System.out.println("iff: "+diff);
			System.out.println("Days: " + diff / 1000L / 60L / 60L / 24L);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}

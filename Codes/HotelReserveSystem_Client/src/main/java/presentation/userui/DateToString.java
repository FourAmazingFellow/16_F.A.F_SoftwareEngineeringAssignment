package presentation.userui;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateToString {

	public String dateToString(Date date) {
		String dateStr = null;
		SimpleDateFormat formater = new SimpleDateFormat();
		formater.applyPattern("yyyy/MM/dd");
		dateStr = formater.format(date);
		return dateStr;

	}

	public Date stringToDate(String dateStr) {
		Date date = null;
		SimpleDateFormat formater = new SimpleDateFormat();
		formater.applyPattern("yyyy/MM/dd");
		try {
			date = (Date) formater.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}

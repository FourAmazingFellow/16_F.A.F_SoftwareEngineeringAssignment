package presentation.userui;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * date和string之间转换的方法类
 * 
 * @author sparkler
 * @version
 * @see
 */
public class DateToString {

	/**
	 * date转string
	 * 
	 * @param date，Date型
	 * @return 返回相应的string
	 */
	public String dateToString(Date date) {
		String dateStr = null;
		SimpleDateFormat formater = new SimpleDateFormat();
		formater.applyPattern("yyyy/MM/dd");
		dateStr = formater.format(date);
		return dateStr;

	}

	/**
	 * string转date
	 * 
	 * @param dateStr，String型
	 * @return 返回相应的date
	 */
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

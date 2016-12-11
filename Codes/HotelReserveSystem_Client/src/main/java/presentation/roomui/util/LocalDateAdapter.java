package presentation.roomui.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDateAdapter {
    
    static private String pattern="yyyy-MM-dd";
    static private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
    static private SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
    
    static public String toString(LocalDate date) {
        if (date != null) {
            return dateFormatter.format(date);
        } else {
            return "";
        }
    }
    
    static public LocalDate fromString(String string) {
        if (string != null && !string.isEmpty()) {
            return LocalDate.parse(string, dateFormatter);
        } else {
            return null;
        }
    }
    
    static public Date toDate(LocalDate date){
        String str=toString(date);
        Date result = null;
        try {
            result=simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    static public LocalDate fromDate(Date date){
        String str=simpleDateFormat.format(date);
        return fromString(str);
    }
}

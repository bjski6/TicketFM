package myapp.utils;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class DateConvert {

    public static String setDateToString (LocalDateTime date){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String dateString=dtf.format(date);
        return dateString;
    }



    public static LocalDateTime setStringToDate(String dateString){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime date = LocalDateTime.parse(dateString, dtf);
        return date;
    }


}

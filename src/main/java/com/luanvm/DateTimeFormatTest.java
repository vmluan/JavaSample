package com.luanvm;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by luan on 9/12/16.
 *
 * Simple example to parse a string like '8302011' to another meaningful word: '08/30/2011'
 */
public class DateTimeFormatTest {
    public SimpleDateFormat simpleDateFormat = new SimpleDateFormat("Mddyyyy");
    public SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MM/dd/yyyy");

    public Date getDate(String source){
        Date date = null;
        try {
            date = simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
    public String parseStringValue(Date date){
        String result = "";
        result = simpleDateFormat2.format(date);
        return result;
    }

    public static void main(String[] args) {
        DateTimeFormatTest obj = new DateTimeFormatTest();
        Date date = obj.getDate("8302011");
        System.out.println(date);
        String result = obj.parseStringValue(date);
        System.out.println(result);
    }
}

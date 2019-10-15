package com.ebbinghaus.util;

import org.junit.jupiter.api.Test;
import springfox.documentation.service.ResourceGroup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtils {

    public static String getDateTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

    public static String getDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }

    public static String getDate(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }


    public static List<String> getABHDateList(String date) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<String> dateList = new ArrayList<>();
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(df.parse(date));
        dateList.add(getDate());
        rightNow.add(Calendar.DAY_OF_YEAR, -1);
        dateList.add(getDate(rightNow.getTime()));
        rightNow.add(Calendar.DAY_OF_YEAR, -2);
        dateList.add(getDate(rightNow.getTime()));
        rightNow.add(Calendar.DAY_OF_YEAR, -4);
        dateList.add(getDate(rightNow.getTime()));
        rightNow.add(Calendar.DAY_OF_YEAR, -7);
        dateList.add(getDate(rightNow.getTime()));
        rightNow.add(Calendar.DAY_OF_YEAR, -15);
        dateList.add(getDate(rightNow.getTime()));
        rightNow.add(Calendar.DAY_OF_YEAR, -30);
        dateList.add(getDate(rightNow.getTime()));
        rightNow.add(Calendar.MONTH, -3);
        dateList.add(getDate(rightNow.getTime()));
        rightNow.add(Calendar.MONTH, -6);
        dateList.add(getDate(rightNow.getTime()));
        return dateList;
    }

    public static String incrByDay(String date) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(df.parse(date));
        rightNow.add(Calendar.DAY_OF_YEAR, -1);
        return getDate(rightNow.getTime());
    }

    public static String formatDateTime(long timeMillis) {
        long day = timeMillis / (24 * 60 * 60 * 1000);
        long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
        long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
        return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
    }
}

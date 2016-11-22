package com.ironyard;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Tom on 11/22/16.
 */
public class test {

    public static DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(sdf.format(date));


    }
}


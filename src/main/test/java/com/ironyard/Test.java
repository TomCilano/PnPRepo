package com.ironyard;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.ironyard.Generation.NameGenerator.generateName;

/**
 * Created by Tom on 11/29/16.
 */
public class Test {
    public static void main (String[] args){
        DateFormat sdf = new SimpleDateFormat("MMd/ ss zz");
        Date date = new Date();
        System.out.print(sdf.format(date));
    }
}

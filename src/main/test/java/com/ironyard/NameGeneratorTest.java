package com.ironyard;


import com.ironyard.generation.D20Gen;

import static com.ironyard.generation.D20Gen.roll;
import static com.ironyard.generation.NameGenerator.generateName;

/**
 * Created by Tom on 11/29/16.
 */
public class NameGeneratorTest {

    public static void main (String[] args){
        for(int i = 1; i <= 10000; i ++)  {
            System.out.print(i+" : ");
            roll();

        }
    }

}

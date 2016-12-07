package com.ironyard.generation;


import java.util.Random;
/**
 * Created by Tom on 11/29/16.
 */

public class NameGenerator {
    /**
     * This method generates a name using the 'first',' second', and 'third' String []
     * @return A randomly generated name
     */
    public static String generateName() {
           Random randomNumber = new Random();
           String[] first = {"Ab", "Ra", "Dig", "Ae", "Kar", "Bar", "Ba", "Lo", "Tor", "Gu","Cal"};
           String[] second = {"ari", "uge", "cori", "cres", "mar", "zur", "ark", "sven"};
           String[] third = {"d", "ed", "ara", "arc", "es", "er", "der", "r",
                "tron", "mea", "ure", "zur", "ed", "mara","","","","",""};
        return first[randomNumber.nextInt(first.length)] + second[randomNumber.nextInt(second.length)] +
                third[randomNumber.nextInt(third.length)];
    }
}

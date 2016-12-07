package com.ironyard;

import static com.ironyard.security.SecurityUtils.genToken;

/**
 * Created by Tom on 11/30/16.
 */
public class GenerateAPIToken {

    /**
     * This method generates a token to use
     * @param args
     */
    public static void main(String[] args){
        try {
            System.out.print(genToken());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}

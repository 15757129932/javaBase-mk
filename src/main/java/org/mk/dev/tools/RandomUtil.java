package org.mk.dev.tools;

import java.util.Random;

public class RandomUtil {


    public static void main(String[] args) {
        System.out.println(getRandomStr(10));
    }

    public static String getRandomStr(int length) {

        String sourceStr = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";

        StringBuffer randomStr = new StringBuffer();

        for (int i = 0; i < length; i++) {
            Random random = new Random();
            int index = random.nextInt(sourceStr.length());
            randomStr.append(sourceStr.charAt(index));
        }

        return randomStr.toString();
    }

}

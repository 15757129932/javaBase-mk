package org.mk.dev.tools;

/***
 * 数字处理类
 */
public class NumUtil {


    public static byte[] long2Byte(long num) {

        byte[] bytes = new byte[8];

        for (int i = 0; i < 8; i++) {
            bytes[i] = (byte) ((num >> 8 * (7 - i)) & 0xff);
        }
        return bytes;

    }
}

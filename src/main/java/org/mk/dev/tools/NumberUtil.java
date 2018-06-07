package org.mk.dev.tools;

/**
 * 数字处理类
 */
public class NumberUtil {


    public static void main(String[] args) {

        byte[] byteArr = long2ByteArr(7458848965656654952L);


        for (byte b : byteArr) {
            System.out.println(b);
        }

        System.out.println(byteArr2Long(byteArr));


    }



    /**
     * long类型转byte类型数组
     *
     * @param num long类型整数
     * @return byte类型数组
     */
    public static byte[] long2ByteArr(long num) {

        byte[] bytes = new byte[8];

        for (int i = 0; i < 8; i++) {
            bytes[i] = (byte) ((num >> 8 * (7 - i)) & 0xff);
        }
        return bytes;

    }

    /**
     * byte类型数组转long类型
     *
     * @param byteArr byte类型数组
     * @return long类型整数
     */
    public static long byteArr2Long(byte byteArr[]) {
        long num = 0;
        for (int i = 0; i < 8; i++) {
            num <<= 8;
            num |= (byteArr[i] & 0xff);
        }
        return num;

    }


}

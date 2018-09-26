package org.mk.dev.algorithm.sort;

/**
 * 简单选择排序
 */
public class SimpleSort {
    public static void main(String[] args) {
        int origin[] = {45, 78, 2, 65, 4, 9, 7, 25, 3658, 1, 3, 59, 648, 25, 34, 65, 1, 89, 7, 8};
        sort(origin, -1);

        for (int i = 0; i < origin.length; i++) {
            System.out.println(origin[i] + "\n");
        }
    }



    //从小到大
    public static int[] sort(int[] origin, int asc) {
        if (origin == null || asc == 0 || origin.length == 0)
            return origin;

        int length = origin.length;

        int min;
        int minIndex=0;

        for (int i = 0; i < length; i++) {

            min = origin[i];
            minIndex = i;

            for (int j = i + 1; j < length; j++) {//找到最小的值和位置
                if (origin[j] < min) {
                    minIndex = j;
                    min = origin[j];
                }
            }

            origin[minIndex] = origin[i];//进行交换
            origin[i] = min;


        }


        return origin;
    }

}

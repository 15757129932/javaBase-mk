package org.mk.dev.algorithm.sort;


/**
 * 冒泡排序   最优的时间复杂度:O(n)  最差时间复杂度:O( n*(n-1)/2 )
 */
public class BubbleSort {


    public static void main(String[] args) {


        int origin[] = {45, 78, 2, 65, 4, 9, 7, 25, 3658, 1, 3, 59, 648, 25, 34, 65, 1, 89, 7, 8};

        sort(origin, 1);

        for (int i = 0; i < origin.length; i++) {
            System.out.println(origin[i] + "\n");
        }


    }


    /**
     * 冒泡排序
     *
     * @param origin 原始数组
     * @param asc    正数代表是升序（从小到大）,负数代表降序（小） ,0代表原先的顺序
     * @return
     */
    public static int[] sort(int origin[], int asc) {

        if (origin == null || asc == 0 || origin.length == 0)
            return origin;

        int length = origin.length;//数据长度
        int tmp;

        if (asc > 0) {
            //从小到大，升序
            for (int i = 0; i < length - 1; i++) {
                for (int j = 0; j < length - 1 - i; j++) {

                    if (origin[j] > origin[j + 1]) {
                        tmp = origin[j];
                        origin[j] = origin[j + 1];
                        origin[j + 1] = tmp;
                    }
                }
            }
        } else {
            //从大到小，升序
            for (int i = 0; i < length - 1; i++) {
                for (int j = 0; j < length - 1 - i; j++) {

                    if (origin[j] < origin[j + 1]) {
                        tmp = origin[j];
                        origin[j] = origin[j + 1];
                        origin[j + 1] = tmp;
                    }
                }
            }
        }

        return origin;
    }


}

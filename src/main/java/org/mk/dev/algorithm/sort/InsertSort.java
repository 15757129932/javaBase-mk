package org.mk.dev.algorithm.sort;

/**
 * 打牌插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int origin[] = {45, 78, 2, 65, 4, 9, 7, 25, 3658, 1, 3, 59, 648, 25, 34, 65, 1, 89, 7, 8};
        sort(origin, -1);

        for (int i = 0; i < origin.length; i++) {
            System.out.println(origin[i] + "\n");
        }
    }

    public static int[] sort(int[] origin, int asc) {
        if (origin == null || asc == 0 || origin.length == 0)
            return origin;
        int length = origin.length;
        int insertNum;
        if (asc > 0) {

            //从小到大
            for (int i = 1; i < length; i++) {

                insertNum = origin[i];
                int j;
                for (j = i - 1; j >= 0 && origin[j] > insertNum; j--) {
                    origin[j + 1] = origin[j];
                }
                origin[j + 1] = insertNum;
            }
        } else {
            //从大到小
            for (int i = 1; i < length; i++) {
                insertNum = origin[i];
                int j;
                for (j = i - 1; j >= 0 && origin[j] < insertNum; j--) {
                    origin[j + 1] = origin[j];
                }
                origin[j + 1] = insertNum;
            }
        }
        return origin;
    }

}

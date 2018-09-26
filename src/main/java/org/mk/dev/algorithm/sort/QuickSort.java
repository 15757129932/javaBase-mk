package org.mk.dev.algorithm.sort;

/**
 * 快速排序
 *
 */
public class QuickSort {
    public static void main(String[] args) {
        int origin[] = {45, 78, 2, 65, 4, 9, 7, 25, 3658, 1, 3, 59, 648, 25, 34, 65, 1, 89, 7, 8};
        sort(origin, 0,origin.length-1);

        for (int i = 0; i < origin.length; i++) {
            System.out.println(origin[i] + "\n");
        }
    }

    public static void sort(int[]a,int start,int end){
        if(start<end){
            int baseNum=a[start];//选基准值
            int midNum;//记录中间值
            int i=start;
            int j=end;
            do{
                while((a[i]<baseNum)&&i<end){
                    i++;
                }
                while((a[j]>baseNum)&&j>start){
                    j--;
                }
                if(i<=j){
                    midNum=a[i];
                    a[i]=a[j];
                    a[j]=midNum;
                    i++;
                    j--;
                }
            }while(i<=j);
            if(start<j){
                sort(a,start,j);
            }
            if(end>i){
                sort(a,i,end);
            }
        }
    }
}

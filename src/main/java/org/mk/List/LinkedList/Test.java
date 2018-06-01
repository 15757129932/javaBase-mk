package org.mk.List.LinkedList;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        List list = new linkedListMK();
        list.add(1);
        list.add("hello world !");
        list.add(null);
//        Integer i = new Integer(1);
//        System.out.println(i.equals());

        Object arr[] = list.toArray();

        for (int i =0 ; i<arr.length ;i++){
            System.out.println(arr[i]);
        }


        //System.out.println(list.contains("hello world !"));

    }


}

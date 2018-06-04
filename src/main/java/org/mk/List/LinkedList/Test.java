package org.mk.List.LinkedList;

import java.util.*;

public class Test {

    public static List list = new linkedListMK();


    public static void main(String[] args) {


        Thread threadAdd = new ThreadAdd();
        Thread threadIterator = new ThreadIterator();
        threadAdd.start();
        try {
            Thread.currentThread().sleep(50);

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        threadIterator.start();


    }


}

class ThreadAdd extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++)
            Test.list.add("ThreadAdd-" + i);
    }


}

class ThreadIterator extends Thread {

    @Override
    public void run() {
        Iterator iterator = Test.list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }


}
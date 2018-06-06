package org.mk.dev.List.LinkedList;

import java.util.*;

public class Test {

    public static List list = new LinkedList();


    public static void main(String[] args) {


        List arrList = new ArrayList();
        List l = new ArrayList();
        l.add("i");
        l.add("love");


        LinkedList linkedList = new LinkedList();
        linkedList.add("milky");
        linkedList.add(",");
        linkedList.add("you");
        linkedList.add("!");


        linkedList.addAll(2, l);

        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }


}


class Person {
    private int age;
    private String name;

    Person() {
    }

    Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

//    @Override
//    public boolean equals(Object obj) {
//
//        if (this == obj) return true;
//
//        if (obj == null) return false;
//
//        if (obj.getClass() != this.getClass()) return false;
//
//        Person person = (Person) obj;
//
//        if (person.age == this.age) {
//
//            if (name == null) {
//                return (person.name == null);
//            } else {
//                return this.name.equals(person.name);
//            }
//
//        } else {
//            return false;
//        }
//
//
//    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}


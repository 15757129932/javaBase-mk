package org.mk.dev.List.LinkedList;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class Test {

    public static List list = new linkedList();


    public static void main(String[] args) {

        Map map = new HashMap();

        Person p =  new Person(25,"doublecong");
        Person p2 =  new Person(25,"doublecong");

        map.put(p,p);
        map.put(p2,p2);

//        for (Person pa : map.keySet()) {
//
//            //Integer value = map.get(pa);
//
//            System.out.println("Key = " + key + ", Value = " + value);
//
//        }
//


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


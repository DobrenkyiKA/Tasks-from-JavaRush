package com.javarush.task.task20.task2017;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) throws ClassNotFoundException {

        try {
            if (objectStream.readObject() instanceof A)
                return (A) objectStream.readObject();
            else
                return null;
        } catch (Exception e) {
            return null;
        }

    }

    public class A implements Serializable{
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
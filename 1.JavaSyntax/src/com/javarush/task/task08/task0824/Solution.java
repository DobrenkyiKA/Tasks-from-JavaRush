package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Human Anton1 = new Human("Anton1", true, 20);
        Human Anton2 = new Human("Anton2", true, 25);
        Human Anton3 = new Human("Anton3", true, 30);


        ArrayList<Human> c3 = new ArrayList<Human>();
        c3.add(Anton1);
        c3.add(Anton2);
        c3.add(Anton3);
        Human Mather = new Human("Mather", false, 50, c3);
        Human Father = new Human("Father", true, 55,  c3);
        ArrayList<Human> m = new ArrayList<Human>();
        m.add(Mather);
        ArrayList<Human> f = new ArrayList<Human>();
        f.add(Father);




        Human Ivan = new Human("Ivan", true, 70,  m);
        Human Maria = new Human("Maria", false, 65,  m);
        Human Ivan1 = new Human("Ivan1", true, 80,  f);
        Human Maria1 = new Human("Maria1", false, 75,  f);


        System.out.println(Anton1.toString());
        System.out.println(Anton2.toString());
        System.out.println(Anton3.toString());
        System.out.println(Mather.toString());
        System.out.println(Father.toString());
        System.out.println(Ivan1.toString());
        System.out.println(Maria1.toString());
        System.out.println(Ivan.toString());
        System.out.println(Maria.toString());

        //напишите тут ваш код
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }
        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            //напишите тут ваш код
        }
        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}

package com.javarush.test.level03.lesson06.task03;

/* Семь цветов радуги
Создать 7 объектов, чтобы на экран вывелись 7 цветов радуги (ROYGBIV).
Каждый объект при создании выводит на экран определенный цвет.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Red red =  new Red();
        red.Red();

        Orange orange =  new Orange();
        orange.Orange();

        Yellow yellow =  new Yellow();
        yellow.Yellow();

        Green green =  new Green();
        green .Green();

        Blue blue =  new Blue();
        blue .Blue();

        Indigo indigo =  new Indigo();
        indigo .Indigo();

        Violet violet =  new Violet();
        violet .Violet();

    }

    public static class Red
    {
        public void Red() {
            System.out.println("Red");
        }
    }

    public static class Orange
    {
        public void Orange() {
            System.out.println("Orange");
        }
    }

    public static class Yellow
    {
        public void Yellow() {
            System.out.println("Yellow");
        }
    }

    public static class Green
    {
        public void Green() {
            System.out.println("Green");
        }
    }

    public static class Blue
    {
        public void  Blue() {
            System.out.println("Blue");
        }
    }

    public static class Indigo
    {
        public void Indigo() {
            System.out.println("Indigo");
        }
    }

    public static class Violet
    {
        public void Violet() {
            System.out.println("Violet");
        }
    }
}
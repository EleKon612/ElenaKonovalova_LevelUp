package ru.levelp.at.EKlesson02.git;

public class Application {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("Сложение");
        System.out.println("2 + 2 =" + calculator.add(2,2));
        System.out.println("2.01 + 2.03 =" + calculator.add(2.01,2.03));
        System.out.println();
        
        System.out.println("Вычитание");
        System.out.println("4 - 2 =" + calculator.subtract(4,2));
        System.out.println();
    }
}

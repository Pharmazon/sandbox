package ru.shcheglov.structural.decorator;

public class Main {

    public static void main(String[] args) {

        Product milk = new Milk(50);

        Product milkDiscount = new MilkDiscount(milk);

        System.out.println(milkDiscount.getPrice());
    }
}








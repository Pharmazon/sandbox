package ru.shcheglov.creational.abstract_factory;

public class ChocolateMilkCocktail implements MilkCocktail {
    @Override
    public void printName() {
        System.out.println("Chocolate milk cocktail");
    }

    @Override
    public void printPrice() {
        System.out.println(150);
    }
}

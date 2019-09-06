package ru.shcheglov.creational.abstract_factory;

public class Main {

    public static void main(String[] args) {

        AbstractFactory factoryChocolate = new ChocolateFactory();
        factoryChocolate.getCake().printName();
        factoryChocolate.getMilkCocktail().printName();

        AbstractFactory factoryCreamy = new CreamyFactory();
        factoryCreamy.getCake().printName();
        factoryCreamy.getMilkCocktail().printName();
    }

}

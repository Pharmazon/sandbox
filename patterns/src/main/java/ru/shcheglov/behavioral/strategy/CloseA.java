package ru.shcheglov.behavioral.strategy;

public class CloseA implements Strategy {

    @Override
    public void openClose() {
        System.out.println("Дверь закрыта.");
    }
}

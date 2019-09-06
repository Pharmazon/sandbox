package ru.shcheglov.behavioral.strategy;

import lombok.Setter;

@Setter
public class DoorA {

    private Strategy strategy;

    public void move() {
        strategy.openClose();
    }
}

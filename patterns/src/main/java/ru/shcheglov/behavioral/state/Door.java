package ru.shcheglov.behavioral.state;

import lombok.Setter;

@Setter
public class Door {

    private State state;

    public void changeState() {
        if (state instanceof Open) {
            setState(new Close());
        } else if (state instanceof Close){
            setState(new Open());
        }
    }

    public void move() {
        state.openClose();
    }
}

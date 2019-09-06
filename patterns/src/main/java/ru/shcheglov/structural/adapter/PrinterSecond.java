package ru.shcheglov.structural.adapter;

public class PrinterSecond extends Printer implements PrintInterface {

    @Override
    public void consolePrint() {
        this.print();
    }

}

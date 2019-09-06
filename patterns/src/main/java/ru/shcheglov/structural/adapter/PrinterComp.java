package ru.shcheglov.structural.adapter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PrinterComp implements PrintInterface {

    private final Printer printer;

    public void consolePrint() {
        printer.print();
    }
}

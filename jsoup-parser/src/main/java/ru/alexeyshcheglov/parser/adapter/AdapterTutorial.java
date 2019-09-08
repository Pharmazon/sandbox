package ru.alexeyshcheglov.parser.adapter;

import java.util.ArrayList;
import java.util.List;

public class AdapterTutorial {
    private List<PrintInterface> list = new ArrayList<>();

    public void p() {
        for (PrintInterface printInterface : list) {
            printInterface.consolePrint();
        }
    }
}

class Client {
    public static void main(String[] args) {
        PrintInterface print = new PrinterSecond();
        print.consolePrint();

        PrintInterface printInterface = new PrinterComp(new Printer());
        printInterface.consolePrint();
    }
}

interface PrintInterface {
    void consolePrint();
}

class Printer {
    void print() {
        System.out.println("Hello.");
    }
}

class PrinterSecond extends Printer implements PrintInterface {
    @Override
    public void consolePrint() {
        this.print();
    }
}

class PrinterComp implements PrintInterface {

    private final Printer printer;

    PrinterComp(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void consolePrint() {
        printer.print();
    }
}

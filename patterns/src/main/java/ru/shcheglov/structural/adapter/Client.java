package ru.shcheglov.structural.adapter;

public class Client {

    public static void main(String[] args) {

        PrintInterface print = new PrinterSecond();
        print.consolePrint();

        PrintInterface printInterface = new PrinterComp(new Printer());
        printInterface.consolePrint();
    }
}

package ru.shcheglov.structural.adapter;

import java.util.ArrayList;
import java.util.List;

public class Adapter {

    private List<PrintInterface> list = new ArrayList<>();

    public void p() {
        for (PrintInterface printInterface : list) {
            printInterface.consolePrint();
        }
    }
}

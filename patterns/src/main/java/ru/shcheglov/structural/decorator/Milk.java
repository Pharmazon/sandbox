package ru.shcheglov.structural.decorator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class Milk implements Product {

    private final int price;

}

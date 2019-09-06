package ru.shcheglov.structural.decorator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
abstract class Decorator implements Product {

    private final Product product;

}

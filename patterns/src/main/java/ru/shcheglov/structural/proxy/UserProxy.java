package ru.shcheglov.structural.proxy;

import java.util.List;

public class UserProxy extends User {

    @Override
    public List<Product> getProducts() {
        if (super.getProducts() == null) {

        }
        return super.getProducts();
    }
}

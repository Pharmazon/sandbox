package ru.shcheglov.structural.decorator;

class MilkDiscount extends Decorator {

    MilkDiscount(Product product) {
        super(product);
    }

    public int getPrice() {
        return getProduct().getPrice() - 15;
    }

}


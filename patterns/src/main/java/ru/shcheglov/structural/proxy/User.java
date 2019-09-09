package ru.shcheglov.structural.proxy;

import java.util.List;

public class User {

    Role role;

    List<Product> products;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

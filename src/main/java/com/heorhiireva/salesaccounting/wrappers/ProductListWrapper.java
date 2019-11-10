package com.heorhiireva.salesaccounting.wrappers;

import com.heorhiireva.salesaccounting.persistence.entity.Product;

import java.util.List;

public class ProductListWrapper {

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

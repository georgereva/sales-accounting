package com.heorhiireva.salesaccounting.persistence.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(
            generator = "UUID"
    )
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(
            name = "product_id",
            updatable = false,
            nullable = false
    )
    private UUID productId;

    private String name;
    private String size;
    private Double price;
    private String parameters;

    public Product() {
    }

    public Product(String name, String size, Double price, String parameters) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.parameters = parameters;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }
}

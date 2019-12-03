package com.heorhiireva.salesaccounting.persistence.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
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
    private String brand;
    private String category;
    private Double price;
    private Double costPrice;
    private String parameters;
    private Integer qty;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH},
            mappedBy = "products"
    )
    private Set<Sale> sales = new HashSet();

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH},
            mappedBy = "products"
    )
    private Set<Supplier> suppliers = new HashSet();

    public void addSupplier(Supplier supplier) {
        if (!this.suppliers.contains(supplier)) {
            supplier.addProduct(this);
            this.suppliers.add(supplier);
        }
    }

    public Product() {
    }

    public Product(String name, String size, String brand, String category, Double price, Double costPrice, String parameters, Integer qty, Set<Sale> sales, Set<Supplier> suppliers) {
        this.name = name;
        this.size = size;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.costPrice = costPrice;
        this.parameters = parameters;
        this.qty = qty;
        this.sales = sales;
        this.suppliers = suppliers;
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

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return name + " [размер: " +  size + " цена: " + price + "]";
    }
}

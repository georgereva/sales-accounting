package com.heorhiireva.salesaccounting.persistence.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    private String name_product;
    private String size;
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
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}
            //mappedBy = "products"
    )
    @JoinTable(
            name = "supplier_product",
            joinColumns = {@JoinColumn(
                    name = "product_id"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "supplier_id"
            )}
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

    public Product(String name_product, String size, Double price, Double costPrice, String parameters, Integer qty, Set<Sale> sales, Set<Supplier> suppliers) {
        this.name_product = name_product;
        this.size = size;
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

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name) {
        this.name_product = name;
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

    @Override
    public String toString() {
        return name_product + " [размер: " +  size + " цена: " + price + "]";
    }
}

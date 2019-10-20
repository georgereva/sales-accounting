package com.heorhiireva.salesaccounting.persistence.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "sale")
public class Sale {
    @Id
    @GeneratedValue(
            generator = "UUID"
    )
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(
            name = "sale_id",
            updatable = false,
            nullable = false
    )
    private UUID saleId;

    private String name;
    private LocalDateTime dateTime;
    private Integer qty;
    private Double sum;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}
    )
    @JoinTable(
            name = "sale_product",
            joinColumns = {@JoinColumn(
                    name = "sale_id"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "product_id"
            )}
    )
    private Set<Product> products = new HashSet();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id", referencedColumnName = "buyer_id")
    private Buyer buyer;

    public Sale() {
    }

    public Sale(String name, LocalDateTime dateTime, Integer qty, Double sum, Set<Product> products, Buyer buyer) {
        this.name = name;
        this.dateTime = dateTime;
        this.qty = qty;
        this.sum = sum;
        this.products = products;
        this.buyer = buyer;
    }

    public UUID getSaleId() {
        return saleId;
    }

    public void setSaleId(UUID saleId) {
        this.saleId = saleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}

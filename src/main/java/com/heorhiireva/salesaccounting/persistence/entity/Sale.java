package com.heorhiireva.salesaccounting.persistence.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personal_id", referencedColumnName = "personal_id")
    private Personal personal;

    public void addProducts(List<Product> products) {
        for (Product product : products) {
            if (!this.products.contains(product)) {
                this.products.add(product);
                product.getSales().add(this);
            }
        }
    }

    public void addBuyer(Buyer buyer) {
        this.buyer = buyer;
        if (!buyer.getSales().contains(this)) {
            buyer.getSales().add(this);
        }
    }

    public void addPersonal(Personal personal) {
        this.personal = personal;
        if (!personal.getSales().contains(this)) {
            personal.getSales().add(this);
        }
    }

    public Sale() {
    }

    public Sale(String name, LocalDateTime dateTime, Integer qty, Double sum, Set<Product> products, Buyer buyer, Personal personal) {
        this.name = name;
        this.dateTime = dateTime;
        this.qty = qty;
        this.sum = sum;
        this.products = products;
        this.buyer = buyer;
        this.personal = personal;
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

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
}

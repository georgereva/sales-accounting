package com.heorhiireva.salesaccounting.persistence.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
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
            name = "order_id",
            updatable = false,
            nullable = false
    )
    private UUID orderId;

    private String name;
    private LocalDateTime dateTime;
    private Integer qty;
    private Double sum;

    public Sale() {
    }

    public Sale(String name, LocalDateTime dateTime, Integer qty, Double sum) {
        this.name = name;
        this.dateTime = dateTime;
        this.qty = qty;
        this.sum = sum;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
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
}

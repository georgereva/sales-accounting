package com.heorhiireva.salesaccounting.persistence.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "personal")
public class Personal {
    @Id
    @GeneratedValue(
            generator = "UUID"
    )
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(
            name = "personal_id",
            updatable = false,
            nullable = false
    )
    private UUID personalId;

    private String name;
    private String surname;
    private String patronymic;
    private String phoneNumber;
    private String address;
    private String position;

    @OneToMany(
            mappedBy = "personal",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Sale> sales = new HashSet<>();

    public Personal() {
    }

    public Personal(String name, String surname, String patronymic, String phoneNumber, String address, String position, Set<Sale> sales) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.position = position;
        this.sales = sales;
    }

    public UUID getPersonalId() {
        return personalId;
    }

    public void setPersonalId(UUID personalId) {
        this.personalId = personalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + patronymic;
    }
}

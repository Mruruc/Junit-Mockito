package com.mruruc.application.entity;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private Long id;
    private LocalDate creationDate;
    private String customerEmail;
    private List<Product> products;
    private boolean isConfirmed;


    public Order() {
    }

    public Order(Long id, LocalDate creationDate,
                 String customerEmail,
                 List<Product> products,
                 boolean isConfirmed) {

        this.id = id;
        this.creationDate = creationDate;
        this.customerEmail = customerEmail;
        this.products = products;
        this.isConfirmed = isConfirmed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", customerEmail='" + customerEmail + '\'' +
                ", products=" + products +
                ", isConfirmed=" + isConfirmed +
                '}';
    }
}

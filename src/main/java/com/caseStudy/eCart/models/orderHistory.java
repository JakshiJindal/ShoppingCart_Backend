package com.caseStudy.eCart.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="history")
public class orderHistory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long hid;
    @Column(name="quantity")
    private int quantity;
    @ManyToOne
    private products items;
    @ManyToOne
    private users user;
    @Column(name="price")
    private int price;
    @Column(nullable = false)
    private LocalDate date;

    public Long getHid() {
        return hid;
    }

    public void setHid(Long hid) {
        this.hid = hid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public products getItems() {
        return items;
    }

    public void setItems(products items) {
        this.items = items;
    }

    public users getUser() {
        return user;
    }

    public void setUser(users user) {
        this.user = user;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return LocalDate.now();
    }

    public void setDate() {
        this.date = LocalDate.now();
    }
}

package com.caseStudy.eCart.models;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;
    @ManyToOne
    private products items;
    @ManyToOne
    private users user;
    @Column(name = "quantity")
    private int quantity;
@Column(name = "total")
private double total;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public cart() {

    }

    public cart(com.caseStudy.eCart.models.products items, com.caseStudy.eCart.models.users user, int quantity) {
        this.items = items;
        this.user = user;
        this.quantity = quantity;

    }

    public Long getId() {
        return cid;
    }

    public void setId(Long id) {
        this.cid = id;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

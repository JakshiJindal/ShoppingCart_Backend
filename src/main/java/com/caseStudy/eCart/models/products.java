package com.caseStudy.eCart.models;

import javax.persistence.*;

@Entity
@Table(name="products")
public class products {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long pid;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private double price;
    @Column(name="category")
    private String category;
    @Column(name="src")
    private String src;
    @Column(name="active")
    private int active;

    public int getActive() {
        return active;
    }

    public void setActive(int active ) {
        this.active = active;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Long getId() {
        return pid;
    }

    public void setId(Long id) {
        this.pid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

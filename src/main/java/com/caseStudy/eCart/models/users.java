package com.caseStudy.eCart.models;

import javax.persistence.*;

@Entity
@Table(name="users")
public class users {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long userid;
    @Column(name="username",unique=true)
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="active")
    private int active;
    @Column(name="role")
    private String role;
    @Column(name="phone")
    private Long phone;
    @Column(name="city")
    private String city;
    @Column(name="email")
    private String email;
    @Column(name="address")
    private String address;

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}

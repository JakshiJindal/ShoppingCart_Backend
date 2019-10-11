package com.caseStudy.eCart.models;

import javax.persistence.*;

@Entity
@Table(name="signUp")
public class SignUp {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long SignUpid;
    @Column(name="username")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="address")
    private String address;
    @Column(name="password")
    private String password;
    @Column(name="city")
    private String city;
    @Column(name="phone")
    private Long phone;

    public Long getSignUpid() {
        return SignUpid;
    }

    public void setSignUpid(Long signUpid) {
        SignUpid = signUpid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}

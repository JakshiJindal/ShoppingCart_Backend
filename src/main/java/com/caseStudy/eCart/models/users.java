package com.caseStudy.eCart.models;

import javax.persistence.*;

@Entity
@Table(name="users")
public class users {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long userid;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="active")
    private int active;
    @Column(name="role")
    private String role;
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

package com.caseStudy.eCart.models;

import javax.persistence.*;

@Entity
public class users {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long userid;
    private String name;
    private String email;
    private String password;
    private Long  phone;
    private String photo;
//    @Embedded
//    private userDetails udr;
users()
{

}

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


}

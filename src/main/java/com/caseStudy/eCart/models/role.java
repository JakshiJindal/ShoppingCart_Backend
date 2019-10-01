package com.caseStudy.eCart.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long roleId;
    private Long role;
    public Long getRoleId() {
        return roleId;
    }

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }



}

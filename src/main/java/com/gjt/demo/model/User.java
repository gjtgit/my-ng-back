package com.gjt.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OauthUser")
public class User {
    @Id
    @GeneratedValue()
    @Column(name="id")
    private int id;
    
    @Column(name="name")
    private String name;
    
    public User() {
        super();
    }
    public User(String name) {
        super();
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}

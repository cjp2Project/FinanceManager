package com.luxoft.financemanager.model;

import javax.persistence.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="name")
    private String userName;

    @Column(name="password")
    private String password;
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "default_report_date")
    private Date defaultReportDate;

    @OneToMany(mappedBy = "user")
    private Collection<ShoppingItem> shoppingItems = new ArrayList<ShoppingItem>();

    public Collection<ShoppingItem> getShoppingItems() {
        return shoppingItems;
    }

    public void setShoppingItems(Collection<ShoppingItem> shoppingItems) {
        this.shoppingItems = shoppingItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDefaultReportDate() {
        return defaultReportDate;
    }

    public void setDefaultReportDate(Date defaultReportDate) {
        this.defaultReportDate = defaultReportDate;
    }


}

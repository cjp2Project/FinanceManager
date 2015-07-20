package com.luxoft.financemanager.model;

import org.hibernate.annotations.Columns;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "shop_branch")
public class ShopBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String branchName;

    @OneToMany(mappedBy = "shopBranch")
    private Collection<Shop> shops = new ArrayList<Shop>();

    public Collection<Shop> getShops() {
        return shops;
    }

    public void setShops(Collection<Shop> shops) {
        this.shops = shops;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @Override
    public String toString() {
        return branchName + "";
    }
}

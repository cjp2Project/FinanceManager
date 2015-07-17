package com.luxoft.financemanager.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "shop_branch_id")
    private ShopBranch shopBranch;

    @OneToMany(mappedBy = "shop")
    private Collection<ShoppingItem> shoppingItems = new ArrayList<ShoppingItem>();

    private String street;

    public Collection<ShoppingItem> getShoppingItems() {
        return shoppingItems;
    }

    public void setShoppingItems(Collection<ShoppingItem> shoppingItems) {
        this.shoppingItems = shoppingItems;
    }
    public ShopBranch getShopBranch() {
        return shopBranch;
    }

    public void setShopBranch(ShopBranch shopBranch) {
        this.shopBranch = shopBranch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}

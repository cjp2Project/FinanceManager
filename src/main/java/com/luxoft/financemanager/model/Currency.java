package com.luxoft.financemanager.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String currencyName;

    @OneToMany(mappedBy = "currency")
    private Collection<ShoppingItem> shoppingItems = new ArrayList<ShoppingItem>();



    public Collection<ShoppingItem> getShoppingItems() {
        return shoppingItems;
    }

    public void setShoppingItems(Collection<ShoppingItem> shoppingItems) {
        this.shoppingItems = shoppingItems;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", currencyName='" + currencyName + '\'' +
                ", shoppingItems=" + shoppingItems +
                '}';
    }
}

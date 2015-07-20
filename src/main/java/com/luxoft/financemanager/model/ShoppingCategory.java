package com.luxoft.financemanager.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "shopping_category")
public class ShoppingCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String shoppingCategoryName;

    @OneToMany(mappedBy = "shoppingCategory")
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

    public String getShoppingCategoryName() {
        return shoppingCategoryName;
    }

    @Override
    public String toString() {
        return "ShoppingCategory{" +
                "id=" + id +
                ", shoppingCategoryName='" + shoppingCategoryName + '\'' +
                ", shoppingItems=" + shoppingItems +
                '}';
    }

    public void setShoppingCategoryName(String shoppingCategoryName) {
        this.shoppingCategoryName = shoppingCategoryName;

    }
}

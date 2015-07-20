package com.luxoft.financemanager.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

@Entity(name = "shopping_item")
public class ShoppingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @ManyToOne
    @JoinColumn(name = "shopping_category_id")
    private ShoppingCategory shoppingCategory;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @Temporal(TemporalType.DATE)
    private Date date;

    private float amount;
    private String description;

    @Lob
    @Column(name="receipt", columnDefinition="mediumblob")
    private byte[] receipt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public ShoppingCategory getShoppingCategory() {
        return shoppingCategory;
    }

    public void setShoppingCategory(ShoppingCategory shoppingCategory) {
        this.shoppingCategory = shoppingCategory;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getReceipt() {
        return receipt;
    }

    public void setReceipt(byte[] receipt) {
        this.receipt = receipt;
    }

    @Override
    public String toString() {
        return "ShoppingItem{" +
                "id=" + id +
                ", user=" + user +
                ", shop=" + shop +
                ", shoppingCategory=" + shoppingCategory +
                ", currency=" + currency +
                ", date=" + date +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", receipt=" + Arrays.toString(receipt) +
                '}';
    }
}

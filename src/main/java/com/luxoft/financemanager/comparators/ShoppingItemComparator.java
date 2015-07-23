package com.luxoft.financemanager.comparators;

import com.luxoft.financemanager.model.ShoppingItem;

import java.util.Comparator;

public class ShoppingItemComparator implements Comparator<ShoppingItem> {
    @Override
    public int compare(ShoppingItem item1, ShoppingItem item2) {
        return item1.getId()- item2.getId();
    }
}

package com.aquamax.realmproductlist;

import io.realm.RealmObject;

/**
 * Created by MADHU on 24-07-2017.
 */

public class Product extends RealmObject
{
   private String name;
    private int qty;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}

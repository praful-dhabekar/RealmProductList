package com.aquamax.realmproductlist;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by MADHU on 24-07-2017.
 */

public class ApplicationDB
{
   Realm r1 = Realm.getDefaultInstance();
   private static ApplicationDB db = null;
   private RealmResults<Product> res;

    private  ApplicationDB()
   {

   }

   public static ApplicationDB getApplicationDB()
   {
      if (db == null)
      {
         db = new ApplicationDB();
         return db;
      }
      return db;
   }

   public void addProduct(String name, int qty)
   {
      r1.beginTransaction();
      Product p1 = r1.createObject(Product.class);
      p1.setName(name);
      p1.setQty(qty);
      r1.commitTransaction();
   }

   public RealmResults<Product> getProducts()
   {
      RealmQuery<Product> q1 = r1.where(Product.class);
      res = q1.findAll();
      return  res;
   }

   public Product getOneProduct(int pos)
   {
       Product p1 = res.get(pos-1);
       return p1;

   }

}

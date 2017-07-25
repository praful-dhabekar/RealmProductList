package com.aquamax.realmproductlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import io.realm.Realm;

public class Main2Activity extends AppCompatActivity {

    TextView prodName,prodQty;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        prodName = (TextView) findViewById(R.id.activity2_product_name);
        prodQty = (TextView) findViewById(R.id.activity2_product_qty);


        Realm r1 = Realm.getDefaultInstance();
        ApplicationDB db1 = ApplicationDB.getApplicationDB();

        Intent i1 = getIntent();
        Bundle b1 = i1.getExtras();
        int pos = b1.getInt("position");
        Product pd1 = db1.getOneProduct(pos);

        prodName.setText(pd1.getName());
        prodQty.setText(""+pd1.getQty());

    }
}

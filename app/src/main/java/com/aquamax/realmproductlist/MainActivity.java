package com.aquamax.realmproductlist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    EditText pname,pqty;
    RecyclerView productrv;
    ProductAdapter adp;
    Realm r1;
    ApplicationDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Realm.init(MainActivity.this);
        db = ApplicationDB.getApplicationDB();
        RealmResults<Product> results = db.getProducts();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        pname =(EditText) findViewById(R.id.product_name);
        pqty  = (EditText)findViewById(R.id.product_qty);
        productrv = (RecyclerView) findViewById(R.id.product_rv);

        RecyclerView.LayoutManager mgr = new LinearLayoutManager(MainActivity.this);
        productrv.setLayoutManager(mgr);
        adp = new ProductAdapter(MainActivity.this,results);
        productrv.setAdapter(adp);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String name = pname.getText().toString();
                String qty  = pqty.getText().toString();

                db.addProduct(name,Integer.parseInt(qty));
                Snackbar.make(view, "Product added", Snackbar.LENGTH_LONG).show();
                adp.notifyDataSetChanged();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

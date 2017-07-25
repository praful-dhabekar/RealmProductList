package com.aquamax.realmproductlist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.RealmResults;

/**
 * Created by MADHU on 21-07-2017.
 */

public class ProductAdapter extends RecyclerView.Adapter
{
    Context ctx;
    RealmResults<Product> results;


    ProductAdapter(Context ctx,RealmResults<Product> results)
    {
        this.ctx = ctx;
        this.results = results;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v1 = LayoutInflater.from(ctx).inflate(R.layout.row,null,false);
        ProductViewHolder pvh = new ProductViewHolder(v1);
        return pvh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {

        ProductViewHolder pvh = (ProductViewHolder) holder;
        Product pd1 = results.get(position);
        pvh.rv_name.setText(pd1.getName());
        pvh.rv_qty.setText(""+pd1.getQty());
    }

    @Override
    public int getItemCount()
    {
        return results.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView rv_name,rv_qty;
        CardView rv_card;

        public ProductViewHolder(View itemView)
        {
            super(itemView);
            rv_name = (TextView) itemView.findViewById(R.id.rv_product_name);
            rv_qty = (TextView) itemView.findViewById(R.id.rv_product_qty);
            rv_card = (CardView) itemView.findViewById(R.id.product_card);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view)
        {
            int pos =  getAdapterPosition()+1;
            Intent i1 = new Intent(ctx,Main2Activity.class);
            i1.putExtra("position",pos);
            ctx.startActivity(i1);
            Toast.makeText(ctx, pos +" item selected",Toast.LENGTH_SHORT).show();
        }
    }
}

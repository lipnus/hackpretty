package com.example.haeun_kim.hackpretty;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;



public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    Context context;
    List<Product> products;
    int prodLayout;


    public RecyclerAdapter(Context context, List<Product> list, int layout) {
        this.context = context;
        this.products = list;
        this.prodLayout = layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.prod_card_view,null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return this.products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // int image;
        TextView name;
        TextView brand;
        TextView score;
        CardView cardView;

        public ViewHolder(View view) {
            super(view);

            name = (TextView) view.findViewById(R.id.txtName);
            brand = (TextView) view.findViewById(R.id.txtBrand);
            score = (TextView) view.findViewById(R.id.txtScore);
            cardView = (CardView) view.findViewById(R.id.card);
        }
    }
}

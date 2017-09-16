package com.example.haeun_kim.hackpretty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_prod_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        List<Product> products = new ArrayList<>();
        Product[] product = new Product[100];

        product[0] = new Product();
        product[1] = new Product();

        for (int i = 0; i < product.length; i++) {
            products.add(product[i]);
        }

        recyclerView.setAdapter(new RecyclerAdapter(getApplicationContext(), products, R.layout.activity_detail));
    }
}

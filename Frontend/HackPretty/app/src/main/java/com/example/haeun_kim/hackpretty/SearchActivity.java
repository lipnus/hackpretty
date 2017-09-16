package com.example.haeun_kim.hackpretty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        
        Button btnSearch = (Button) findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener((v) -> {
            Intent intent = new Intent(SearchActivity.this, MainActivity.class);
            startActivity(intent);
        });

    }
}

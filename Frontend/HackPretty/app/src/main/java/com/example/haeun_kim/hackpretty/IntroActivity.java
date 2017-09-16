package com.example.haeun_kim.hackpretty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class IntroActivity extends BaseActivity {

    ImageView introIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Button btnGoSearch = (Button) findViewById(R.id.btnGoSearch);
        Button btnGoRec = (Button) findViewById(R.id.btnGoRecommend);

        btnGoSearch.setOnClickListener((v) -> {
            Intent intent = new Intent(this, SearchActivity.class);
            startActivity(intent);
        });

        btnGoRec.setOnClickListener((v) -> {
            Intent intent = new Intent(this, RecommendActivity.class);
            startActivity(intent);
        });

    }

}

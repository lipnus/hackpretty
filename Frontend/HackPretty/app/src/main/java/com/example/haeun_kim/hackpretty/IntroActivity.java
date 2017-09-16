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


    }

    public void onClick_intro(View v){
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    public void onClick_recommend(View v){
        Intent intent = new Intent(this, RecommendActivity.class);
        startActivity(intent);
    }
}

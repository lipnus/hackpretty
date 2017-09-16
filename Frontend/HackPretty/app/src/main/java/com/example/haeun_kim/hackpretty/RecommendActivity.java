package com.example.haeun_kim.hackpretty;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class RecommendActivity extends BaseActivity {

    ImageView recommendIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        recommendIv = (ImageView) findViewById(R.id.recommendIv);

        Glide.with(this)
                .load( R.drawable.recommend )
                .into( recommendIv );
        recommendIv.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    public void onClick_recommend(View v){
        finish();
    }
}

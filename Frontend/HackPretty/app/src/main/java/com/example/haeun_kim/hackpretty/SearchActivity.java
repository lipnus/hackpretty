package com.example.haeun_kim.hackpretty;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Button btnSearch = (Button) findViewById(R.id.btnSearch);
        Button btnCamera = (Button) findViewById(R.id.btnCamera);


        btnSearch.setOnClickListener((v) -> {
            Intent intent = new Intent(SearchActivity.this, DetailActivity.class);
            startActivity(intent);
        });

        btnCamera.setOnClickListener((v) -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data.getData() != null) {
            // 찍은 사진 data 처리
        }
    }

}

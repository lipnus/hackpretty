package com.example.haeun_kim.hackpretty;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.tsengvn.typekit.TypekitContextWrapper;


//모든 액티비티는 이 액티비티를 상속
//앱 전체 액티비티에 적용하고 싶은 내용은 이 액티비티에 작성하시면 됩니다

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //시계Bar 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }





}

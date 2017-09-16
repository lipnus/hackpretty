package com.example.haeun_kim.hackpretty;

import android.app.Application;

import com.tsengvn.typekit.Typekit;

/**
 * Created by Sunpil on 2017-09-16.
 */

public class BaseApplication extends Application {

    //서버접속경로
    static final String serverRootPath = "http://163.180.118.201:3000";

    static int score1;
    static int score2;
    static int score3;
    static int score4;


    @Override
    public void onCreate() {

        score1 = 5;
        score2 = 7;
        score3 = 4;
        score4 = 8;


        //폰트 경로설정
        Typekit.getInstance()
                .addNormal(Typekit.createFromAsset(this, "NanumGothic.otf"))
                .addBold(Typekit.createFromAsset(this, "NanumGothicBold.otf"));

        super.onCreate();

    }



}

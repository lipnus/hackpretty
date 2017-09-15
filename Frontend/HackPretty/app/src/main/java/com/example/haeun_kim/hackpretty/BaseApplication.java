package com.example.haeun_kim.hackpretty;

import android.app.Application;

import com.tsengvn.typekit.Typekit;

/**
 * Created by Sunpil on 2017-09-16.
 */

public class BaseApplication extends Application {

    //서버접속경로
    static final String serverRootPath = "http://kumchurk.ivyro.net/app/hacktest.php";

    @Override
    public void onCreate() {
        super.onCreate();

        //폰트 경로설정
        Typekit.getInstance()
                .addNormal(Typekit.createFromAsset(this, "NanumGothic.otf"))
                .addBold(Typekit.createFromAsset(this, "NanumGothicBold.otf"));

    }

}

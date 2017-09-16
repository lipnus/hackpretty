package com.example.haeun_kim.hackpretty;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.android.volley.VolleyError;
import com.example.haeun_kim.hackpretty.volley.IVolleyResult;
import com.example.haeun_kim.hackpretty.volley.VolleyConnect;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity {

    //네트워크를 위한 volley라이브러리
    IVolleyResult mResultCallback = null;
    VolleyConnect volley;

    //뷰페이저
    private ViewPager rankPager;
    private RankPagerAdapter rankPagerAdapter;
    int pagerPosition; //(0,1,2)


    //뷰페이저 위의 탭뷰
    TabLayout tabview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //뷰페이저
        rankPager = (ViewPager) findViewById(R.id.rankPager);

        //뷰페이저 어댑터 연결
        rankPagerAdapter = new RankPagerAdapter( getFragmentManager() );
        rankPagerAdapter.setTabTitle("분석", "성분", "리뷰");
        rankPager.setAdapter(rankPagerAdapter);

        //탭뷰
        tabview = (TabLayout) findViewById(R.id.rankTabview);
        tabview.setupWithViewPager(rankPager);


        //콜백등록
        initVolleyCallback();

        //접속
        connectServer();
    }






    //서버로 post전송
    public void connectServer(){

        //서버경로
        String url = BaseApplication.serverRootPath;

        //Post전송
        Map<String, String> params = new HashMap<>();
        params.put("", "");

        //값을 받아올 리스너, Context, url, post로 보낼 것들의 key와 value들을 담은 해쉬맵
        volley = new VolleyConnect(mResultCallback, this, url, params);
    }

    //콜백받기
    void initVolleyCallback(){
        mResultCallback = new IVolleyResult() {
            @Override
            public void notifySuccess(String response) {
                //전송의 결과를 받는 부분
                Log.d("RESPONSE", response);

            }

            @Override
            public void notifyError(VolleyError error) {
                //전송 중 에러가 생겼을 때
                //reConnectDialog();

            }
        };
    }




}
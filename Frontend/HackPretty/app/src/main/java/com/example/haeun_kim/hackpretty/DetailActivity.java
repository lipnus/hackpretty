package com.example.haeun_kim.hackpretty;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.haeun_kim.hackpretty.volley.IVolleyResult;
import com.github.mikephil.charting.charts.PieChart;

public class DetailActivity extends BaseActivity {

    //네트워크를 위한 volley라이브러리
    IVolleyResult mResultCallback = null;
    VolleyConnect volley;

    //뷰페이저
    private ViewPager rankPager;
    private RankPagerAdapter rankPagerAdapter;
    int pagerPosition; //(0,1,2)

    //제품 이름
    TextView productTextView;

    //제품 이미지뷰
    ImageView productImageView;

    //SearchActivity로부터 받은 prodInfo
    String prodInfo;


    //뷰페이저 위의 탭뷰
    TabLayout tabview;

    PieChart pieChart;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //뷰페이저
        rankPager = (ViewPager) findViewById(R.id.rankPager);

        //뷰페이저 어댑터 연결
        rankPagerAdapter = new RankPagerAdapter( getFragmentManager() );
        rankPagerAdapter.setTabTitle("분석", "성분", "리뷰");
        rankPager.setAdapter(rankPagerAdapter);

        //탭뷰
        tabview = (TabLayout) findViewById(R.id.rankTabview);
        tabview.setupWithViewPager(rankPager);

        //제품이름
        productTextView = (TextView) findViewById(R.id.detail_product_title_textview);

        //제품사진
        productImageView = (ImageView) findViewById(R.id.detail_product_imageview);

        //그래프
        pieChart = (PieChart) findViewById(R.id.chart);





        //앞 액티비티로부터 인텐트를 받아온다
        Intent iT = getIntent();
//        prodInfo = iT.getExtras().getString("prodInfo");




        //테스트
        productTextView.setText("게오니스 순면사랑");



 
    }







}

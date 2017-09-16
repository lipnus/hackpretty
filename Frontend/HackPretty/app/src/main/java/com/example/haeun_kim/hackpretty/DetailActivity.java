package com.example.haeun_kim.hackpretty;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.haeun_kim.hackpretty.dto.DetailData;
import com.example.haeun_kim.hackpretty.volley.IVolleyResult;
import com.github.mikephil.charting.charts.PieChart;
import com.google.gson.Gson;

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


        //앞 액티비티로부터 인텐트를 받아온다
        Intent iT = getIntent();
        if (iT.getExtras() != null) {
            prodInfo = iT.getExtras().getString("prodInfo");
            decodeJson(prodInfo);
        }
    }


    //전송된 json String을 객체화한다
    public void decodeJson(String jsonStr){

        Gson gson = new Gson();

        DetailData detailData= gson.fromJson(jsonStr, DetailData.class);
        Log.d("Response", "객체: " + detailData.getName());


        productTextView.setText("" + detailData.getBrand() + " " + detailData.getName() );

        Glide.with(this)
                .load( "http://163.180.118.201:3000/img/" + detailData.getProd_id() )
                .into( productImageView );


    }




}

package com.example.haeun_kim.hackpretty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.haeun_kim.hackpretty.volley.IVolleyResult;

import java.util.HashMap;
import java.util.Map;

public class ReviewActivity extends AppCompatActivity {

    IVolleyResult mResultCallback = null;
    BaseActivity.VolleyConnect volley;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        initVolleyCallback();

        EditText revContent = (EditText) findViewById(R.id.review_content);
        Button btnConfirm = (Button) findViewById(R.id.btnConfirm);

        btnConfirm.setOnClickListener((v) -> {
            String content = revContent.getText().toString();
            Log.d("CONTENT", content);
            connectServer(content);
            revContent.getText().clear();
            Toast.makeText(ReviewActivity.this, "리뷰가 등록되었습니다", Toast.LENGTH_SHORT).show();
        });

    }

    public void connectServer(String content){

        //서버경로
        String url = BaseApplication.serverRootPath + "/add_review";

        //Post전송
        Map<String, String> params = new HashMap<>();
        params.put("prod_id", Integer.toString(6));
        params.put("author", "cho");
        params.put("score", Integer.toString(3));
        params.put("content", content);


        //값을 받아올 리스너, Context, url, post로 보낼 것들의 key와 value들을 담은 해쉬맵
        volley = new BaseActivity.VolleyConnect(mResultCallback, this, url, params);
    }

    //콜백받기
    void initVolleyCallback(){
        mResultCallback = new IVolleyResult() {
            @Override
            public void notifySuccess(String response) {
                //전송의 결과를 받는 부분
                Log.d("RESPONSE", response);

                //정상적으로 데이터를 받음
                if(!response.equals("reject")){
                    Intent intent = new Intent(ReviewActivity.this, DetailActivity.class);
                    intent.putExtra("prodInfo", response);
                    startActivity(intent);
                } else {

                }


            }

            @Override
            public void notifyError(VolleyError error) {
                //전송 중 에러가 생겼을 때
                //reConnectDialog();

            }
        };
    }
}

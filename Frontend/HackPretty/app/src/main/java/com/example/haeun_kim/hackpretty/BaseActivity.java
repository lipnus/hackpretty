package com.example.haeun_kim.hackpretty;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.haeun_kim.hackpretty.volley.IVolleyResult;
import com.tsengvn.typekit.TypekitContextWrapper;

import java.util.Hashtable;
import java.util.Map;


//모든 액티비티는 이 액티비티를 상속
//앱 전체 액티비티에 적용하고 싶은 내용은 이 액티비티에 작성하시면 됩니다

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //시계Bar 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    //폰트설정
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }


    /**
     * Created by Sunpil on 2017-02-26.
     */

    public static class VolleyConnect {

        //resonse 리스너(즉각 결과가 나오는게 아니고, 접속이 끝나야 결과가 나오므로 호출하는 곳에서는 리스너로 받아야 한다)
        IVolleyResult mResultCallback = null;

        Context context; //이걸 호출한 곳의컨텍스트
        private String UPLOAD_URL; //접속주소
        private Map<String,String> params = new Hashtable<String, String>(); //post할 데이터들을 모아놓은 MAP
        private int dialongOption;

        //생성자
        public VolleyConnect(IVolleyResult resultCallback, Context context, String url, Map<String, String> parmas){
            mResultCallback = resultCallback;
            this.context = context;
            this.UPLOAD_URL = url;
            this.params = parmas;

            //다이얼로그는 보임
            this.dialongOption = 0;
            ConnectServer();
        }

        //Dialong에 대한 옵션을 지정하고 싶을 때 호출하는 생성자
        public VolleyConnect(IVolleyResult resultCallback, Context context, String url, Map<String, String> parmas, int dialogOption){
            mResultCallback = resultCallback;
            this.context = context;
            this.UPLOAD_URL = url;
            this.params = parmas;
            this.dialongOption = dialogOption;

            ConnectServer();


        }

        //volley를 이용하여 서버에 접속
        private void ConnectServer(){

            StringRequest stringRequest = new StringRequest(Request.Method.POST, UPLOAD_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String s) {

                            //결과값은 s;

                            //결과값을 리스너를 통해 전달
                            if(mResultCallback != null){
                                mResultCallback.notifySuccess(s);
                            }

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {

                            //결과값을 리스너를 통해 전달
                            if(mResultCallback != null){
                                mResultCallback.notifyError(volleyError);
                            }
                        }
                    }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    //보내는 부분
                    return params;
                }
            };

            //Creating a Request Queue
            RequestQueue requestQueue = Volley.newRequestQueue(context);

            //Adding request to the queue
            requestQueue.add(stringRequest);
        }

    }
}

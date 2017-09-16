package com.example.haeun_kim.hackpretty;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.util.Base64;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.example.haeun_kim.hackpretty.volley.IVolleyResult;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;


public class SearchActivity extends BaseActivity {

    private static final int PICK_FROM_CAMERA = 1;
    private static final int PICK_FROM_GALLERY = 2;

    //배경
    ImageView backgroundIv;

    //네트워크를 위한 volley라이브러리
    IVolleyResult mResultCallback = null;
    VolleyConnect volley;

    //에디트텍스트
    EditText searchEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Button btnSearch = (Button) findViewById(R.id.btnSearch);
        Button btnCamera = (Button) findViewById(R.id.btnCamera);

        //배경설정
        backgroundIv = (ImageView) findViewById(R.id.search_background);
        Glide.with(this)
                .load( R.drawable.background2 )
                .into(backgroundIv);


        searchEt = (EditText) findViewById(R.id.editSearch);

        //volley콜백 등록하기
        initVolleyCallback();


        //검색버튼
        btnSearch.setOnClickListener((v) -> {

            //서버로 검색어 전송
            connectServer("keyword", searchEt.getText().toString(), "search");

        });

        btnCamera.setOnClickListener((v) -> {
            final CharSequence[] items = {"카메라", "갤러리",};

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("옵션을 선택하세요")
                    .setItems(items, new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int index){
                            if (index == 0) {
                                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(intent, 1);
                            }
                        }
                    });

            AlertDialog dialog = builder.create();
            dialog.show();


        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("CODE", data.getExtras() + "");

        if (requestCode == PICK_FROM_CAMERA) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                Bitmap photo = extras.getParcelable("data");
                sendPhoto(photo); //서버로 사진 전송
            }
        }
        if (requestCode == PICK_FROM_GALLERY) {
            Bundle extras2 = data.getExtras();
            if (extras2 != null) {
                Bitmap photo = extras2.getParcelable("data");
                sendPhoto(photo); //서버로 사진 전송
            }
        }
    }


    //이미지를 전송
    public void sendPhoto(Bitmap photo){

        //이미지를 string으로 변환
        String base64Image = transImgToStr(photo);
        Log.d("RESPONSE", base64Image);
        connectServer("image", base64Image, "img_search");

    }


    //이미지를 Base64의 String으로 변환
    public String transImgToStr(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    //서버로 post전송
    public void connectServer(String key, String value, String path){

        //서버경로
        String url = BaseApplication.serverRootPath + "/" + path;

        //Post전송
        Map<String, String> params = new HashMap<>();
        params.put(key, value);



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


                //정상적으로 데이터를 받음
                if(!response.equals("reject")){
                    Intent intent = new Intent(SearchActivity.this, DetailActivity.class);
                    intent.putExtra("prodInfo", response);
                    startActivity(intent);
                }else{

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

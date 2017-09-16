package com.example.haeun_kim.hackpretty;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Button;
import android.widget.RelativeLayout;


public class SearchActivity extends BaseActivity {

    private static final int PICK_FROM_CAMERA = 1;
    private static final int PICK_FROM_GALLERY = 2;

    RelativeLayout relativeLayout;


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
            }
        }
        if (requestCode == PICK_FROM_GALLERY) {
            Bundle extras2 = data.getExtras();
            if (extras2 != null) {
                Bitmap photo = extras2.getParcelable("data");
            }
        }


        //DetailActivity로 Intent전달
        Intent intent = new Intent(SearchActivity.this, DetailActivity.class);
        startActivity(intent);

    }

}

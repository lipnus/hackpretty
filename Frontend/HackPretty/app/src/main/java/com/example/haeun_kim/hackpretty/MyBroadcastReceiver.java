package com.example.haeun_kim.hackpretty;

/**
 * Created by Sunpil on 2017-09-16.
 */

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

// 방송되고 있는 내용중에 원하는 항목을 받았을 경우
//        처리할 내용을 작성한다  (문자 수신하기)
public class MyBroadcastReceiver extends BroadcastReceiver{

    NotificationManager nm;
    PendingIntent pendingIntent;
    Notification.Builder mBuilder;



    @Override
    public void onReceive(Context context, Intent intent) {
        // 수신되었을 때 호출되는 콜백 메서드


        // SMS 메시지를 파싱합니다.
        Bundle bundle = intent.getExtras();
        String str = ""; // 출력할 문자열 저장
        if (bundle != null) { // 수신된 내용이 있으면
            // 실제 메세지는 Object타입의 배열에 PDU 형식으로 저장됨

            Object [] pdus = (Object[])bundle.get("pdus");

            SmsMessage [] msgs = new SmsMessage[pdus.length];
            for (int i = 0; i < msgs.length; i++) {
                // PDU 포맷으로 되어 있는 메시지를 복원합니다.
                msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
            }

            Toast.makeText(context, "유해물질 함유 상품입니다!", Toast.LENGTH_LONG).show();

            //서비스 호출(노티피케이션)
            Intent intent2 = new Intent(context, MyService.class);
            intent2.putExtra("title", "보솜이 천연코튼 기저귀");
            intent2.putExtra("text", "스틸렌부타디엔공중합체: UN의 유해 화학물질 시스템 GHS에 의해 발암물질로 분류됨");
            context.startService(intent2);

            //해당 물질 액티비티 띄우기
            Intent intent3 = new Intent(context, DetailActivity.class);
            intent3.putExtra("prodInfo", "{\"prod_id\":55,\"brand\":\"보솜이\",\"name\":\"천연코튼\",\"corp\":\"보솜이\",\"img_path\":null,\"score\":0}");
            context.startActivity(intent3);

        }
    } // end of onReceive




} // end of class



package com.example.pocketpetlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BoardContentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_contents);

        //날짜 및 시간 형식 지정
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //Date 객체 사용
        Date date = new Date();
        String time1 = simpleDateFormat.format(date);

        //Calendar 클래스의 getTime()함수 사용
        Calendar calendar = Calendar.getInstance();
        String time2 = simpleDateFormat.format(calendar.getTime());

        //System 클래스의 currentTimeMillis()함수 사용
        String time3 = simpleDateFormat.format(System.currentTimeMillis());

        Log.d("time", "time1 : " + time1);
        Log.d("time", "time2 : " + time2);
        Log.d("time", "time3 : " + time3);
    }
}
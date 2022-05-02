package com.example.pocketpetlayout;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDbHelper myDbHelper = new MyDbHelper(getApplicationContext());

        EditText id1 = (EditText) findViewById(R.id.id1);
        EditText password1 = (EditText) findViewById(R.id.password1);
        Button join1 = (Button) findViewById(R.id.join1);
        Button login1 = (Button) findViewById(R.id.login1);



        login1.setOnClickListener(new View.OnClickListener() { //로그인 버튼을 누르면 메인페이지로 이동
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplication(), HomeActivity.class);
                startActivity(intent);
            }
        });

        // DB에 저장되어 있지 않은 아이디, 비밀번호를 입력할 경우 재입력을 요구하는 Toast 메시지


        join1.setOnClickListener(new View.OnClickListener() { //회원가입 버튼을 누르면 회원가입페이지로 이동
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), JoinActivity2.class);
                startActivity(intent);



            }
        });

    }

}


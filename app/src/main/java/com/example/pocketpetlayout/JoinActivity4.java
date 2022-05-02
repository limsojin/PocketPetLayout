package com.example.pocketpetlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class JoinActivity4 extends AppCompatActivity {

    String petnickSt;
    String petgender;
    public static final String TAG = " joinActivity4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join4);
        Button nextbtn3 = (Button) findViewById(R.id.nextbtn3);


        nextbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                EditText petnickname = (EditText) findViewById(R.id.petnickname); // 닉네임
                Spinner spinner_year = (Spinner)findViewById(R.id.spinner_year); // 월 선택
                Spinner spinner_month = (Spinner)findViewById(R.id.spinner_month); // 년 선택
                RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup); // 성별 선택



                String spinnerYear = spinner_year.getSelectedItem().toString(); // 선택한 년도 spinnerYear에 넣음
                String spinnerMonth = spinner_month.getSelectedItem().toString(); // 선택한 월 spinnerMonth에 넣음
                String BirthDay = spinnerYear + spinnerMonth;
                petnickSt= petnickname.getText().toString(); // 닉네임 넣음

                int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId(); // 선택한 성별 넣음
                if (checkedRadioButtonId == -1) {
                            // No item selected
                }

                else{
                       if (checkedRadioButtonId == R.id.petwoman) {
                                petgender= "암컷";
                       }else if(checkedRadioButtonId == R.id.petman){
                                petgender= "수컷";
                       }
                }

                String emailSt = getIntent().getStringExtra("MEMBER_ID");  //2에서 받고
                String passwordSt2 =getIntent().getStringExtra("PASSWORD");

                String nickSt = getIntent().getStringExtra("NICKNAME"); //3에서 받고
                String birthDay = getIntent().getStringExtra("BIRTHDAY");
                String gender = getIntent().getStringExtra("SEX");

                Log.i(TAG, "Member_id: " + emailSt);


                }
        });
    }
}
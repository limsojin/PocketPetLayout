package com.example.pocketpetlayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BoardContentsActivity extends AppCompatActivity {
    public final static String TAG = "BoardContentsActivity";

    private Toolbar toolbar;

    DBHelper dbHelper;

    int boardId;
    String imgName;
    ImageView imgView;
    TextView titleView;
    TextView nickname;
    TextView reg_dateView;
    TextView contentView;
    TextView heartView;
    TextView commView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_contents);

        setSupportActionBar(toolbar);

        //툴바만들기
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);//기본 제목을 없애줍니다.
        //----------

        // 툴바에 홈버튼을 활성화
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //DB 가져오기
        dbHelper = new DBHelper(getApplicationContext());

        //boardId 받기
        boardId = getIntent().getIntExtra("BoardId", 0);
        Log.i(TAG, " boardId" + boardId);

        imgView = findViewById(R.id.imgView);
        titleView = findViewById(R.id.titleView);
        nickname = findViewById(R.id.nickname);
        reg_dateView = findViewById(R.id.reg_date);
        contentView = findViewById(R.id.contentView);
        heartView = findViewById(R.id.heart);
        commView = findViewById(R.id.comment);

        loadContents();


    }
    //ToolBar에 추가된 항목의 select 이벤트를 처리하는 함수
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return false;
        }
    }
    //--------------

    public void loadContents(){
        Log.i(TAG, "loagContents");
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + Board.TABLE_NAME +
                                    " WHERE " + Board.COLUMN_BOARD_ID + " = " + boardId + " ; ", null);
        if(c.moveToFirst()){
            do{
                String title = c.getString(1);
                String writer = c.getString(2);
                imgName = c.getString(3);
                String contents = c.getString(4);
                int comm = c.getInt(5);
                int like = c.getInt(6);
                String reg_date = c.getString(8);

                Log.i(TAG, "READ title :" + title + "writer :" + writer + "writer :" + writer + "imgName" + imgName + "contents: " + contents + "com : " + comm
                + "like : " + like + " reg_date: " + reg_date );

                titleView.setText(title);
                nickname.setText(writer);
                contentView.setText(contents);
                commView.setText(String.valueOf(comm));
                heartView.setText(String.valueOf(like));
                reg_dateView.setText(reg_date);

                String path = getCacheDir() + "/" + imgName;
                Bitmap bitmap = BitmapFactory.decodeFile(path);

                imgView.setImageBitmap(bitmap);

            }while(c.moveToNext());
        }
        c.close();
        db.close();
    }

}
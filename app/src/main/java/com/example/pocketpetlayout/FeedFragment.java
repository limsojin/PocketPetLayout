package com.example.pocketpetlayout;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FeedFragment extends Fragment {
    private static final String TAG = "FeedFragment";
    ArrayList<NewFeedItem> newFeedItems;
    FloatingActionButton fab;
    GridView gridView;
    MyDbHelper myDbHelper;
    Button search_button;
    EditText search_title;
    String title;
    ImageView imageView;
    //하단 버튼 없애기
    private View decorView;
    private int	uiOption;

    private static int[] imageIDs = {R.drawable.luv, R.drawable.luv2, R.drawable.luv3, R.drawable.luv4};

    public static FeedFragment newInstance(){
        FeedFragment feedFragment = new FeedFragment();
        return feedFragment;
    }
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        myDbHelper = new MyDbHelper(this.getActivity().getApplicationContext());
        View rootView = inflater.inflate(R.layout.fragment_feed, null);

        search_button = rootView.findViewById(R.id.search_button);
        search_title = rootView.findViewById(R.id.search_title);
        imageView = rootView.findViewById(R.id.imageView);

        loadContent();
        gridView=(GridView) rootView.findViewById(R.id.gridview);
        if(newFeedItems.isEmpty()){
            gridView.setAdapter(new FeedAdapter2(rootView.getContext(), imageIDs));
        }
        else{
        FeedAdapter3 feedAdapter3 = new FeedAdapter3(this.getActivity(), newFeedItems);
        Bitmap bm = BitmapFactory.decodeResource(getResources(), getId());
        gridView.setAdapter(feedAdapter3);

        }



        //하단 버튼을 없애는 기능
        decorView = getActivity().getWindow().getDecorView();
        uiOption = getActivity().getWindow().getDecorView().getSystemUiVisibility();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH)
            uiOption |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            uiOption |= View.SYSTEM_UI_FLAG_FULLSCREEN;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            uiOption |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOption);
        //---------------------

        // 플로팅 버튼
        fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), FeedWriteActivity.class); //글쓰기 화면으로 연결
                startActivity(intent); //액티비티 열기
            }
        });

        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = search_title.getText().toString();

                SQLiteDatabase db = myDbHelper.getReadableDatabase();

                Cursor c = db.rawQuery("SELECT * FROM " + Feed.TABLE_NAME + " WHERE " + Feed.FEED_TITLE + " = '" + title + "' ; ",  null );

                if(c.moveToFirst()){
                    do{
                        String feed_title = c.getString(1);
                        String writer = c.getString(2);
                        String image = c.getString(3);
                        Log.i(TAG, "title: " + feed_title);

                        String path = getContext().getCacheDir()+ "/" + image;
                        Bitmap bitmap = BitmapFactory.decodeFile(path);
                        imageView.setImageBitmap(bitmap);

                        //feedAdapter3 = new FeedAdapter3(getContext(), newFeedItems);
                        //gridView.setAdapter(feedAdapter3);
                        //feedAdapter3.notifyDataSetChanged();
                    }while(c.moveToNext());
                }
                c.close();
                db.close();

            }

        });

        return rootView;

    }


    public void loadContent(){
        ImageView imageView = null;
        Log.i(TAG, "loadContents");
        newFeedItems = new ArrayList<NewFeedItem>();

        SQLiteDatabase db = myDbHelper.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM " + Feed.TABLE_NAME + " ORDER BY " + Feed.FEED_ID + " DESC ", null );

        if(c.moveToFirst()){
            do{
                String feed_title = c.getString(1);
                String writer = c.getString(2);
                String image = c.getString(3);

                Log.i(TAG, "title: " + feed_title + "writer: " + writer + "imgName: " + image);
                String path = getContext().getCacheDir()+ "/" + image;

                newFeedItems.add(new NewFeedItem(feed_title, writer, image));

            }while(c.moveToNext());
        }

        c.close();
        db.close();
    }

}
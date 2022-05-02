package com.example.pocketpetlayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;


public class BoardFragment<HomeFragmentBinding> extends Fragment {
    private final String TAG = "BoardFragment";

    private ListView list_items;
    private ListItemsAdapter mListItemsAdapter;

    private TextView myBoard;
    private TextView bestBoard;
    private TextView freeBoard;
    private TextView qnaBoard;
    private TextView adoptBoard;

    private ArrayList<String> mItems;
    private Inflater ResultProfileBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, ": onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_board, container, false);

        // 버튼 이벤트
        myBoard = view.findViewById(R.id.MyBoard);
        bestBoard = view.findViewById(R.id.BestBoard);
        freeBoard = view.findViewById(R.id.FreeBoard);
        qnaBoard = view.findViewById(R.id.QnABoard);
        adoptBoard = view.findViewById(R.id.AdoptBoard);

        myBoard.setOnClickListener(this::onClick);
        bestBoard.setOnClickListener(this::onClick);
        freeBoard.setOnClickListener(this::onClick);
        qnaBoard.setOnClickListener(this::onClick);
        adoptBoard.setOnClickListener(this::onClick);

        // 리스트 아이템
        firstInit(view);    // 객체 초기화 및 생성

        addItem();  // 아이템 리스트 추가

        mListItemsAdapter = new ListItemsAdapter( getActivity().getApplicationContext(), mItems);  // 어뎁터 객체 생성
        list_items.setAdapter(mListItemsAdapter);   // 리스트뷰에 어뎁터 적용

        // 아이템을 클릭 했을 때 동작하는 클릭 리스너
        list_items.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText( getActivity().getApplicationContext(), "position = " + position + ", name = " + mItems.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    // 버튼 클릭 이벤트 리스너
    public void onClick(View view) {
        switch (view.getId()){
            //내가 쓴 글 버튼
            case R.id.MyBoard:
                Intent intent1 = new Intent(getActivity().getApplicationContext(), MyBoardActivity.class);
                startActivity(intent1);
                break;
            //베스트 글 버튼
            case R.id.BestBoard:
                Intent intent2 = new Intent(getActivity().getApplicationContext(), BestBoardActivity.class);
                startActivity(intent2);
                break;
            // 자유 게시판 버튼
            case R.id.FreeBoard:
                Intent intent3 = new Intent(getActivity().getApplicationContext(), FreeBoardActivity.class);
                startActivity(intent3);
                break;
            // QnA 게시판 버튼
            case R.id.QnABoard:
                Intent intent4 = new Intent(getActivity().getApplicationContext(), QnABoardActivity.class);
                startActivity(intent4);
                break;
            //입양 게시판 버튼
            case R.id.AdoptBoard:
                Intent intent5 = new Intent(getActivity().getApplicationContext(), AdoptBoardActivity.class);
                startActivity(intent5);
                break;
        }
    }

    public void firstInit(View v){
        list_items = (ListView) v.findViewById(R.id.list_items);
        mItems = new ArrayList<>();
    }

    public void addItem(){
        mItems.add("item1");
        mItems.add("item2");
        mItems.add("item3");
        mItems.add("item4");
        mItems.add("item5");
    }
}
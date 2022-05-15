package com.example.pocketpetlayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class FeedFragment extends Fragment {

    ArrayList<String> Items;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feed, container, false);

        InitializeFeedData();

        Items.isEmpty();

        getContext().getCacheDir();

        return view;
    }

    //ListView에 넣읗 데이터 초기화 (내부저장소에서 가져온다)
    public void InitializeFeedData(){}

}
package com.example.pocketpetlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView feed_image;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            feed_image = (ImageView) itemView.findViewById(R.id.Feed_image);
        }
    }

    private ArrayList<FeedItem> mFeedList = null;

    public FeedAdapter(ArrayList<FeedItem> mFeedList) {
        this.mFeedList = mFeedList;
    }

    // 아이템 뷰를 위한 뷰홀더 객체를 생성하여 리턴
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.activity_feed_item, parent, false);
        FeedAdapter.ViewHolder vh = new FeedAdapter.ViewHolder(view);
        return vh;
    }

    // position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시
    @Override
    public void onBindViewHolder(@NonNull FeedAdapter.ViewHolder holder, int position) {
        FeedItem item = mFeedList.get(position);

        holder.feed_image.setImageResource(R.drawable.ic_launcher_background); // 사진 없어서 기본 파일로 이미지 띄움
    }

    @Override
    public int getItemCount() {
        return mFeedList.size();
    }
}
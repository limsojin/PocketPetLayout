package com.example.pocketpetlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CommentAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<CommentItem> commentItems;

    public CommentAdapter(Context context, ArrayList<CommentItem> data){
        this.context = context;
        commentItems = data;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return commentItems.size();
    }

    @Override
    public CommentItem getItem(int position) {
        return commentItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View converview, ViewGroup viewGroup) {

        View view = layoutInflater.inflate(R.layout.activity_comm_list_item, null);

        TextView writer = view.findViewById(R.id.txt_writer);
        TextView comment = view.findViewById(R.id.txt_comment);
        TextView reg_date = view.findViewById(R.id.txt_regDate);

        writer.setText(commentItems.get(position).getWriter());
        reg_date.setText(commentItems.get(position).getReg_date());
        comment.setText(String.valueOf(commentItems.get(position).getComment()));

        return view;
    }
}

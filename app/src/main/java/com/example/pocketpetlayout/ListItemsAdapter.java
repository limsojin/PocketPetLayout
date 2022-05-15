package com.example.pocketpetlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListItemsAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<BoardItem> mBoardItmes;

    public ListItemsAdapter(Context mContext, ArrayList<BoardItem> mBoardItmes) {
        this.mContext = mContext;
        this.mBoardItmes = mBoardItmes;
    }

    @Override
    public int getCount() {
        return mBoardItmes.size();
    }

    @Override
    public Object getItem(int position) {
        return mBoardItmes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_list_item, parent, false);
        }

        TextView txt_Title = (TextView) convertView.findViewById(R.id.txt_title);
        TextView txt_Heart = (TextView) convertView.findViewById(R.id.txt_heart);
        TextView txt_Comm =  (TextView) convertView.findViewById(R.id.txt_comm);
        TextView txt_Writer = (TextView) convertView.findViewById(R.id.txt_writer);
        TextView txt_reg_date = (TextView) convertView.findViewById(R.id.txt_regDate);

        txt_Title.setText(mBoardItmes.get(position).getTitle());
        txt_Writer.setText(mBoardItmes.get(position).getWriter());
        txt_reg_date.setText(mBoardItmes.get(position).getReg_date());
        txt_Heart.setText(mBoardItmes.get(position).getHeart());
        txt_Comm.setText(mBoardItmes.get(position).getComment());

        return convertView;
    }
}
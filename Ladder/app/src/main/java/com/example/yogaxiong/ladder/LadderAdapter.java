package com.example.yogaxiong.ladder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by YogaXiong on 2017/4/10.
 */


public class LadderAdapter extends BaseAdapter {
    private Context mContext;
    private List<Ladder> ladders;

    public LadderAdapter(Context mContext, List<Ladder> ladders) {
        super();
        this.mContext = mContext;
        this.ladders = ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    @Override
    public Object getItem(int position) {
        return ladders.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.ladder_list_item, parent, false);
            holder.ipTextView = (TextView) convertView.findViewById(R.id.tv_ip);
            holder.portTextView = (TextView) convertView.findViewById(R.id.tv_port);
            holder.passwordTextView = (TextView) convertView.findViewById(R.id.tv_password);
            holder.encryptionTextView = (TextView) convertView.findViewById(R.id.tv_encryption);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Ladder ladder = ladders.get(position);
        holder.ipTextView.setText(ladder.getIpText());
        holder.portTextView.setText(ladder.getPortText());
        holder.passwordTextView.setText(ladder.getPasswordText());
        holder.encryptionTextView.setText(ladder.getEncriptionText());
        return convertView;
    }

    @Override
    public int getCount() {
        return ladders.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder {
        public TextView ipTextView;
        public TextView portTextView;
        public TextView passwordTextView;
        public TextView encryptionTextView;
    }

}



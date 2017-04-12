package com.example.yogaxiong.ladder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by YogaXiong on 2017/4/10.
 */


public class LadderAdapter extends RecyclerView.Adapter<LadderAdapter.LadderViewHolder> {
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
    public int getItemCount() {
        return ladders.size();
    }

    @Override
    public LadderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LadderViewHolder holder = new LadderViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.ladder_list_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(LadderViewHolder holder, int position) {
        Ladder ladder = ladders.get(position);
        holder.ipTextView.setText(ladder.getIpText());
        holder.portTextView.setText(ladder.getPortText());
        holder.passwordTextView.setText(ladder.getPasswordText());
        holder.encryptionTextView.setText(ladder.getEncriptionText());
    }

    class LadderViewHolder extends RecyclerView.ViewHolder {
        public TextView ipTextView;
        public TextView portTextView;
        public TextView passwordTextView;
        public TextView encryptionTextView;

        public LadderViewHolder(View view) {
            super(view);
            ipTextView = (TextView) view.findViewById(R.id.tv_ip);
            portTextView = (TextView) view.findViewById(R.id.tv_port);
            passwordTextView = (TextView) view.findViewById(R.id.tv_password);
            encryptionTextView = (TextView) view.findViewById(R.id.tv_encryption);
        }
    }

}
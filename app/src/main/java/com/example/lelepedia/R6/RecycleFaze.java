package com.example.lelepedia.R6;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lelepedia.R;

import java.util.ArrayList;

public class RecycleFaze extends RecyclerView.Adapter<RecycleFaze.MyViewHolder>{

    Context context;
    ArrayList<Player> player;

    public RecycleFaze(Context c, ArrayList<Player> p ){
        context = c;
        player = p;
    }

    public RecycleFaze.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RecycleFaze.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview_team,viewGroup, false));
    }

    public void onBindViewHolder(@NonNull RecycleFaze.MyViewHolder holder, int position) {
        holder.nama.setText(player.get(position).getPlayerName());
        holder.nickname.setText(player.get(position).getPlayerNickname());
        holder.tanggal.setText(player.get(position).getPlayerJoin());
    }

    public int getItemCount() {
        return player.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nama,nickname,tanggal;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = (TextView) itemView.findViewById(R.id.TextNama);
            nickname = (TextView) itemView.findViewById(R.id.TextNickname);
            tanggal = (TextView) itemView.findViewById(R.id.TextTanggal);
        }
    }
}
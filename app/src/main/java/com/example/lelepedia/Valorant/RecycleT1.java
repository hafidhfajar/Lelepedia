package com.example.lelepedia.Valorant;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lelepedia.Dota.Player;
import com.example.lelepedia.R;

import java.util.ArrayList;

public class RecycleT1 extends RecyclerView.Adapter<RecycleT1.MyViewHolder>{

    Context context;
    ArrayList<Player> player;

    public RecycleT1(Context c, ArrayList<Player> p ){
        context = c;
        player = p;
    }

    public RecycleT1.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RecycleT1.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview_team,viewGroup, false));
    }

    public void onBindViewHolder(@NonNull RecycleT1.MyViewHolder holder, int position) {
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

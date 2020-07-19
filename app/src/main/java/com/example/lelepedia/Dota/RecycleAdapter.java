package com.example.lelepedia.Dota;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lelepedia.R;
import com.example.lelepedia.Valorant.Player;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder>{

    Context context;
    ArrayList<Player> player;

    public RecycleAdapter(Context c, ArrayList<Player> p ){
        context = c;
        player = p;
    }

    public RecycleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RecycleAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview,viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.MyViewHolder holder, int position) {
        holder.nama.setText(player.get(position).getPlayerName());
        holder.nickname.setText(player.get(position).getPlayerNickname());
        holder.team.setText(player.get(position).getPlayerTeam());
        holder.tanggal.setText(player.get(position).getPlayerJoin());
    }

    @Override
    public int getItemCount() {
        return player.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nama,nickname,team,tanggal;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = (TextView) itemView.findViewById(R.id.TextNama);
            nickname = (TextView) itemView.findViewById(R.id.TextNickname);
            team = (TextView) itemView.findViewById(R.id.TextTeam);
            tanggal = (TextView) itemView.findViewById(R.id.TextTanggal);
        }
    }
}


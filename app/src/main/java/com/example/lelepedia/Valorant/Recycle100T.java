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

public class Recycle100T extends RecyclerView.Adapter<Recycle100T.MyViewHolder>{

    Context context;
    ArrayList<Player> player;

    public Recycle100T(Context c, ArrayList<Player> p ){
        context = c;
        player = p;
    }

    public Recycle100T.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new Recycle100T.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview_team,viewGroup, false));
    }

    public void onBindViewHolder(@NonNull Recycle100T.MyViewHolder holder, int position) {
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

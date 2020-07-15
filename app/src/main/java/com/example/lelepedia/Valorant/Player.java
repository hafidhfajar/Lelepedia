package com.example.lelepedia.Valorant;

public class Player {

    String PlayerId;
    String PlayerName;
    String PlayerNickname;
    String PlayerTeam;
    String PlayerJoin;


    public Player(){

    }


    public Player(String playerId, String playerName, String playerNickname, String playerJoin, String playerTeam) {
        PlayerId = playerId;
        PlayerName = playerName;
        PlayerNickname = playerNickname;
        PlayerTeam = playerTeam;
        PlayerJoin = playerJoin;
    }

    public String getPlayerNickname() {
        return PlayerNickname;
    }

    public String getPlayerId() {
        return PlayerId;
    }

    public String getPlayerName() {
        return PlayerName;
    }

    public String getPlayerTeam() {
        return PlayerTeam;
    }

    public String getPlayerJoin() {
        return PlayerJoin;
    }
}

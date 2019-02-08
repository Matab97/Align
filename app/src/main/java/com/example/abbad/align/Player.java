package com.example.abbad.align;

public class Player {
    int playerid;
    String skinowned3 = "0";
    String skinowned2 = "0";
    String skinowned1 = "0";
    String skinowned4 = "0";
    String skinowned5 = "0";
    String skinowned6 = "0";
    String skinowned7 = "0";
    String skinowned8 = "0";
    String skinowned9 = "0";
    String skinowned10 = "0";
    String skinowned11 = "0";
    String skinowned12 = "0";
    String skinowned13 = "0";
    String boardowned1 = "0";
    String boardowned2 = "0";
    String boardowned3 = "0";
    String boardowned4 = "0";
    String boardowned5 = "0";
    String boardowned6 = "0";
    String mail;
    //static int coins = 0;

    public void setAccount(String account) {
        this.account = account;
    }

    String account;

    public void setHachseq(String hachseq) {
        this.hachseq = hachseq;
    }

    String hachseq;

     public String coins;

    Player(int id) {
        this.playerid = id;
    }
}

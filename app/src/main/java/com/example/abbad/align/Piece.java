package com.example.abbad.align;

public class Piece {
    int owner;
    int position;
    boolean selected ;
    Piece(int owner, int position) {
        this.selected = false;
        this.owner = owner;
        this.position = position;
    }
}

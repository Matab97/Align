package com.example.abbad.align;

public class Board {
    public int level=3;
    public int[] gameState ;
    static int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    //possible mouvements from a certain position except position 4
    static int[][] possiblePositions = {{1, 3, 4}, {0, 4, 2}, {1, 4, 5}, {0,4, 6}, {0, 1, 2}, {2, 4, 8}, {3, 4, 7} ,{ 6, 4, 8}, {5, 4, 7} };
    int activePlayer = 0;
    boolean gameActive;
    boolean movePiece ;
    int numberplayed ;

    Board() {
        this.gameState = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2} ;
        this.activePlayer = 0;
        this.gameActive = true ;
        this.movePiece = false;
        this.numberplayed = 0;
    }
    void selectpiece(int c) {
        this.movePiece = true;
        this.gameState[c] = 2; //this place become free
    }
    void movepiece(int tagid , int playid , int b) {
        this.gameState[tagid] = playid;
        this.activePlayer = b;
    }
    void drop(int tappedCounter,int x) {this.gameState[tappedCounter] = x; }
}

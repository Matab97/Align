package com.example.abbad.align;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.example.abbad.align.vsPlayerActivity.tab;

public class vsAiActivity extends AppCompatActivity {

    Board board = new Board();
    Piece p ;
    List<Piece> PieceList = new ArrayList<Piece>();
    Player player = new Player(0);
    Player robot = new Player(1);
    int decision;
    int[] decisionTab;
    int moveFrom=-1;
    ImageView pastCounter;
    int ptCounter;

    int[] decisionCounter  = {R.id.imageView37,R.id.imageView12,R.id.imageView13,R.id.imageView31,R.id.imageView15,R.id.imageView16,R.id.imageView7,R.id.imageView8,R.id.imageView9};
    public boolean checkWin(int[] game) {
        boolean g = false;
        for (int[] winningPosition : Board.winningPositions) {

            if (game[winningPosition[0]] == game[winningPosition[1]] && game[winningPosition[1]] == game[winningPosition[2]] && game[winningPosition[0]] != 2) {
                // Someone has won!
                g = true;
            }
        }
        return g;
    }
    public boolean checkWin1(int[] game,int k) {
        boolean g = false;

        for (int[] winningPosition : Board.winningPositions) {

            if (game[winningPosition[0]] == game[winningPosition[1]] && game[winningPosition[1]] == game[winningPosition[2]] && game[winningPosition[0]] != 2) {
                // Someone has won!
                g = game[winningPosition[0]]==k;
            }
        }
        return g;
    }
   // Map<Integer,Integer> pi =new HashMap<Integer,Integer>();
    List hl =new ArrayList<>();
    Map<List,Integer> ma =new HashMap<>();
    public  Integer ai(int board[],int level,int n) {
        if (checkWin1(board, 1)) {
            return 1;
        } else if (checkWin1(board, 0)) {
            return -1;
        } else if (n == level) {
            return 0;
        } else {
            Map<List,Integer> m =new HashMap<>();
            ///Map<Integer,Integer>v = new HashMap<>();
            List v =new ArrayList<>();
            for (int i = 0; i <9 ; i++) {
            if((n%2==0?1:0)==board[i]){
               // Map<Integer,Integer> hm=new HashMap<Integer,Integer>();
                if(i==4)
                {
                    for (int j = 0; j <9 ; j++) {

                        if(board[j]==2 && j!=4){v.add(i);v.add(j);}
                    }
                }else{
                    for (int j = 0; j <3 ; j++) {
                        if(board[Board.possiblePositions[i][j]]==2){v.add(i);v.add(Board.possiblePositions[i][j]);}
                    }
                }
            }
            }
            int x=-2;
            int[] hm={0,0,0,0,0,0,0,0,0};
            for (int i = 0; i <v.size() ; i+=2) {

                int[] boar =board;
                boar[(int)v.get(i)]=2;boar[(int)v.get(i+1)]=(n%2==0?1:0);
                List pi =new ArrayList<>();
                pi.add((int)v.get(i));pi.add((int)v.get(i+1));
           //     hm.put(keys,v.get(keys));
                m.put(pi,ai(boar,level,n+1));
                if(x< m.get(pi)){x= m.get(pi);}
            }
            ma=m;
            return x;
        }
    }
    public int[] Minimax(int[] game ,int level,int n, int numPlayed) {
        int[] res = {0, 0};
        /*Random random = new Random();
        int cnt=random.nextInt(3);
        int j =0;
        for(int i=0;i<9;i++){if(game[i] == 1 && j++ == cnt) res[0] =i;}
        // if that piece can't move
        if(game[Board.possiblePositions[res[0]][0]]!=2 && game[Board.possiblePositions[res[0]][1]]!=2 && game[Board.possiblePositions[res[0]][2]]!=2){cnt++;cnt%=3;
            j=0;for(int i=0;i<9;i++){if(game[i] == 1 && j++ == cnt) res[0] =i;}}
        if(game[Board.possiblePositions[res[0]][0]]!=2 && game[Board.possiblePositions[res[0]][1]]!=2 && game[Board.possiblePositions[res[0]][2]]!=2){cnt++;cnt%=3;
            j=0;for(int i=0;i<9;i++){if(game[i] == 1 && j++ == cnt) res[0] =i;}}
        cnt=random.nextInt(2);
        res[1] = Board.possiblePositions[res[0]][cnt];
        while(game[res[1]]!=2){cnt=random.nextInt(2);res[1] = Board.possiblePositions[res[0]][cnt];}
        Log.i("value" ,"Minimax: "+ res[0]);
        //logi(Tag,"Minimax: "+ res[1]);
        *///Log.i(TAG, "Minimax: ");
        ma.clear();
        int boar[]= game;
        int tr=ai(boar,level,n);
        int x=-2;
        //Map<Integer,Integer> hm= new HashMap<Integer,Integer>();
        for ( List l : ma.keySet()) {
            if(x< ma.get(l)){x= ma.get(l);res[0]=Integer.parseInt(l.get(0).toString());res[1]=Integer.parseInt(l.get(1).toString());}
        }
        return res;
    }
    public int initPlayer(int[] game , int numPlayed) {
        int res=0 ;
        Random random = new Random();
        while(game[res]!=2)res=random.nextInt(9);
        Log.i("value" ,"Minimax: "+ res);
        Toast.makeText(this,"Minimax: "+ res,Toast.LENGTH_LONG);
        return res;
    }

    public void dropIn(View view) {
        ImageView counter = (ImageView) view;
        ImageView counterAi;
        ImageView counterAiTo;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        //Toast.makeText(this ,counter.getTag().toString()+" has been touched",Toast.LENGTH_LONG).show();
        TextView turn = (TextView) findViewById(R.id.turnTextView);
        if (board.gameActive && board.numberplayed < 6) {
            if (board.gameState[tappedCounter] == 2) {
                board.numberplayed+=2;//both players will play
                // human decision
                this.board.drop(tappedCounter,this.board.activePlayer);
                this.p = new Piece(this.board.activePlayer, tappedCounter);
                this.PieceList.add(this.p);
              //  counter.setTranslationY(-1000);
                int ch = tab[(PieceShopActivity.selectedPiece ) * (1-board.activePlayer)];
                counter.setImageResource(R.drawable.piece1+ch);
                board.activePlayer =1; // robot play
                //counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
               // counter.animate().translationYBy(1000).setDuration(200);
                board.gameActive = !checkWin1(board.gameState,board.activePlayer);
                //A.I decision
                if(board.gameActive) {
                    decision = initPlayer( board.gameState  , board.numberplayed);
                    //for(int i=0;i<9;i++ ) {if (board.gameState[i] == 2) decision = i; }
                    Toast.makeText(this,"DECISION: "+ decision,Toast.LENGTH_LONG).show();
                    board.drop(decision,1);
                    this.p = new Piece(this.board.activePlayer, this.decision);
                    this.PieceList.add(this.p);
                    //0x7f070049 IS THE ID OF IMAGEVIEW1
                    counterAi = (ImageView)findViewById(decisionCounter[decision]);
                    counterAi.setTranslationY(-1000);
                     ch = tab[(PieceShopActivity.selectedPiece ) * (1-board.activePlayer)];
                    counterAi.setImageResource(R.drawable.piece1+ch);
                    counterAi.animate().translationYBy(1000).setDuration(100);
                    board.activePlayer =0;
                    board.gameActive = !checkWin1(board.gameState,board.activePlayer);
                }
            }
        }
        //Yellow player have already played 3 times
        //else if(gameActive && gameState[tappedCounter] == 0 && (activePlayer==0 && numberOfYellowPlayed<3))
        else if ((board.gameActive) ) {
            if (!board.movePiece) {
                if (this.board.gameState[tappedCounter] == player.playerid) {
                    for (Piece Element : PieceList) {
                        if (Element.position == tappedCounter) { Element.selected = true; } }
                    pastCounter = counter;
                    //ptCounter = tappedCounter;
                    board.selectpiece(tappedCounter);
                    counter.setImageDrawable(null);
                    moveFrom = tappedCounter;
                    board.movePiece = true;

                }
            } else {
                //see if this move is possible
                if (board.gameState[tappedCounter] == 2 && ((moveFrom == 4 && tappedCounter != 4) || (tappedCounter == Board.possiblePositions[moveFrom][0] || tappedCounter == Board.possiblePositions[moveFrom][1] || tappedCounter == Board.possiblePositions[moveFrom][2]))) {

                    //counter.setImageResource(R.drawable.goldfish);
                    board.gameState[tappedCounter]=0;
                    for (Piece Element : PieceList) {
                        if (Element.position == moveFrom) {
                            Element.position = tappedCounter;
                        }
                    }
                    int ch = tab[(PieceShopActivity.selectedPiece ) * (1-board.activePlayer)];
                    counter.setImageResource(R.drawable.piece1+ch);
                    board.gameActive = !checkWin1(board.gameState,board.activePlayer);
                    board.activePlayer =1;
                    //robot turn

                    if(board.gameActive)
                    {
                        this.decisionTab = Minimax(this.board.gameState,board.level,0,this.board.numberplayed);
                        Toast.makeText(this,"DECISION0: "+ decisionTab[0]+" DECISION1: "+ decisionTab[1],Toast.LENGTH_LONG).show();

                        for (Piece Element : PieceList) {
                            if (Element.position == decisionTab[0]) { Element.selected = true;Element.position = this.decisionTab[1]; } }
                        board.movePiece=true;
                        counterAi = (ImageView)findViewById(decisionCounter[decisionTab[0]]);
                        counterAi.setImageDrawable(null);
                        board.gameState[decisionTab[0]]=2;
                        board.gameState[decisionTab[1]]=1;

                        counterAiTo = (ImageView)findViewById(decisionCounter[decisionTab[1]]);
                         ch = tab[(PieceShopActivity.selectedPiece ) * (1-board.activePlayer)];
                        counterAiTo.setImageResource(R.drawable.piece1+ch);
                        board.gameActive = !checkWin1(board.gameState,board.activePlayer);
                        board.activePlayer= 0;
                    }
                }else {
                    //move failed return to previous state

                    board.gameState[moveFrom] = 0;
                    int ch = tab[(PieceShopActivity.selectedPiece ) * (1-board.activePlayer)];
                    pastCounter.setImageResource(R.drawable.piece1+ch);

                }
                this.board.movePiece = false;
                for (Piece Element : PieceList) {
                    if (Element.position == tappedCounter ||Element.position == moveFrom ) { Element.selected = false; } }
                this.moveFrom = -1;
            }
        }
        //Red player have already played 3 times
        //else if(gameActive && gameState[tappedCounter] == 1 && (activePlayer==1 && numberOfRedPlayed<3))

        if (board.activePlayer == 0) {
            //turn.setText("     Yellow's turn");
            turn.setText("     P1 turn");
        } else {
            //turn.setText("Red's turn");
            turn.setText("     P2 turn");
        }

        //if(!gameActive)turn.setVisibility(view.INVISIBLE);
        if (checkWin1(board.gameState,1) || !checkWin1(board.gameState,0)) {
            board.gameActive = false;
            // Button playAgainButton = (Button) findViewById(R.id.playAgainButton);

            TextView winnerTextView = findViewById(R.id.winnerTextView);

            String winner;

            if (board.activePlayer == 1) {

                //winner = "Yellow";
                winner = "P1";

            } else {

                // winner = "Red";
                winner = "P2";

            }

            winnerTextView.setText(winner + " has won!");

            //playAgainButton.setVisibility(View.VISIBLE);

            winnerTextView.setVisibility(View.VISIBLE);
            turn.setVisibility(View.INVISIBLE);
        }

        //if(!gameActive)turn.setVisibility(view.INVISIBLE);
    }
    /*
        public int  minimax(int game[] ,boolean player){

            //available spots
            //var availSpots = à definir selon l'emplacement des pierres;$
            //player==0(human) player==1(AI)
            if ((checkWin(game) && !player)  ){
                return -10;
            }
            else if (checkWin(game) && player  ){
                return 10;
            }else if(cnt == 6){
                return 0;
            }
        // an array to collect all the objects
        //List moves = new ArrayList();
        // loop through available spots
            int
      for(int i = 0; i < 9 ; i++) {
          //create an object for each and store the index of that spot
          var move = {};
          move.index = newBoard[availSpots[i], availSpots[i].val]

          // set the empty spot to the current player
          newBoard[availSpots[i]] = player;
          newBoard[availSpots[i].val] = empty;

        //collect the score resulted from calling minimax
          //on the opponent of the current player

          if (player) {
              int result = minimax(game, false);cnt++;
              move.score = result;
          } else {
              int result = minimax(game, true);cnt++;
              move.score = result;
          }
    // reset the spot to empty
          newBoard[availSpots[i]] = move.index;
      }
            // push the object to the array
    // if it is the computer's turn loop over the moves and choose the move with the highest score
            int bestMove;
            if(player ){
                var bestScore = -10000;
                for(var i = 0; i < moves.length; i++){
                    if(moves[i].score > bestScore){
                        bestScore = moves[i].score;
                        bestMove = i;
                    }
                }
            }else{

    // else loop over the moves and choose the move with the lowest score
                var bestScore = 10000;
                for(var i = 0; i < moves.length; i++){
                    if(moves[i].score < bestScore){
                        bestScore = moves[i].score;
                        bestMove = i;
                    }
                }
            }

    // return the chosen move (object) from the moves array
            return moves[bestMove];
        }
        */
    public void playAgain(View view) {

        //Button playAgainButton = (Button) findViewById(R.id.playAgainButton);

        TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);

        //playAgainButton.setVisibility(View.INVISIBLE);

        winnerTextView.setVisibility(View.INVISIBLE);
        TextView turn = (TextView) findViewById(R.id.turnTextView);

        turn.setVisibility(view.VISIBLE);
        turn.setText("     P1 turn");

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        for (int i = 0; i < gridLayout.getChildCount(); i++) {

            ImageView counter = (ImageView) gridLayout.getChildAt(i);

            counter.setImageDrawable(null);

        }

        for (int i = 0; i < board.gameState.length; i++) {

            board.gameState[i] = 2;

        }

        board.activePlayer = 0;

        board.gameActive = true;

        board.numberplayed=0;
        // roundCounter=0;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vs_ai);
    }

}
package com.example.abbad.align;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BoardShopActivity extends AppCompatActivity {
    public static int selectedBoard = 1;
    //il faut verifier que le joueur est connecté pour prendre son score
    int score = Integer.parseInt(LoginActivity.Coins);
    int boardPrice[] = {0,1000,1200,1200,1500,1500,1500};
    String boardObtenue[] = LoginActivity.BoardList;
    public void touchboard(View view) {
        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if(boardObtenue[tappedCounter].equals("1")){
            selectedBoard = tappedCounter;
            Toast.makeText(this,"board selected",Toast.LENGTH_LONG).show();
        }
        else if(boardPrice[tappedCounter]<=score){
            score-=boardPrice[tappedCounter];boardObtenue[tappedCounter] = "1" ;
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference(LoginActivity.currentPlayer);
            String userId = myRef.push().getKey();
            String ch = Integer.toString(score);
            String name=" Score: "+score;
            TextView tv=(TextView)findViewById(R.id.scoreTextView);
            tv.setText(name);
            myRef.child("coins").setValue(ch);
            Toast.makeText(this,"CONGRATSSSSSSSSSSS!!!!!",Toast.LENGTH_LONG).show();
            myRef.child("boardowned"+tappedCounter).setValue("1");
            boardObtenue[tappedCounter] = "1";
        }
        else Toast.makeText(this,"score not enough",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_shop);
        String name=" Score: "+LoginActivity.Coins;
        TextView tv=(TextView)findViewById(R.id.scoreTextView);
        tv.setText(name);

    }
}
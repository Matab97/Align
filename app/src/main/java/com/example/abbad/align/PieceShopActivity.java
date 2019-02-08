package com.example.abbad.align;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PieceShopActivity extends AppCompatActivity {
    public static int selectedPiece = 1;
    //il faut verifier que le joueur est connecté pour prendre son score
   // int score=LoginActivity.Score;
int score = Integer.parseInt(LoginActivity.Coins);

    int piecePrice[] = {0,25,25,100,100,150,150,200,200,200,350,350,500};
    String pieceObtenue[] = LoginActivity.PieceList;
    public void touchpiece(View view) {
        Toast.makeText(getApplicationContext(),pieceObtenue[1]+pieceObtenue[2]+pieceObtenue[0],Toast.LENGTH_SHORT).show();
       ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());


        if(pieceObtenue[tappedCounter].equals("1")) {
            Toast.makeText(this,"Piece selected",Toast.LENGTH_LONG).show();
            selectedPiece = tappedCounter;
        }
        else if(piecePrice[tappedCounter]<=score){
            score-=piecePrice[tappedCounter];pieceObtenue[tappedCounter]= "1";
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference(LoginActivity.currentPlayer);
            String userId = myRef.push().getKey();
            String ch = Integer.toString(score);
            String name=" Score: "+score;
            TextView tv=(TextView)findViewById(R.id.scoreTextView1);
            tv.setText(name);
            myRef.child("coins").setValue(ch);
            int f = tappedCounter ;
            myRef.child("skinowned"+f).setValue("1");
            Toast.makeText(this,"CONGRATSSSSSSSSSSS!!!!!",Toast.LENGTH_LONG).show();
            pieceObtenue[tappedCounter] = "1";
        }
        else Toast.makeText(this,"score not enough",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piece_shop);
        String name=" Score: "+LoginActivity.Coins;
        TextView tv=(TextView)findViewById(R.id.scoreTextView1);
        tv.setText(name);
    }
}
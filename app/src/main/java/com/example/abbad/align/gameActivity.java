package com.example.abbad.align;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class gameActivity extends AppCompatActivity {
      public static boolean ts = false;
      MediaPlayer mediaPlayer;
      public static int musiic = 0;
      public static MediaPlayer SoundEffect;
      int i=1;
      public static int j=1;
      public void market(View view) {
          //ts = true;
         Intent intent =new Intent(getApplicationContext(),marketActivity.class);
          startActivity(intent);

      }
   public void clickVsPAi(View view){
        Intent intent =new Intent(getApplicationContext(),vsAiActivity.class);
        startActivity(intent);
    }

public void music(View view) {
    if(i==1 && j==1){
        setContentView(R.layout.musicoff_game);
        i=0;
        mediaPlayer.pause();
    }
    else if (i==0 && j==1){
        setContentView(R.layout.musicsoundon_game);
        i=1;
        mediaPlayer.start();
    }
    else if (i==1 && j==0){
        setContentView(R.layout.musicsoundoff_game);
        i=0;
        mediaPlayer.pause();
    }
    else if (i==0 && j==0){
        setContentView(R.layout.soundoff_game);
        i=1;
        mediaPlayer.start();
    }

}
      public void sound(View view) {
          if(i==1 && j==1){
              setContentView(R.layout.soundoff_game);
              j=0;

          }
          else if (i==0 && j==1){
              setContentView(R.layout.musicsoundoff_game);
              j=0;

          }
          else if (i==1 && j==0){
              setContentView(R.layout.musicsoundon_game);
              j=1;

          }
          else if (i==0 && j==0){
              setContentView(R.layout.musicoff_game);
              j=1;

          }
      }
  public void clickVsPlayer(View view)
    {
        Intent intent =new Intent(getApplicationContext(),vsPlayerActivity.class);
        startActivity(intent);
    }
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // getSupportActionBar().hide();
        setContentView(R.layout.activity_game);
       mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.musicsong);
       SoundEffect = MediaPlayer.create(getApplicationContext(),R.raw.sound);
       if(musiic == 0){
           mediaPlayer.start();
           musiic++;
       }
    }
}

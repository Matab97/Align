package com.example.abbad.align;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


boolean vsplayer;
public static String idd;

    public void signin(View view)
    {
        EditText ide = (EditText)findViewById(R.id.editText);
        String id = ide.getText().toString();
        idd = id ;
        Intent intent =new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
      /*  if (ts) {  Intent intent =new Intent(getApplicationContext(),marketActivity.class);
            startActivity(intent); } */
    }
}

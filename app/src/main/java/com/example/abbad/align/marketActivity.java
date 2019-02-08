package com.example.abbad.align;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class marketActivity extends AppCompatActivity {


    public void boardshop(View view)
    {
        Intent intent =new Intent(getApplicationContext(),BoardShopActivity.class);
        startActivity(intent);
    }
    public void pieceshop(View view)
    {
        Intent intent =new Intent(getApplicationContext(),PieceShopActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
    }
}
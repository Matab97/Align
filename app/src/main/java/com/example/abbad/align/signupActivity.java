package com.example.abbad.align;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class signupActivity extends AppCompatActivity {

        Player user;
        boolean test = false;
    List<Player> list = new ArrayList<Player>();

        public void Onstart() {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("list");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                   list = dataSnapshot.getValue(List.class);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w(TAG, "Failed to read value.", error.toException());
                }
            });}

        public void Onclick(View view)  {
            Toast.makeText(this,"makhdimch",Toast.LENGTH_LONG).show();
            EditText ide = (EditText)findViewById(R.id.editText1);
            EditText passe = (EditText)findViewById(R.id.editText2);

            for (Player Element : list) {
                if (Element.account.equals(ide.toString())) {
                    test = true;
                }

            }
            if (!test) {

                Log.i("value" ,"makhdimch ");
                Toast.makeText(this,"makhdimch",Toast.LENGTH_LONG).show();
                user = new Player(2);
                user.setAccount(ide.toString());
                user.setHachseq(passe.toString());
                list.add(user);
            }
        }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Onstart();
    }
}

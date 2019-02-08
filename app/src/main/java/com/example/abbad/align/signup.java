package com.example.abbad.align;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import static android.content.ContentValues.TAG;

public class signup {
    Player user;
    boolean test;
    List<Player> list;
    void Onstart() {
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

    void Onclick(String id, String pass)  {
        for (Player Element : list) {
            if (Element.account == id) {
                test = true;
            }

        }
        if (!test) {
            user = new Player(2);
            user.account = id;
            user.hachseq = pass;
            list.add(user);
        }
    }
}

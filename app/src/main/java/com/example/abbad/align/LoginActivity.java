package com.example.abbad.align;

import android.content.Intent;
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

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import static android.content.ContentValues.TAG;

public class LoginActivity extends AppCompatActivity {
    Player user;
    public static String Score;
    public static String Coins;
    boolean test = false;
        Player item;
        Player admin = new Player(2);
        List<Player> list = new ArrayList<>();
        List<Player> lit = new ArrayList<Player>();
        Player[] p;
        boolean online=false;
        public  static String currentPlayer;
         String chi;
         String acco;
         int i;
         String account;
         String admail;
         public static String PieceList[] = {"0","0","0","0","0","0"};
         public static String BoardList[] = {"0","0","0","0","0","0"};

    int tab[] = {0,0,0};

/*    public void signup(View view){
        Log.d("value" ,"Minimax: ");
        Toast.makeText(this,"makhdimch",Toast.LENGTH_LONG).show();
        Intent intent =new Intent(getApplicationContext(),signupActivity.class);
        startActivity(intent);
    } */

        public void Onstart() {
            account = MainActivity.idd ;
            //Toast.makeText(getApplicationContext(),MainActivity.idd,Toast.LENGTH_SHORT).show();
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference(account);

            //String userId = myRef.push().getKey();
            /*  myRef.setValue(admin);
            Toast.makeText(this,"added",Toast.LENGTH_LONG).show(); */
            //if(myRef == null)Toast.makeText(getApplicationContext(),"wab....wab..waaab",Toast.LENGTH_SHORT).show();

            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    // DataSnapshot snap = dataSnapshot.child("khalil");
                    DataSnapshot sna = dataSnapshot.child("account");
                    final String acc = sna.getValue(String.class);
                      Toast.makeText(getApplicationContext(),acc,Toast.LENGTH_SHORT).show();
                    Thread timer = new Thread() {
                        public void run() {
                            try {
                                sleep(5000);
                                acco = acc;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    };
                    timer.start();
                    DataSnapshot snaa = dataSnapshot.child("hachseq");
                    String passw = snaa.getValue(String.class);
                    //Toast.makeText(getApplicationContext(),passw,Toast.LENGTH_SHORT).show();
                    chi = passw;
                    DataSnapshot snaaa = dataSnapshot.child("mail");
                    String mail = snaaa.getValue(String.class);
                    //Toast.makeText(getApplicationContext(),mail,Toast.LENGTH_SHORT).show();
                    admail = mail;

                 DataSnapshot snaaaa = dataSnapshot.child("coins");
                    String coins = snaaaa.getValue(String.class);
                    // list.add(post);
                    Coins = coins;
                    String pieceList[] = {"0","0","0","0","0","0","0","0","0","0","0","0","0"};
                    String boardList[] = {"0","0","0","0","0","0","0"};
                    String j;
                    String f;
                    int i=1;
                        DataSnapshot sn1 = dataSnapshot.child("skinowned"+i) ;
                         j = sn1.getValue(String.class);
                        pieceList[i] = j;
                    PieceList = pieceList;
                        DataSnapshot sni1 = dataSnapshot.child("boardowned"+i) ;
                        f = sni1.getValue(String.class);
                        boardList[i] = f;
                        BoardList = boardList;
                    i++;
                         DataSnapshot sn3 = dataSnapshot.child("skinowned"+i) ;
                         j = sn3.getValue(String.class);
                         pieceList[i] = j;
                         PieceList = pieceList;
                         DataSnapshot sni3 = dataSnapshot.child("boardowned"+i) ;
                         f = sni3.getValue(String.class);
                         boardList[i] = f;
                         BoardList = boardList;
                    i++;
                         DataSnapshot sn4 = dataSnapshot.child("skinowned"+i) ;
                         j = sn4.getValue(String.class);
                         pieceList[i] = j;
                         PieceList = pieceList;
                         DataSnapshot sni4 = dataSnapshot.child("boardowned"+i) ;
                         f = sni4.getValue(String.class);
                         boardList[i] = f;
                         BoardList = boardList;
                    i++;
                    DataSnapshot sn5 = dataSnapshot.child("skinowned"+i) ;
                    j = sn5.getValue(String.class);
                    pieceList[i] = j;
                    PieceList = pieceList;
                    DataSnapshot sni5 = dataSnapshot.child("boardowned"+i) ;
                    f = sni5.getValue(String.class);
                    boardList[i] = f;
                    BoardList = boardList;
                    i++;
                        DataSnapshot sn6 = dataSnapshot.child("skinowned"+i) ;
                        j = sn6.getValue(String.class);
                         pieceList[i] = j;
                         PieceList = pieceList;
                         DataSnapshot sni6 = dataSnapshot.child("boardowned"+i) ;
                         f = sni6.getValue(String.class);
                         boardList[i] = f;
                         BoardList = boardList;
                    i++;
                    DataSnapshot sn7 = dataSnapshot.child("skinowned"+i) ;
                    j = sn7.getValue(String.class);
                    pieceList[i] = j;
                    PieceList = pieceList;
                    DataSnapshot sni7 = dataSnapshot.child("boardowned"+i) ;
                    f = sni7.getValue(String.class);
                    boardList[i] = f;
                    BoardList = boardList;
                    i++;
                    DataSnapshot sn8 = dataSnapshot.child("skinowned"+i) ;
                    j = sn8.getValue(String.class);
                    pieceList[i] = j;
                    PieceList = pieceList;i++;
                    DataSnapshot sn9 = dataSnapshot.child("skinowned"+i) ;
                    j = sn9.getValue(String.class);
                    pieceList[i] = j;
                    PieceList = pieceList;i++;
                    DataSnapshot sn10 = dataSnapshot.child("skinowned"+i) ;
                    j = sn10.getValue(String.class);
                    pieceList[i] = j;
                    PieceList = pieceList;i++;
                    DataSnapshot sn11 = dataSnapshot.child("skinowned"+i) ;
                    j = sn11.getValue(String.class);
                    pieceList[i] = j;
                    PieceList = pieceList;i++;
                    DataSnapshot sn12 = dataSnapshot.child("skinowned"+i) ;
                    j = sn12.getValue(String.class);
                    pieceList[i] = j;
                    PieceList = pieceList;i++;
                    DataSnapshot sn13 = dataSnapshot.child("skinowned"+i) ;
                    j = sn13.getValue(String.class);
                    pieceList[i] = j;
                    PieceList = pieceList;

               }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w(TAG, "Failed to read value.", error.toException());
                }
            });
       //     Toast.makeText(getApplicationContext(),Coins,Toast.LENGTH_SHORT).show();
           /* FirebaseDatabase database = FirebaseDatabase.getInstance();
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
            }); */
            }

        public void Onclick1(View view) {
/** Called when the activity is first created. */
            EditText ide = (EditText) findViewById(R.id.editText1);
            EditText passe = (EditText) findViewById(R.id.editText2);
            String mail = ide.getText().toString();
            String hachseq = passe.getText().toString();
            //  String account = "chemli";
            admin.account = account;
            //    String hachseq = "azerty";
            //  String mail = "a.b@c.com";
            admin.hachseq = hachseq;

            i++;
            if (i > 0) {

                Toast.makeText(this, "loading...", Toast.LENGTH_LONG).show();
            }
            /*Toast.makeText(getApplicationContext(), acco, Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), chi, Toast.LENGTH_SHORT).show();*/

            if (acco == null) {
                if (i > 0) {
                    if (i < 5) {
                        Toast.makeText(this, "try again...", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "account not found", Toast.LENGTH_LONG).show();
                    }
                }
            } else {
                if (i > 0) {
                }
                //   Toast.makeText(getApplicationContext(),encryptPassword(chi),Toast.LENGTH_SHORT).show();
                //   Toast.makeText(getApplicationContext(),hachseq,Toast.LENGTH_SHORT).show();
                if (chi.equals(encryptPassword(hachseq)) && admail.equals(mail)) {
                    online = true;
                    currentPlayer = account;
                    Toast.makeText(this, "welcome", Toast.LENGTH_LONG).show();
                } else {
                    if (admail.equals(mail)) {
                        Toast.makeText(this, "password incorrect", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(this, "mail address and ID do not match", Toast.LENGTH_LONG).show();

                    }

                }

            }

            if (online) {
                Intent intent = new Intent(getApplicationContext(), gameActivity.class);
                startActivity(intent);
            }

        }


          /*for (Player Element : list) {
             Toast.makeText(getApplicationContext(),Element.account,Toast.LENGTH_SHORT).show();
                if (Element.account.equals(ide)){
                    if (passe.equals(Element.hachseq))
                    {
                        currentPlayer = Element.account;
                        online = true;
                    }
                }
            }
            if (online) {
                String Score = Coins;
                Toast.makeText(getApplicationContext(),Score,Toast.LENGTH_SHORT).show();
            }
*/
    public void Onclick2(View view) {
        Toast.makeText(this, "loading", Toast.LENGTH_SHORT).show();
         EditText ide = (EditText)findViewById(R.id.editText1);
          EditText pass = (EditText)findViewById(R.id.editText2);
        String mail = ide.getText().toString();
        String passe = pass.getText().toString();
      /*  for (Player Element : list) {
            if (Element.account.equals(ide)) {
                test = true;
            }
            
        } */
            if (acco != null) {
            Toast.makeText(this, "username already exists", Toast.LENGTH_LONG).show();
            }
            else if (((mail.indexOf("@")) == -1) || (((mail.indexOf(".")) == -1))) {
                Toast.makeText(this, "mail format is not correct", Toast.LENGTH_LONG).show();}
            else{
                user = new Player(2);
                user.setAccount(account);
                user.setHachseq(encryptPassword(passe));
                user.mail = mail;
                user.coins = "0";

                //   list.add(user);
               FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference();
                String userId = myRef.push().getKey();
                myRef.child(user.account).setValue(user);

                Toast.makeText(this, "added", Toast.LENGTH_LONG).show();

            }


        }

    private static String encryptPassword(String password)
    {
        String sha1 = "";
        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(password.getBytes("UTF-8"));
            sha1 = byteToHex(crypt.digest());
        }
        catch(NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch(UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return sha1;
    }

    private static String byteToHex(final byte[] hash)
    {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Onstart();
        i=5;

    }

}

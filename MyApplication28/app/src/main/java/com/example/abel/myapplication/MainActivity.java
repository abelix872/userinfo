package com.example.abel.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Firebase firebase;
 DatabaseReference reference;
 RecyclerView recyclerView;
 ArrayList<Holdercls> list;
 Adaptercls adapter;
    EditText username,password,fullname,email,mobile,gender;
    Button register,login,logout,btndetail;
    Datainsert datainsert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText)findViewById(R.id.username);
        mobile=(EditText)findViewById(R.id.mobile);
        email=(EditText)findViewById(R.id.email);
        gender=(EditText)findViewById(R.id.gender);
        password=(EditText)findViewById(R.id.password);
        fullname=(EditText)findViewById(R.id.fullname);
        register=(Button)findViewById(R.id.buttonregis);
        datainsert=new Datainsert();
        firebase = new Firebase(Firebase_Server_URL);
        register.setOnClickListner(new View.onClickListner){
              @Override
            public void onClick(View view){
                  int mobile=Integer.parseInt(mobile.getText().toString().trim());
                  datainsert.setFullname(fullname.getText().toString().trim());
                  datainsert.setMobile(mobile);
                datainsert.setEmail(email.getText().toString().trim());
                datainsert.setGender(gender.getText().toString().trim());
                datainsert.setPassword(password.getText().toString().trim());
                datainsert.setUsername(username.getText().toString().trim());
                reference.push().setValue(datainsert);
            }
        }
        login=(Button)findViewById(R.id.login) ;
        login.setOnClickListner(new View.onClickListner){
            @Override
            public void onClick(View view){
                String username1=dataSnapshot.child("username").getvalue().toString();
                String password1=dataSnapshot.child("username").getvalue().toString();
                String username2=fullname.getText().toString().trim();
                String password2=password.getText().toString().trim()
                if(username1==username2 && password1==password2){
                Intent intent=new Intent(this,cardview.class);
                startActivity(intent);}
            }
        }
        logout=(Button)findViewById(R.id.logout) ;
        logout.setOnClickListner(new View.onClickListner){
            @Override
            public void onClick(View view){
                DatabaseReference ref=FirebaseDatabase.getInstance().getReference().chilc("users");
                ref.removeValue();
                Intent intent=new Intent(this,login.class);
                startActivity(intent);
            }
        }
        btndetail=(Button)findViewById(R.id.btndetail) ;
        btndetail.setOnLongClickListner(new View.onClickListner){
            @Override
            public void onClick(View view){
                String username1=dataSnapshot.child("username").getvalue().toString();
                String password1=dataSnapshot.child("password").getvalue().toString();
                String username2=fullname.getText().toString().trim();
                String password2=password.getText().toString().trim()
                if(username1!=username2 && password1!=password2) {

                DatabaseReference y=FirebaseDatabase.getInstance().getReference(username1).chilc("users");
                y.removeValue();

                }
            }
        }

        recyclerView=(RecyclerView)findViewById(R.id.recycler1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        reference=FirebaseDatabase.getInstance().getInstance().chilc("users");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
 for(DataSnapshot dataSnapshot1;dataSnapshot.getChildren()){
    Holdercls holder=dataSnapshot1.getValue(Holdercls.class);
            list.add(holder);}
            adapter=new Adaptercls(MainActivity.this.list);
       recyclerView.setAdapter(adapter);

 }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
     list=new Arraylist<Holdercls>();
    }
}

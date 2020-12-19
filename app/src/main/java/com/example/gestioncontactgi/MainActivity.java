package com.example.gestioncontactgi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton btn1,btn2,btn3;
    DaoContact daoContact = new DaoContact(this) ;
    protected RecyclerView mRecyclerView;
    protected MyAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected Contact[] mDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1= findViewById(R.id.btnHome);
        btn2= findViewById(R.id.btnRecherche);
      //  btn3= findViewById(R.id.btnAjouter);
     /*Sortir de l'application*/
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

     /* Consulter un contact */
     btn2.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent i1= new Intent(getApplicationContext(),ConsulterContact.class);
             startActivity(i1);
         }
     });
     this.loadContacts();
     mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
     mLayoutManager = new LinearLayoutManager(getApplicationContext());
     mRecyclerView.setLayoutManager(mLayoutManager);
     mAdapter = new MyAdapter(mDataset);
     mRecyclerView.setAdapter(mAdapter);


        /* Ajouter un contact */
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i2= new Intent(getApplicationContext(),AjouterContact.class);
//                startActivity(i2);
//            }
//        });
    }

    public void methode1 (View v){
        Intent i2= new Intent(getApplicationContext(),AjouterContact.class);
        startActivity(i2);
    }
    private void loadContacts() {
        ArrayList<Contact> myList = new ArrayList<Contact>();
        myList = daoContact.allContact();
        mDataset = new Contact[myList.size()];
        for(Contact c : myList){
            mDataset[myList.indexOf(c)]=c;
            Log.d("Loaded",mDataset[myList.indexOf(c)].getPrenomContact());
        }
    }


}
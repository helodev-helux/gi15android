package com.example.gestioncontactgi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class AjouterContact extends AppCompatActivity {
    ImageButton btn1;
    LinearLayout lay1, lay2;
    EditText text1,text2,text3,text4;
    DaoContact d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_contact);

        btn1= findViewById(R.id.btnRetour1);
        lay1= findViewById(R.id.layoutAnnuler);
        lay2= findViewById(R.id.layoutAjouter);

        text1=findViewById(R.id.textNom);
        text2=findViewById(R.id.textPrenom);

        text3=findViewById(R.id.textTel);

        text4=findViewById(R.id.textAdresseMail);

        d= new DaoContact(this);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i1);
            }
        });

        lay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("");
                text2.setText("");
                text3.setText("");
                text4.setText("");
                Intent i1= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i1);
            }
        });


        lay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contact c= new Contact();
                c.setNomContact(text1.getText().toString());
                c.setPrenomContact(text2.getText().toString());
                c.setTelContact(text3.getText().toString());
                c.setMailContact(text4.getText().toString());
                d.AjouterContact(c);
                text1.setText("");
                text2.setText("");
                text3.setText("");
                text4.setText("");

            }
        });



    }
}
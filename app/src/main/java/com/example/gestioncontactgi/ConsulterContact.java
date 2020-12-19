package com.example.gestioncontactgi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ConsulterContact extends AppCompatActivity implements View.OnClickListener {
    ImageButton btn1;
    EditText code ,nom,prenom,tel,mail;
    LinearLayout mod, laydel;
    Button btnOk, btnSave;
    DaoContact d;
    String prevCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulter_contact);

        mod = findViewById(R.id.layoutModifier);
        laydel = findViewById(R.id.layoutSupprimer);
        btn1= findViewById(R.id.btnRetour2);
        d=new DaoContact(this);
        btnOk= findViewById(R.id.btnRech);
        btnSave = findViewById(R.id.btnSave);
        nom= findViewById(R.id.nomVal);
        prenom=findViewById(R.id.prenomVal);
        tel= findViewById(R.id.telVal);
        mail=findViewById(R.id.mailVal);
        code= findViewById(R.id.textCode);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i1);
            }
        });


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s= code.getText().toString();
                prevCode=s;
                int c= Integer.parseInt(s);
                Contact ct= d.ConsulterUnContact(c);
                nom.setText(ct.getNomContact());
                prenom.setText(ct.getPrenomContact());
                tel.setText(ct.getTelContact());
                mail.setText(ct.getMailContact());
            }
        });

        mod.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        laydel.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.layoutModifier){
            nom.setEnabled(true);
            prenom.setEnabled(true);
            tel.setEnabled(true);
            mail.setEnabled(true);
            btnSave.setEnabled(true);
            btnSave.setVisibility(View.VISIBLE);

        }
        else if (v.getId()==R.id.btnSave ){
            Log.d("Save","1");
            if(!code.getText().toString().isEmpty()){
                Log.d("Save","2");
                Contact c = new Contact();
                c.setCodeContact(Integer.parseInt(code.getText().toString()));
                c.setNomContact(nom.getText().toString());
                c.setPrenomContact(prenom.getText().toString());
                c.setMailContact(mail.getText().toString());
                c.setTelContact(tel.getText().toString());
                d.AlterContact(c);
                nom.setEnabled(false);
                prenom.setEnabled(false);
                tel.setEnabled(false);
                mail.setEnabled(false);
                btnSave.setEnabled(false);
                btnSave.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(),"Successfully modified",Toast.LENGTH_SHORT);
            }

        }
        else if(v.getId()==R.id.layoutSupprimer){
            if(!code.getText().toString().isEmpty()){
                d.delContact(Integer.parseInt(code.getText().toString()));
                Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_SHORT);
                Intent i1= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i1);
            }
        }
    }
    private void alter(){

    }
}
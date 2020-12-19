package com.example.gestioncontactgi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DaoContact extends SQLiteOpenHelper {
      private static final int DB_VERSION=1;
      private static final String DB_NAME="DBContacts";
      private static final String CODE_CONTACT="codeContact";
      private static final String NOM_CONTACT="nomContact";
      private static final String PRENOM_CONTACT="prenomContact";
      private static final String TEL_CONTACT="telContact";
      private static final String MAIL_CONTACT="mailContact";
      private static final String NOM_CONTACTS_TABLE="Contacts";

    public DaoContact(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String req= "CREATE TABLE Contacts ("+"codeContact INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "nomContact TEXT, "+"prenomContact TEXT, "+"telContact TEXT, "
                +"mailContact TEXT)";
        db.execSQL(req);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
           db.execSQL("DROP TABLE IF EXISTS Contacts");
           this.onCreate(db);
    }

    public void AjouterContact(Contact c){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues v= new ContentValues();
        v.put(NOM_CONTACT,c.getNomContact());
        v.put(PRENOM_CONTACT,c.getPrenomContact());
        v.put(TEL_CONTACT,c.getTelContact());
        v.put(MAIL_CONTACT,c.getMailContact());
        db.insert(NOM_CONTACTS_TABLE,null,v);
        db.close();
    }

    public Contact ConsulterUnContact (int code){
        SQLiteDatabase db= this.getReadableDatabase();

        Cursor c= db.query(NOM_CONTACTS_TABLE,
                new String[]{CODE_CONTACT,NOM_CONTACT,PRENOM_CONTACT,TEL_CONTACT,MAIL_CONTACT},
                "codeContact=?",
                new String[]{String.valueOf(code)},
                null, null,null,null
        );
        if(c!=null) c.moveToNext();
        Contact contact= new Contact();
        contact.setCodeContact(Integer.parseInt(c.getString(0)));
        contact.setNomContact(c.getString(1));
        contact.setPrenomContact(c.getString(2));
        contact.setTelContact(c.getString(3));
        contact.setMailContact(c.getString(4));
        return contact;
    }

    public void AlterContact(Contact cc){
        SQLiteDatabase db= this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("codeContact",cc.getCodeContact());
        values.put("nomContact",cc.getNomContact());
        values.put("telContact",cc.getTelContact());
        values.put("mailContact",cc.getMailContact());
        values.put("prenomContact",cc.getPrenomContact());

        db.update(NOM_CONTACTS_TABLE,
                values,
                "codeContact=?",
                new String[]{String.valueOf(cc.getCodeContact())});

    }
    public void delContact(int code){
        SQLiteDatabase db= this.getReadableDatabase();
        db.delete(NOM_CONTACTS_TABLE,"codeContact=?",new String[]{String.valueOf(code)});
    }

    public ArrayList<Contact> allContact (){

        SQLiteDatabase db= this.getReadableDatabase();

        Cursor c= db.query(NOM_CONTACTS_TABLE,
                new String[]{CODE_CONTACT,NOM_CONTACT,PRENOM_CONTACT,TEL_CONTACT,MAIL_CONTACT},
                null,
                null,
                null, null,null,null
        );
        ArrayList<Contact> MyList = new ArrayList<Contact>();
        while (c.moveToNext()){
            Contact contact= new Contact();
            contact.setCodeContact(Integer.parseInt(c.getString(0)));
            contact.setNomContact(c.getString(1));
            contact.setPrenomContact(c.getString(2));
            contact.setTelContact(c.getString(3));
            contact.setMailContact(c.getString(4));
            MyList.add(contact);
            Log.d("taken",c.getString(1));
        }
        c.close();

        return MyList;
    }


}

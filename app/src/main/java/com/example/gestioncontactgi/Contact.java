package com.example.gestioncontactgi;

public class Contact {
    private int codeContact;
    private String nomContact, prenomContact, telContact, mailContact;

    public int getCodeContact() {
        return codeContact;
    }

    public String getNomContact() {
        return nomContact;
    }

    public String getPrenomContact() {
        return prenomContact;
    }

    public String getTelContact() {
        return telContact;
    }

    public String getMailContact() {
        return mailContact;
    }

    public void setCodeContact(int codeContact) {
        this.codeContact = codeContact;
    }

    public void setNomContact(String nomContact) {
        this.nomContact = nomContact;
    }

    public void setPrenomContact(String prenomContact) {
        this.prenomContact = prenomContact;
    }

    public void setTelContact(String telContact) {
        this.telContact = telContact;
    }

    public void setMailContact(String mailContact) {
        this.mailContact = mailContact;
    }

    public Contact(String nomContact, String prenomContact, String telContact, String mailContact) {
        this.nomContact = nomContact;
        this.prenomContact = prenomContact;
        this.telContact = telContact;
        this.mailContact = mailContact;
    }

    public Contact() {
    }
}

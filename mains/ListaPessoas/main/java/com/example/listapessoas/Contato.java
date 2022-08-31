package com.example.listapessoas;

import java.io.Serializable;

public class Contato implements Serializable {

    private String nome;
    private String tele;
    private String mail;
    private long id;

    public Contato(String nome, String tele, String mail, long id) {
        this.nome = nome;
        this.tele = tele;
        this.mail = mail;
        this.id = id;
    }

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getTele() {return tele;}
    public void setTele(String tele) {this.tele = tele;}

    public String getMail() {return mail;}
    public void setMail(String mail) {this.mail = mail;}

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
}

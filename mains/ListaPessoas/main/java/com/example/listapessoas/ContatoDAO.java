package com.example.listapessoas;

import android.database.sqlite.SQLiteDatabase;

public class ContatoDAO implements IContatoDAO{

    private SQLiteDatabase leitura;
    private SQLiteDatabase escrita;

    public ContatoDAO(Context context) {
        DbHelper helper = new DbHelper(context);
        leitura = helper.getReadableDatabase();
        escrita = helper.getWritableDatabase();
    }

    @Override
    public boolean salvar (Contato contato) {
        
    }

}

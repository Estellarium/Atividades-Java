package com.example.listapessoas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    static final int VERSION = 1;
    static final String NOME_DB = "DB_CONTATOS";
    static final String TABELA_CONTATOS = "contatos";

    public DbHelper(@Nullable Context context) { super(context, NOME_DB, null, VERSION);}

    @Override
    public void OnCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_CONTATOS +
                "(id INTEGER PRIMARY KEY AUTO INCREMENT, " +
                "ContatoNome TEXT NOT NULL, " + "ContatoMail TEXT, " +
                "ContatoTele TEXT NOT NULL);" ;
        SQLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void OnUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS " + TABELA_CONTATOS + ";";
        SQLiteDatabase.execSQL(sql);
    }
}

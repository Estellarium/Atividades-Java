package com.example.myblocodenotas;

import android.content.Context;
import android.content.SharedPreferences;

public class Anotacao {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private static final String ARQUIVO_REFERENCIA = "anotacao";
    private static final String CHAVE_ARQUIVO = "nome";

    public Anotacao(Context context) {
        this.context = context;
        this.preferences = context.getSharedPreferences(ARQUIVO_REFERENCIA, Context.MODE_PRIVATE);
        this.editor = this.preferences.edit();
    }

    public void salvarAnotacao(String anotacao) {
        this.editor.putString(CHAVE_ARQUIVO, anotacao);
        this.editor.commit();
    }

    public String abrirAnotacao() {
        String anotacao = this.preferences.getString(CHAVE_ARQUIVO,"");
        return anotacao;
    }

    public void limparAnotacao() {
        this.editor.clear();
        this.editor.commit();
    }

}

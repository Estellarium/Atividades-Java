package com.example.meuprojeto;
import android.graphics.Color;
import android.widget.Button;

public class BotaoJogo extends Button{
    private boolean ligado = false;
    private BotaoJogo[] vizinhos = {null, null, null, null};

    //public BotaoJogo() {}

    public void addNeigh(BotaoJogo[] btn) {
        for (int i = 0; i < 4; i++)
            vizinhos[i] = btn[i];
    }

    public void trocaCor(boolean apertado) {
        if (ligado) {this.setBackgroundColor(Color.YELLOW); ligado = false;}
        else {this.setBackgroundColor(Color.BLUE); ligado = true;}

        if (apertado)
            for (BotaoJogo x:vizinhos)
                if (x!=null)
                    x.trocaCor(false);
    }
}

package com.example.meuprojeto;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;

public class BotaoJogo extends AppCompatButton {

    private boolean ligado = true;
    public BotaoJogo[] vizinhos = {null, null, null, null};

    //Constructors
    public BotaoJogo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);}
    public BotaoJogo(Context context, AttributeSet attrs) {super(context, attrs);}
    public BotaoJogo(Context context) {super(context);}
    //

    public void addNeigh(BotaoJogo[] btn) {
        System.arraycopy(btn, 0, vizinhos, 0, 4);
    }

    public void trocaCor(boolean apertado) {
        if (ligado) {this.setBackgroundColor(Color.YELLOW); ligado = false;}
        else {this.setBackgroundColor(Color.BLUE); ligado = true;}

        if (apertado)
            for (BotaoJogo x : vizinhos)
                if (x!=null) x.trocaCor(false);
    }
}


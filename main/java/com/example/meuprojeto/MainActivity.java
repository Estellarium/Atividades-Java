package com.example.meuprojeto;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    BotaoJogo[] btn = new BotaoJogo[9];
    int[] btnIDs = {R.id.bt1, R.id.bt2, R.id.bt3, R.id.bt4, R.id.bt5, R.id.bt6, R.id.bt7, R.id.bt8, R.id.bt9};

    private void buttonSetup() {

        for (int i = 0; i < btn.length; i++)
            btn[i] = findViewById(btnIDs[i]);

        btn[0].addNeigh(new BotaoJogo[]{btn[1],btn[3],null,null});
        btn[1].addNeigh(new BotaoJogo[]{btn[0],btn[2],btn[4],null});
        btn[2].addNeigh(new BotaoJogo[]{btn[1],btn[5],null,null});
        btn[3].addNeigh(new BotaoJogo[]{btn[0],btn[4],btn[6],null});
        btn[4].addNeigh(new BotaoJogo[]{btn[1],btn[3],btn[5],btn[7]});
        btn[5].addNeigh(new BotaoJogo[]{btn[2],btn[4],btn[8],null});
        btn[6].addNeigh(new BotaoJogo[]{btn[3],btn[7],null,null});
        btn[7].addNeigh(new BotaoJogo[]{btn[4],btn[6],btn[8],null});
        btn[8].addNeigh(new BotaoJogo[]{btn[5],btn[7],null,null});

        for (BotaoJogo bt : btn)
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {bt.trocaCor(true);}
            });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSetup();
    }
}

package com.example.appcompras;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgProdutos,rgDesconto;
    private CheckBox ckArroz,ckCarne,ckPao,ckLeite,ckOvos;
    private RadioButton zero,cinco,dez,quinze;
    private TextView txtValor;
    private Button btnTotal,btnPagar;
    private EditText edtValor;
    private float valor = 0;

    //Abreviação do Toast
    private void Toasty(String msg) {
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgProdutos= findViewById(R.id.rgProdutos);
        rgDesconto= findViewById(R.id.rgDesconto);
        ckArroz   = findViewById(R.id.ckArroz);
        ckCarne   = findViewById(R.id.ckCarne);
        ckPao     = findViewById(R.id.ckPao);
        ckLeite   = findViewById(R.id.ckLeite);
        ckOvos    = findViewById(R.id.ckOvos);
        zero      = findViewById(R.id.rb0);
        cinco     = findViewById(R.id.rb5);
        dez       = findViewById(R.id.rb10);
        quinze    = findViewById(R.id.rb15);
        txtValor  = findViewById(R.id.txtValor);
        btnTotal  = findViewById(R.id.btnTotal);
        btnPagar  = findViewById(R.id.btnPagar);
        edtValor  = findViewById(R.id.edtValor);

        CheckBox[] checks = {ckArroz,ckCarne,ckPao,ckLeite,ckOvos};
        Map <CheckBox, Float> precos = new HashMap<CheckBox, Float>();
        precos.put(ckArroz, 3.5f);
        precos.put(ckCarne, 12.3f);
        precos.put(ckPao, 2.2f);
        precos.put(ckLeite, 5.5f);
        precos.put(ckOvos, 7.5f);

        btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valor = 0;
                for (CheckBox x : checks)
                    if (x.isChecked()) valor += precos.get(x);
                if (valor == 0) {
                    Toasty("Escolha ao menos um produto!");
                    return;
                }
                String total = String.format("Valor: %.2f",valor);
                txtValor.setText(total);
            }
        });

        btnPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Definir valor se não clicar em Total
                valor = 0;
                for (CheckBox x : checks)
                    if (x.isChecked()) valor += precos.get(x);

                float desc = 0;
                switch (rgDesconto.getCheckedRadioButtonId()) {
                    case R.id.rb5 : desc = 5 ; break;
                    case R.id.rb10: desc = 10; break;
                    case R.id.rb15: desc = 15; break;
                    default: desc = 0;
                }
                float valDesc = ((1-(desc/100))*valor);
                String unparsed = edtValor.getText().toString();
                if (valor == 0) {
                    Toasty("Escolha ao menos um produto!");
                    return;
                }
                if (unparsed.isEmpty()) {
                    Toasty("Insira um valor!");
                } else {
                    float pago = Float.parseFloat(unparsed);
                    if (pago < valDesc)
                        Toasty("Valor insuficiente!");
                    else {
                        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                        //alerta.setIcon(R.mipmap.minipizza);
                        alerta.setTitle("Compra realizada com sucesso");
                        String result = "";
                        result = String.format(
                                "Valor da compra: R$%.2f\n" +
                                        "Desconto: %.0f%s\n" +
                                        "Valor com desconto: R$%.2f\n" +
                                        "Valor pago: R$%.2f\n" +
                                        "Troco: R$%.2f",
                                valor,desc,"%",valDesc,pago,(pago-valDesc)
                        );
                        alerta.setMessage(result);
                        alerta.setNeutralButton("OK", null);
                        alerta.show();
                    }
                }
            }
        });

    }
}
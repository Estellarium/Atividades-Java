package com.example.imc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.*;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private float calcularIMC(EditText p, EditText a){
        float peso = Float.parseFloat(p.getText().toString());
        float alt  = Float.parseFloat(a.getText().toString());
        if (alt>10) alt /= 100;
        if (alt == 0) return 0;
        float IMC = peso/(alt*alt);
        return IMC;
    }

    private String message(int opcao, float imc) {
        String msg = "";
        if (opcao==R.id.rbMasculino){
            if (imc < 20){
                msg = "Abaixo do normal";
            } else if  ((imc >= 20) && (imc <= 24.9)){
                msg = "Normal";
            }else if ((imc>24.9)&&(imc <=29.9)){
                msg="Obesidade leve";
            } else if ((imc >29.9)&&(imc<=43)){
                msg ="Obesidade moderada";
            } else msg ="Obesidade Morbida";
        }
        else {
            if (imc < 19){
                msg = "Abaixo do normal";
            } else if  ((imc >= 19) && (imc <= 23.9)){
                msg = "Normal";
            }else if ((imc>23.9)&&(imc <=28.9)){
                msg="Obesidade leve";
            } else if ((imc >28.9)&&(imc<=39)){
                msg ="Obesidade moderada";
            } else msg ="Obesidade Morbida";
        }
        return msg;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText nome = findViewById(R.id.edtNome);
        EditText peso = findViewById(R.id.edtPeso);
        EditText altura = findViewById(R.id.edtAltura);
        RadioGroup grupo = findViewById(R.id.group);
        RadioButton mas = findViewById(R.id.rbMasculino);
        RadioButton fem = findViewById(R.id.rbFeminino);
        Button calc = findViewById(R.id.btCalcular);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nome.getText().toString();
                float imc = calcularIMC(peso,altura);
                int opcao = grupo.getCheckedRadioButtonId();
                String msg = message(opcao, imc);
                AlertDialog.Builder janela = new AlertDialog.Builder(MainActivity.this);
                janela.setTitle(R.string.app_name);
                janela.setMessage(String.format("%s\nIMC = %.2f\n%s\n",name,imc,msg));
                janela.show();
            }
        });
    }
}
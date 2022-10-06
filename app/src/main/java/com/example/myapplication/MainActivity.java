package com.example.myapplication;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TextView resultado;
    EditText display;
    RadioGroup grupoRadio;
    RadioButton celsius;
    RadioButton farenh;
    RadioButton rButton;
    Button converter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = findViewById(R.id.resultado);
        display = findViewById(R.id.display);
        grupoRadio = findViewById(R.id.grupoTemp);
        celsius = findViewById(R.id.radioButton);
        farenh = findViewById(R.id.radioButton2);
        converter = findViewById(R.id.button);

        converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valor = display.getText().toString();
                Double numero;
                Double conversao;
                String temp = "";

                int radioButtonSelected = grupoRadio.getCheckedRadioButtonId();
                rButton = findViewById(radioButtonSelected);
                String tempSelecionada = rButton.getText().toString();
                temp = tempSelecionada;

                if(temp.contains("Celsius - Fahrenheit")){
                    numero = Double.parseDouble(valor);
                    conversao = numero * (9.0/5.0) + 32.0;
                    resultado.setText(conversao.toString() + " ºF");
                }else if(temp.contains("Fahrenheit - Celsius")) {
                    numero = Double.parseDouble(valor);
                    conversao = (numero - 32.0) * (5.0 / 9.0);
                    resultado.setText(conversao.toString() + " ºC");
                }
            }
        });
    }
}
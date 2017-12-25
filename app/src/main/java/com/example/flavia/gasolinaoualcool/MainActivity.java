package com.example.flavia.gasolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText precoAlcool;
    private EditText precoGasolina;
    private Button botaoVerificar;
    private TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool = (EditText) findViewById(R.id.precoAlcoolId);
        precoGasolina = (EditText) findViewById(R.id.precoGasolinaId);
        botaoVerificar = (Button) findViewById(R.id.botaoVerificarId);
        textoResultado = (TextView) findViewById(R.id.textoResultadoId);

        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String textoPrecoGasolina = precoGasolina.getText().toString();
                    String textoPrecoAlcool = precoAlcool.getText().toString();
                    if (textoPrecoGasolina.isEmpty()) {
                        precoGasolina.setError("Campo vazio!");
                    }
                    if (textoPrecoAlcool.isEmpty()) {
                        precoAlcool.setError("Campo vazio!");
                    }
                    Double valorAlcool = Double.parseDouble(textoPrecoAlcool);
                    Double valorGasolina = Double.parseDouble(textoPrecoGasolina);

                    double resultado = valorAlcool / valorGasolina;

                    if (resultado >= 0.7) {
                        textoResultado.setText("É melhor utilizar Gasolina.");
                    } else {
                        textoResultado.setText("É melhor utilizar Alcool.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}

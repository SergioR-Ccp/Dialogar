package com.example.dialogar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BotaoCheck extends BotaoBase {


    public BotaoCheck(Button button){
        super(button);
    }

    @Override
    public void configurarOnClickListener(MainActivity activity) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoCompleto = activity.getSaida().getText().toString();
                Log.i("BotaoCheck", "Texto completo: " + textoCompleto);
                Toast.makeText(activity, "Texto: " + textoCompleto,
                        Toast.LENGTH_LONG).show();
            }

        });

    }

}






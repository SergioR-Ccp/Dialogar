package com.example.dialogar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BotaoTrash extends BotaoBase {

    public BotaoTrash(Button button){

        super(button);
    }

    //Metodo Apagar Palavra (COnfigurar Comportamento)
    @Override
    public void configurarOnClickListener(MainActivity activity) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String textoCompleto = activity.getSaida().getText().toString();
                Log.i("BotaoTrash", "Apagar: " + textoCompleto);
                activity.limparCliques(); //Limpar listas de clicks no MAIN
                activity.atualizarTextView();
                activity.limparimagem();

            }

        });

    }

}






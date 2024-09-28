package com.example.dialogar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> cliques = new ArrayList<>();
    TextView saida;

    // Define o layout da tela
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Encontrando saída de texto
        saida = findViewById(R.id.textViewl);

        Button btnTrash = findViewById(R.id.trash);
        Button btnCheck = findViewById(R.id.conf);

        //Criando Array De Botões e associando Ids
        int[] buttonIds = {R.id.buttonA, R.id.buttonB, R.id.buttonC, R.id.buttonD, R.id.buttonE,
                R.id.buttonF, R.id.buttonG, R.id.buttonH, R.id.buttonI, R.id.buttonJ, R.id.buttonK,
                R.id.buttonL, R.id.buttonM, R.id.buttonN, R.id.buttonO, R.id.buttonP, R.id.buttonQ
                , R.id.buttonR, R.id.buttonS, R.id.buttonT, R.id.buttonU, R.id.buttonV, R.id.buttonW
                , R.id.buttonX, R.id.buttonY, R.id.buttonZ};

        Button[] buttons = new Button[buttonIds.length];


        // Definindo um único listener para todos os botões
        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button clickedButton = (Button) view;
                String buttonText = clickedButton.getText().toString();
                Log.i("Button Clicked", buttonText);
                cliques.add(buttonText);
                atualizarTextView(); // Chama o método para atualizar a TextView
            }
        };

        // Definindo o listener para o botão de confirmação (check)
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoCompleto = saida.getText().toString();
                Log.i("btnCheck", "Texto completo: " + textoCompleto);
                Toast.makeText(MainActivity.this, "Texto: " + textoCompleto, Toast.LENGTH_LONG).show();
            }
        });

        // Definindo o listener para o botão de apagar (trash)
        btnTrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("btnTrash", "Apagar");
                cliques.clear();  // Limpa a lista de cliques
                atualizarTextView(); // Atualiza a TextView para refletir a lista vazia
            }
        });

        // Inicializando os botões e atribuindo o listener
        for (int i = 0; i < buttonIds.length; i++) {
            buttons[i] = findViewById(buttonIds[i]);

            buttons[i].setOnClickListener(buttonClickListener);
        }

    }

    private void atualizarTextView(){
        StringBuilder texto = new StringBuilder();
        for (String clique : cliques) {
            texto.append(clique);
        }
        saida.setText(texto.toString());
    }

}
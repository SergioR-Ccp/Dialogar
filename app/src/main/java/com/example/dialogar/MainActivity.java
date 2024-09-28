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

        int[] buttonIds = {R.id.buttonA, R.id.buttonB, R.id.buttonC, R.id.buttonD};
        Button[] buttons = new Button[buttonIds.length];

        // Encontrando botão de confirmação
        // Button btnCheck = findViewById(R.id.check);

        // Encontrando botãos
        Button btnA = findViewById(R.id.buttonA);
        Button btnB = findViewById(R.id.buttonB);
        Button btnC = findViewById(R.id.buttonC);
        Button btnD = findViewById(R.id.buttonD);
        Button btnE = findViewById(R.id.buttonE);
        Button btnF = findViewById(R.id.buttonF);
        Button btnG = findViewById(R.id.buttonG);
        Button btnH = findViewById(R.id.buttonH);
        Button btnI = findViewById(R.id.buttonI);
        Button btnJ = findViewById(R.id.buttonJ);
        Button btnK = findViewById(R.id.buttonK);
        Button btnL = findViewById(R.id.buttonL);
        Button btnM = findViewById(R.id.buttonM);
        Button btnN = findViewById(R.id.buttonN);
        Button btnO = findViewById(R.id.buttonO);
        Button btnP = findViewById(R.id.buttonP);
        Button btnQ = findViewById(R.id.buttonQ);
        Button btnR = findViewById(R.id.buttonR);
        Button btnS = findViewById(R.id.buttonS);
        Button btnT = findViewById(R.id.buttonT);
        Button btnU = findViewById(R.id.buttonU);
        Button btnV = findViewById(R.id.buttonV);
        Button btnW = findViewById(R.id.buttonW);
        Button btnX = findViewById(R.id.buttonX);
        Button btnY = findViewById(R.id.buttonY);
        Button btnZ = findViewById(R.id.buttonZ);


        // Implementação do clique btnA
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("btnA", "A");
                Toast.makeText(MainActivity.this, "A", Toast.LENGTH_LONG).show();
                cliques.add("A");
                atualizarTextView();
            }
        });

        // Implementação do clique do btnB
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("btnB", "B");
                Toast.makeText(MainActivity.this, "B", Toast.LENGTH_SHORT).show();
                cliques.add("B");
                atualizarTextView();
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("btnC", "C");
                Toast.makeText(MainActivity.this, "C", Toast.LENGTH_SHORT).show();
                cliques.add("C");
                atualizarTextView();
            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("btnD", "D");
                Toast.makeText(MainActivity.this, "D", Toast.LENGTH_SHORT).show();
                cliques.add("D");
                atualizarTextView();
            }
        });


    }

    private void atualizarTextView(){
        StringBuilder texto = new StringBuilder();
        for (String clique : cliques) {
            texto.append(clique);
        }
        saida.setText(texto.toString());
    }

}
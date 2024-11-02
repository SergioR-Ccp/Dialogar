package com.example.dialogar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Letra> cliques = new ArrayList<>();
    TextView saida;
    BotaoCheck botaoCheck;
    BotaoTrash botaoTrash;
    ImageView imagem;

    // Mapeamento de palavras para imagens
    HashMap <String, Integer> palavraImg = new HashMap<>();


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

        imagem = findViewById(R.id.imageView2); // Para exibir a imagem


        Button btnTrash = findViewById(R.id.trash);
        Button btnCheck = findViewById(R.id.conf);

        //Estrtura feita de forma horrosa por culpa de um merda <3
        botaoCheck = new BotaoCheck(btnCheck);
        botaoTrash = new BotaoTrash(btnTrash);


        //Mais um espaçamento de merda by Lucas Guima <====3
        // Preencher o HashMap com palavras e IDs de imagens
        palavraImg.put("macaco", R.drawable.monkey);
        palavraImg.put("passaro", R.drawable.bird);
        palavraImg.put("casa", R.drawable.home);
        palavraImg.put("comida", R.drawable.comida);
        palavraImg.put("alegria", R.drawable.alegria);
        palavraImg.put("sono", R.drawable.sono);
        palavraImg.put("burro", R.drawable.burro);
        palavraImg.put("jacare", R.drawable.jaca);
        palavraImg.put("nojo", R.drawable.nojo);
        palavraImg.put("ansiedade", R.drawable.ansiedade );
        palavraImg.put("ansioso", R.drawable.ansiedade );
        palavraImg.put("rato", R.drawable.rat);
        palavraImg.put("cachorro", R.drawable.dog);
        palavraImg.put("fome", R.drawable.fome);
        palavraImg.put("nao", R.drawable.nao);
        palavraImg.put("tristeza", R.drawable.triste);
        palavraImg.put("triste", R.drawable.triste);
        palavraImg.put("cavalo", R.drawable.cavalo);
        palavraImg.put("tv", R.drawable.tv);
        palavraImg.put("sim", R.drawable.sim);
        palavraImg.put("medo", R.drawable.medo);
        palavraImg.put("raiva", R.drawable.raiva);
        palavraImg.put("bravo", R.drawable.raiva);
        palavraImg.put("vergonha", R.drawable.vergonha);
        palavraImg.put("preguica", R.drawable.preguica);
        palavraImg.put("familia", R.drawable.familia);




//burro
        //Configurar comportamento
        botaoCheck.configurarOnClickListener(this);
        botaoTrash.configurarOnClickListener(this);


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
                cliques.add(new Letra(buttonText));
                atualizarTextView(); // Chama o método para atualizar a TextView
            }
        };



        // Inicializando os botões e atribuindo o listener
        for (int i = 0; i < buttonIds.length; i++) {
            buttons[i] = findViewById(buttonIds[i]);

            buttons[i].setOnClickListener(buttonClickListener);
        }

        // Configura o listener do botão Check para confirmar a palavra e exibir a imagem
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String palavraFormada = obterPalavraFormada();
                confirmarPalavra(palavraFormada);
            }
        });
    }

    // Atualizar cada valor de acordo com a letra
    public void atualizarTextView(){
        StringBuilder texto = new StringBuilder();
        for (Letra letra: cliques) {
            texto.append(letra.getValor()); //Obtendo o valor de cada letra, usando a classe "Letra"

        }
        saida.setText(texto.toString());
    }

    // Obter a palavra formada com os cliques
    public String obterPalavraFormada() {
        StringBuilder texto = new StringBuilder();
        for (Letra letra : cliques) {
            texto.append(letra.getValor());
        }
        return texto.toString().toLowerCase();
    }

    // Confirmar a palavra e exibir a imagem correspondente
    public void confirmarPalavra(String palavra) {
        if (palavraImg.containsKey(palavra)) {
            imagem.setImageResource(palavraImg.get(palavra));  // Exibir a imagem correspondente
        } else {
            Toast.makeText(this, "Palavra não encontrada!", Toast.LENGTH_SHORT).show();
            imagem.setImageResource(0);  // Limpar a imagem se a palavra não for encontrada
        }
    }


    public TextView getSaida(){

        return  saida;

    }

    public void limparCliques(){

        cliques.clear();

    }

    public void limparimagem(){
        //Limpa imagem paizaooo
        imagem.setImageResource(0);

    }

}
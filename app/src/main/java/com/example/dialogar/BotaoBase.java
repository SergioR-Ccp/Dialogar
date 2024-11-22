package com.example.dialogar;

import android.view.View;
import android.widget.Button;

public abstract class BotaoBase {

    protected Button button;

    public BotaoBase(Button button){
        this.button = button;
    }

    // Método abstrato para o burro do Sergio entender
    public abstract void configurarOnClickListener(MainActivity activity);

    public Button getButton() {
        return button;
    }
}
